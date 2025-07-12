package example.project.presenter.restapi;

import example.project.entity.CoreException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RestExceptionHandlerTest {
    RestExceptionHandler exceptionHandler = new RestExceptionHandler();

    @Test
    public void handle(){
        String message = "Error Occured";
        ResponseEntity<APIResponse> response = exceptionHandler.handleCoreException(new CoreException(message));

        assertThat(response.getBody().message()).isEqualTo(message);
        assertThat(response.getBody().success()).isFalse();
    }
}
