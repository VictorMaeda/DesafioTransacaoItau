package Desafios.Itau.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Desafios.Itau.model.Transacao;
import Desafios.Itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class TransacaoController {
private final TransacaoService transacaoService;

public TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
}

@GetMapping("/transacao")
public ResponseEntity<List<Transacao>> listar() {
    return ResponseEntity.ok().body(transacaoService.getLista());
}
@DeleteMapping("/transacao")
public ResponseEntity apagarDados() {
    transacaoService.limparLista();
	return ResponseEntity.ok().build();
}
@PostMapping("/transacao")
public ResponseEntity postMethodName(@RequestBody @Valid Transacao transacao) {
    transacaoService.cadastrar(transacao);
    return ResponseEntity.created(null).build();
}
@GetMapping("/estatistica/{segundos}")
public ResponseEntity getMethodName(@PathVariable int segundos) {
    return ResponseEntity.ok().body(transacaoService.calcularEstatisticas(segundos));
}


}
