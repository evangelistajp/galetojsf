package br.edu.ifpb.pweb.galeto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evento {
	@Id		
	@GeneratedValue
	private long id;
	private String tipo;
	private Date dataAbertura;
	private Date dataencerramento;
	
	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataencerramento() {
		return dataencerramento;
	}
	public void setDataencerramento(Date dataencerramento) {
		this.dataencerramento = dataencerramento;
	}
	
	
	
}
