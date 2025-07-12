package example.project.usecase.user;

import example.project.entity.CoreException;
import example.project.entity.User;
import example.project.usecase.GenericUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateNewUserUseCase implements GenericUseCase<Mono<CreateNewUserUseCase.Input>, CreateNewUserUseCase.Output> {
    private final UserRepository userRepository;
    private final GetUserByUserNameUseCase getUserByUserNameUseCase;
    @Override
    public Output execute(Mono<Input> request) {
        Mono<User> result =
                this.getUserByUserNameUseCase.execute(request.map(user -> new GetUserByUserNameUseCase.Input(user.userName())))
                .result()
                .flatMap(__ -> Mono.error(new CoreException("User already exists")))
                .switchIfEmpty(request.map(Input::createFromInput).flatMap(this.userRepository::persist))
                .onErrorMap(x-> {
                    if(!(x instanceof CoreException)){
                        x.printStackTrace();
                        return new CoreException("Unexpected Error");
                    }

                    else return x;
                })
                .cast(User.class);
        return new Output(result);
    }

    public record Input(String userName, String password, String address) {
        User createFromInput(){
            return User.create(userName, password, address, false);
        }
    }

    public record Output(Mono<User> result) { }
}
