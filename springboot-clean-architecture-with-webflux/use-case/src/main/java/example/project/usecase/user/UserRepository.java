package example.project.usecase.user;

import example.project.entity.Identity;
import example.project.entity.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> findByUserName(String userName);
    Mono<User> findByUserId(Identity userId);
    Mono<User> persist(User input);
}
