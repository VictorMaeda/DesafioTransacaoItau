package Desafios.Itau.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> httpMessageNotReadableExceptionHandler() {
		return ResponseEntity.badRequest().body("A API não compreendeu a requisição do cliente");
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		var errorMessage = new StringBuilder();
		ex.getBindingResult().getFieldErrors().forEach(fieldError
				-> errorMessage.append(fieldError.getDefaultMessage()).append("\n"));
		return ResponseEntity.badRequest().body("Erro de validação: \n" +  errorMessage.toString());
	}
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> throwableHandler() {
		return ResponseEntity.internalServerError().body("Ocorreu um erro inesperado");
	}

}
