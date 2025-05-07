package Desafios.Itau.model;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;

public class Transacao {
@NotNull(message = "valor não pode ser nulo")
@PositiveOrZero(message = "A transação deve ter valor igual ou maior que 0")
private float valor;
@NotNull(message = "dataHora não pode ser nulo")
@Past(message = "A transação deve ter acontecido no passado")
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

	public Transacao(float valor, OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}
}
