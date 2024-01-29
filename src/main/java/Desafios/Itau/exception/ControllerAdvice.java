package Desafios.Itau.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

@ExceptionHandler(HttpMessageNotReadableException.class)
public ResponseEntity naoCompreendido() {
	return ResponseEntity.badRequest().body("A API não compreendeu a requisição do cliente");
}

}
