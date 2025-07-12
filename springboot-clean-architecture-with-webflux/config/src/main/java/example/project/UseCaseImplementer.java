package example.project;

import example.project.usecase.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseImplementer {
    @Bean
    public GetUserByUserNameUseCase getUserByUserNameUseCase(UserRepository userRepository){
        return new GetUserByUserNameUseCase(userRepository);
    }
    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository){
        return new GetUserByIdUseCase(userRepository);
    }
    @Bean
    public CreateNewUserUseCase createNewUserUseCase(UserRepository userRepository, GetUserByUserNameUseCase getUserByUserNameUseCase) {
        return new CreateNewUserUseCase(userRepository, getUserByUserNameUseCase);
    }
    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository, GetUserByIdUseCase getUserByIdUseCase) {
        return new UpdateUserUseCase(userRepository, getUserByIdUseCase);
    }
}
