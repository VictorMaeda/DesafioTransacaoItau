package Desafios.Itau.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Desafios.Itau.model.Transacao;
import Desafios.Itau.service.TransacaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {
private final TransacaoService transacaoService;

public TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
}

@GetMapping
public ResponseEntity<List<Transacao>> listar() {
    return ResponseEntity.ok().body(transacaoService.getLista());
}
@DeleteMapping
public ResponseEntity apagarDados() {
    transacaoService.limparLista();
	return ResponseEntity.ok().build();
}
@PostMapping
public ResponseEntity postMethodName(@RequestBody @Valid Transacao transacao) {
    transacaoService.cadastrar(transacao);
    return ResponseEntity.created(null).build();
}



}
