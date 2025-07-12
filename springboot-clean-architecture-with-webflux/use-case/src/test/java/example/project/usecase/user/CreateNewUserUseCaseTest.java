package example.project.usecase.user;

import example.project.entity.CoreException;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CreateNewUserUseCaseTest {
    @InjectMocks
    private CreateNewUserUseCase useCase;

    @Mock
    private GetUserByUserNameUseCase getUserByUserNameUseCase;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createNewUserTest(){
        String userName = "test";
        String password = "pass";
        String address = "address";
        CreateNewUserUseCase.Input input = new CreateNewUserUseCase.Input(userName, password, address);

        GetUserByUserNameUseCase.Output output = new GetUserByUserNameUseCase.Output(Mono.empty());

        doReturn(output)
                .when(getUserByUserNameUseCase)
                .execute(any());

        Mono<User> createdUser = Mono.just(User.create(userName, password, address, false));

        doReturn(createdUser)
                .when(userRepository)
                .persist(any(User.class));


        User user = this.useCase.execute(Mono.just(input)).result().block();
        assertThat(user).isEqualTo(createdUser.block());
    }

    @Test
    public void throwErrorIfUserAlreadyExists(){
        String userName = "test";
        String password = "pass";
        String address = "address";
        CreateNewUserUseCase.Input input = new CreateNewUserUseCase.Input(userName, password, address);

        Mono<User> createdUser = Mono.just(User.create(userName, password, address, false));
        GetUserByUserNameUseCase.Output output = new GetUserByUserNameUseCase.Output(createdUser);

        doReturn(output)
                .when(getUserByUserNameUseCase)
                .execute(any());


        assertThatThrownBy(() -> this.useCase.execute(Mono.just(input)).result().block())
                .isInstanceOf(CoreException.class)
                .hasMessage("User already exists");
    }

    @Test
    public void throwCoreErrorIfOtherExceptionThrownByLogic(){
        String userName = "test";
        String password = "pass";
        String address = "address";
        CreateNewUserUseCase.Input input = new CreateNewUserUseCase.Input(userName, password, address);

        GetUserByUserNameUseCase.Output output = new GetUserByUserNameUseCase.Output(Mono.error(new RuntimeException("Some other error..")));

        doReturn(output)
                .when(getUserByUserNameUseCase)
                .execute(any());

        assertThatThrownBy(() -> this.useCase.execute(Mono.just(input)).result().block())
                .isInstanceOf(CoreException.class)
                .hasMessage("Unexpected Error");
    }
}
