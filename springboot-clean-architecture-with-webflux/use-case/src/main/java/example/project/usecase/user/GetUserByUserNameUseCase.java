package example.project.usecase.user;

import example.project.entity.CoreException;
import example.project.entity.User;
import example.project.usecase.GenericUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetUserByUserNameUseCase implements GenericUseCase<Mono<GetUserByUserNameUseCase.Input>, GetUserByUserNameUseCase.Output> {
    private final UserRepository userRepository;
    @Override
    public Output execute(Mono<Input> request) {
        return new Output(request.map(Input::userName).flatMap(this.userRepository::findByUserName));
    }

    public record Input(String userName) {
    }

    public record Output(Mono<User> result) { }
}
