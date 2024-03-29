package Desafios.Itau.controllers;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Desafios.Itau.model.Transacao;
import Desafios.Itau.repository.TransacaoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TransacaoController {
@Autowired
private TransacaoRepository repository;

@DeleteMapping("/transacao")
public ResponseEntity apagarDados() {
	repository.limparLista();
	return ResponseEntity.ok().build();
}
@PostMapping("/transacao")
public ResponseEntity postMethodName(@RequestBody @Valid Transacao transacao, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
    	StringBuilder erros = new StringBuilder();
    	for (FieldError errors : bindingResult.getFieldErrors()) {
    		erros.append(errors.getDefaultMessage()).append("/n");
		}
    return ResponseEntity.unprocessableEntity().body("erro de validação:/n" + erros.toString());
    }
    repository.cadastrar(transacao);
    return ResponseEntity.created(null).build();
}
@GetMapping("/estatistica/{segundos}")
public ResponseEntity getMethodName(@PathVariable int segundos) {
    return ResponseEntity.ok().body(repository.calcularEstatisticas(OffsetDateTime.now().minusSeconds(segundos)));
}


}
