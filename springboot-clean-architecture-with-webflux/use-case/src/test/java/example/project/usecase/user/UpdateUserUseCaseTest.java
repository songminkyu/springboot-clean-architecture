package example.project.usecase.user;

import example.project.entity.CoreException;
import example.project.entity.Identity;
import example.project.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UpdateUserUseCaseTest {
    @InjectMocks
    private UpdateUserUseCase useCase;

    @Mock
    private GetUserByIdUseCase getUserByIdUseCase;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createNewUserTest(){
        Identity id = Identity.of(1L);
        String userName = "test";
        String password = "pass";
        String address = "address";
        UpdateUserUseCase.Input input = new UpdateUserUseCase.Input(id, userName, password, address);
        Mono<User> createdUser = Mono.just(input.toUser());
        GetUserByIdUseCase.Output output = new GetUserByIdUseCase.Output(createdUser);

        doReturn(output)
                .when(getUserByIdUseCase)
                .execute(any());


        doReturn(createdUser)
                .when(userRepository)
                .persist(any(User.class));


        User user = this.useCase.execute(Mono.just(input)).result().block();
        assertThat(user).isEqualTo(createdUser.block());
    }

    @Test
    public void throwErrorIfUserNotExists(){
        Identity id = Identity.of(1L);
        String userName = "test";
        String password = "pass";
        String address = "address";
        UpdateUserUseCase.Input input = new UpdateUserUseCase.Input(id, userName, password, address);

        //Mono<User> createdUser = Mono.just(User.create(userName, password, address, false));
        GetUserByIdUseCase.Output output = new GetUserByIdUseCase.Output(Mono.empty());

        doReturn(output)
                .when(getUserByIdUseCase)
                .execute(any());


        assertThatThrownBy(() -> this.useCase.execute(Mono.just(input)).result().block())
                .isInstanceOf(CoreException.class)
                .hasMessage("User not found");
    }

    @Test
    public void throwCoreErrorIfOtherExceptionThrownByLogic(){
        Identity id = Identity.of(1L);
        String userName = "test";
        String password = "pass";
        String address = "address";
        UpdateUserUseCase.Input input = new UpdateUserUseCase.Input(id, userName, password, address);

        //Mono<User> createdUser = Mono.just(User.create(userName, password, address, false));
        String errorMessage = "Some Other Error";
        GetUserByIdUseCase.Output output = new GetUserByIdUseCase.Output(Mono.error(new CoreException(errorMessage)));

        doReturn(output)
                .when(getUserByIdUseCase)
                .execute(any());


        assertThatThrownBy(() -> this.useCase.execute(Mono.just(input)).result().block())
                .isInstanceOf(CoreException.class)
                .hasMessage(errorMessage);
    }
}
