package Desafios.Itau.repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Desafios.Itau.model.Estatistica;
import Desafios.Itau.model.Transacao;

@Repository
public class TransacaoRepository {
private List<Transacao> lista = new ArrayList<>();

public void limparLista() {
	lista = new ArrayList<>();
}
public void cadastrar(Transacao transacao) {
	lista.add(transacao);
}

public Estatistica calcularEstatisticas(OffsetDateTime horario) {
	if(lista.isEmpty()) return new Estatistica(0, 0, 0, 0, 0);
	int count =0;	float sum = 0;
	float min = Float.MAX_VALUE; float max = Float.MIN_NORMAL;
	for(int i = lista.size()-1; i >=0; i--) {
		Transacao transacao = lista.get(i);
		if(horario.isBefore(transacao.getDataHora())) {
			float valor = transacao.getValor();
			count++; sum +=valor;
			if(valor < min) {
				min = valor;
			}
			if(valor > max) {
				max = valor;
			}
		}
	}
	if(count == 0)return new Estatistica(0, 0, 0, 0, 0);
	return new Estatistica(count, sum, sum/count, min, max);
}
}
