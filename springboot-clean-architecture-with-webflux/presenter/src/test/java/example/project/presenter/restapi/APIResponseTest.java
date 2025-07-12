package example.project.presenter.restapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APIResponseTest {
    @Test
    public void okShouldReturnSuccessTrueWithMessage() {
        String message = "message";
        APIResponse response = APIResponse.ok(message);

        assertThat(response.success()).isTrue();
        assertThat(response.message()).isEqualTo(message);
    }
    @Test
    public void errorShouldReturnSuccessFalseWithMessage() {
        String message = "message";
        APIResponse response = APIResponse.error(message);

        assertThat(response.success()).isFalse();
        assertThat(response.message()).isEqualTo(message);
    }
}
