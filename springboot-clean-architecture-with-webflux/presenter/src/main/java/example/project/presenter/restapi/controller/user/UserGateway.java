package example.project.presenter.restapi.controller.user;

import example.project.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public interface UserGateway {
    @PostMapping
    Mono<User> createNewUser(@RequestBody @Valid CreateNewUserRequest input);
    @PatchMapping
    Mono<User> updateUserByUserId(@RequestBody @Valid UpdateUserRequest input);
    @GetMapping("/{userId}")
    Mono<User> getUserByUserId(@PathVariable Long userId);
}
