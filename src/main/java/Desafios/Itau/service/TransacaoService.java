package Desafios.Itau.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import Desafios.Itau.model.Estatistica;
import Desafios.Itau.model.Transacao;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
private List<Transacao> lista = new ArrayList<>();
public List<Transacao> getLista(){
	return lista;
}
public void limparLista() {
	lista.clear();
}
public void cadastrar(Transacao transacao) {
	lista.add(transacao);
}

	public Estatistica calcularEstatisticas(int segundos) {
		OffsetDateTime horario = OffsetDateTime.now().minusSeconds(segundos);
		DoubleSummaryStatistics stats = lista.stream()
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
