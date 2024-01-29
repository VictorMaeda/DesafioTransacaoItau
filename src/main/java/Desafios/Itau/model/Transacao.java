package Desafios.Itau.model;

import java.time.OffsetDateTime;

public class Transacao {
private float valor;
private OffsetDateTime dataHora;
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public OffsetDateTime getDataHora() {
	return dataHora;
}
public void setDataHora(OffsetDateTime dataHora) {
	this.dataHora = dataHora;
}



}
