package example.project.presenter.restapi.controller.user;

import example.project.entity.Identity;
import example.project.entity.User;
import example.project.usecase.UseCaseExecutor;
import example.project.usecase.user.CreateNewUserUseCase;
import example.project.usecase.user.GetUserByIdUseCase;
import example.project.usecase.user.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class UserController implements UserGateway{
    private final UseCaseExecutor useCaseExecutor;
    private final CreateNewUserUseCase createNewUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    @Override
    public Mono<User> createNewUser(CreateNewUserRequest request) {
        return useCaseExecutor.execute(
                createNewUserUseCase,
                Mono.just(request).map(CreateNewUserRequest::toInput),
                CreateNewUserUseCase.Output::result);
    }

    @Override
    public Mono<User> updateUserByUserId(UpdateUserRequest input) {
        return useCaseExecutor.execute(
                updateUserUseCase,
                Mono.just(input).map(UpdateUserRequest::toInput),
                UpdateUserUseCase.Output::result);
    }

    @Override
    public Mono<User> getUserByUserId(Long userId) {
        return useCaseExecutor.execute(
                getUserByIdUseCase,
                Mono.just(Identity.of(userId)).map(GetUserByIdUseCase.Input::new),
                GetUserByIdUseCase.Output::result);
    }
}
