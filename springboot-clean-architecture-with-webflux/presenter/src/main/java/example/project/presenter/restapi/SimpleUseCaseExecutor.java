package example.project.presenter.restapi;

import example.project.usecase.GenericUseCase;
import example.project.usecase.UseCaseExecutor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SimpleUseCaseExecutor implements UseCaseExecutor {
  @Override
  public <F, T, RS> RS execute(
          GenericUseCase<F, T> executor, F input, Function<T, RS> outputMapper) {
    return outputMapper.apply(executor.execute(input));
  }
}
