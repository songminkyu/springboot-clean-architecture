package example.project.infrastructure.jpa.user;

import example.project.entity.Identity;
import example.project.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class JPAUserRepositoryTest {
    @InjectMocks
    private JPAUserRepository repository;

    @Mock
    private JPAUserDAO jpaUserDAO;

    private User generateUser(){
        return new User(Identity.of(1L), "test", "pass", "address", false);
    }

    @Test
    public void findByUserNameShouldReturnUser(){
        User user = generateUser();
        String userName = user.getUserName();


        doReturn(Mono.just(JPAUserEntity.fromDomain(user)))
                .when(jpaUserDAO)
                .findByUserName(eq(userName));

        Mono<User> result = this.repository.findByUserName(userName);

        assertThat(result.block()).isEqualTo(user);
    }

    @Test
    public void findByUserIdShouldReturnUser(){
        Identity id = Identity.of(0L);
        User user = generateUser();

        doReturn(Mono.just(JPAUserEntity.fromDomain(user)))
                .when(jpaUserDAO)
                .findById(eq(id.getId()));

        Mono<User> result = this.repository.findByUserId(id);
        assertThat(result.block()).isEqualTo(user);
    }

    @Test
    public void persistShouldReturnUser(){
        User user = generateUser();
        JPAUserEntity entity = JPAUserEntity.fromDomain(user);

        doReturn(Mono.just(entity))
                .when(jpaUserDAO)
                .save(any());

        Mono<User> result = this.repository.persist(user);
        assertThat(result.block()).isEqualTo(user);
    }
}
