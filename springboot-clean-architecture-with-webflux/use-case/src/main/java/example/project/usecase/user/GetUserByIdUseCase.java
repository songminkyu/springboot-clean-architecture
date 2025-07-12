package example.project.usecase.user;

import example.project.entity.Identity;
import example.project.entity.User;
import example.project.usecase.GenericUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetUserByIdUseCase implements GenericUseCase<Mono<GetUserByIdUseCase.Input>, GetUserByIdUseCase.Output> {
    private final UserRepository userRepository;
    @Override
    public Output execute(Mono<Input> request) {
        return new Output(request.map(Input::id).flatMap(this.userRepository::findByUserId));
    }

    public record Input(Identity id) {
    }

    public record Output(Mono<User> result) { }
}
