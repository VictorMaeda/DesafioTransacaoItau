package Desafios.Itau.controllers;

import Desafios.Itau.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/{segundos}")
    public ResponseEntity getMethodName(@PathVariable int segundos) {
        return ResponseEntity.ok().body(estatisticaService.calcularEstatisticas(segundos));
    }
}
