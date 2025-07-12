package example.project.presenter.restapi;

import example.project.usecase.GenericUseCase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleUseCaseExecutorTest {
    SimpleUseCaseExecutor executor = new SimpleUseCaseExecutor();

    @Test
    public void shouldReturnFollowingUseCase(){
        GenericUseCase<String, String> useCase = (input) -> input;
        String input = "input";
        String result = executor.execute(useCase, input, (output) -> output);
        assertThat(result).isEqualTo(input);
    }
}
