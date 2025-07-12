package example.project.presenter.restapi.controller.user;

import example.project.entity.Identity;
import example.project.usecase.user.UpdateUserUseCase;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UpdateUserRequest(@NotNull Long id, @NotBlank String userName, @NotBlank String password, @NotBlank String address) {
    public UpdateUserUseCase.Input toInput() {
        return new UpdateUserUseCase.Input(Identity.of(id), userName, password, address);
    }
}
