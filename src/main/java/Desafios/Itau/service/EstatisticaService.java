package Desafios.Itau.service;

import Desafios.Itau.model.Estatistica;
import Desafios.Itau.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
@Service
public class EstatisticaService {
    private final TransacaoService transacaoService;
    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public Estatistica calcularEstatisticas(int segundos) {
        OffsetDateTime horario = OffsetDateTime.now().minusSeconds(segundos);
        DoubleSummaryStatistics stats = transacaoService.getLista().stream()
                .filter(t -> horario.isAfter(t.getDataHora()))
                .collect(Collectors.summarizingDouble(Transacao::getValor));

        return new Estatistica(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getCount() > 0 ? stats.getMin() : 0,
                stats.getCount() > 0 ? stats.getMax() : 0
        );
    }
}
