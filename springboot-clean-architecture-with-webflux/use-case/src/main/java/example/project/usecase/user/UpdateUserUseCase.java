package example.project.usecase.user;

import example.project.entity.CoreException;
import example.project.entity.Identity;
import example.project.entity.User;
import example.project.usecase.GenericUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateUserUseCase implements GenericUseCase<Mono<UpdateUserUseCase.Input>, UpdateUserUseCase.Output> {
    private final UserRepository userRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;
    @Override
    public Output execute(Mono<Input> request) {
        Mono<User> result = this.getUserByIdUseCase.execute(request.map(x->new GetUserByIdUseCase.Input(x.userId())))
                .result()
                .flatMap(__ -> request.map(Input::toUser).flatMap(this.userRepository::persist))
                .switchIfEmpty(Mono.error(new CoreException("User not found")))
                .onErrorMap(x-> {
                    if(!(x instanceof CoreException)){
                        return new CoreException("Unexpected Error");
                    }
                    else return x;
                })
                .cast(User.class);
        return new Output(result);
    }

    public record Input(Identity userId, String userName, String password, String address) {
        public User toUser(){
            return new User(userId, userName, password, address, false);
        }
    }

    public record Output(Mono<User> result) { }
}
