package Desafios.Itau.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
}
