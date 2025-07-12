package example.project.usecase;

public interface GenericUseCase<F, T> {
  T execute(F request);
}
