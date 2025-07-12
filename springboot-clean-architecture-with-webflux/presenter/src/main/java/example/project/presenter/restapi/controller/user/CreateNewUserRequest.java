package example.project.presenter.restapi.controller.user;

import example.project.usecase.user.CreateNewUserUseCase;

import javax.validation.constraints.NotBlank;

public record CreateNewUserRequest(@NotBlank String userName, @NotBlank String password, @NotBlank String address) {
    public CreateNewUserUseCase.Input toInput() {
        return new CreateNewUserUseCase.Input(userName, password, address);
    }
}
