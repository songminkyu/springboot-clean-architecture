package example.project.usecase;

import java.util.function.Function;

public interface UseCaseExecutor {
  <F, T, RS> RS execute(
      GenericUseCase<F, T> executor, F input, Function<T, RS> outputMapper);
}
