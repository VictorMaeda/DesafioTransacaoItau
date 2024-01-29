package Desafios.Itau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import Desafios.Itau.repository.TransacaoRepository;

@RestController
public class TransacaoController {
@Autowired
private TransacaoRepository repository;
@DeleteMapping("/transacao")
public ResponseEntity apagarDados() {
	repository.limparLista();
	return ResponseEntity.ok().build();
}
	

}
