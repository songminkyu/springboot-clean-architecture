package example.project.presenter.restapi;

import example.project.entity.CoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.server.EntityResponse;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CoreException.class)
    ResponseEntity<APIResponse> handleCoreException(CoreException ex) {
        return ResponseEntity.internalServerError().body(APIResponse.error(ex.getMessage()));
    }
}
