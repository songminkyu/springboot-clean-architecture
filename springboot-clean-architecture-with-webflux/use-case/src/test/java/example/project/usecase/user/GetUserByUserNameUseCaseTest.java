package example.project.usecase.user;

import example.project.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetUserByUserNameUseCaseTest {
    @InjectMocks
    GetUserByUserNameUseCase getUserByUserNameUseCase;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserByUserNameTest(){
        String userName = "test";
        GetUserByUserNameUseCase.Input input = new GetUserByUserNameUseCase.Input(userName);

        User user = mock(User.class);
        doReturn(Mono.just(user))
                .when(userRepository)
                .findByUserName(anyString());

        assertThat(this.getUserByUserNameUseCase.execute(Mono.just(input)).result().block())
                .isEqualTo(user);
    }

}
