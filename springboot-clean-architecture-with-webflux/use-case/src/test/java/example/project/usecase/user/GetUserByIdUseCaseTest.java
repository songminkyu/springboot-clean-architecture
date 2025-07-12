package example.project.usecase.user;

import example.project.entity.Identity;
import example.project.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetUserByIdUseCaseTest {
    @InjectMocks
    private GetUserByIdUseCase getUserByIdUseCase;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserByIdTest(){
        Identity id = Identity.of(1L);
        GetUserByIdUseCase.Input input = new GetUserByIdUseCase.Input(id);

        User user = mock(User.class);
        doReturn(Mono.just(user))
                .when(userRepository)
                .findByUserId(any());

        assertThat(this.getUserByIdUseCase.execute(Mono.just(input)).result().block())
                .isEqualTo(user);
    }
}
