package example.project.infrastructure.jpa.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface JPAUserDAO extends ReactiveCrudRepository<JPAUserEntity, Long> {
    Mono<JPAUserEntity> findByUserName(String userName);
}
