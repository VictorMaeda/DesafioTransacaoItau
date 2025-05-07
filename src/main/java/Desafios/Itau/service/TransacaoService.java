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
}
