package br.com.project.amazonia.model;

import java.io.Serializable;

public class Frete implements Serializable{
	
	private static final long serialVersionUID = 3007724282786950984L;
	
	private String cepOrigem;
	private double valor;
	
	public static class Builder{
		private String origem;
		private double valor;
		
		public Builder cepOrigem(String pOrigem){
			this.origem = pOrigem;
			return this;
		}
		
		public Builder valor(double pValor){
			this.valor = pValor;
			return this;
		}
		
		public Frete build(){
			return new Frete(this);
		}
		
	}
	
	private Frete(Builder builder){
		this.valor = builder.valor;
		this.cepOrigem = builder.origem;
	}
	
	public String getCepOrigem() {
		return cepOrigem;
	}

	public double getValor() {
		return valor;
	}
	
	public void setCepOrigem(String pCepOrigem) {
		cepOrigem = pCepOrigem;
	}

	public void setValor(double pValor) {
		valor = pValor;
	}

	@Override
	public String toString() {
		return "Frete [origem=" + cepOrigem + ", valor=" + valor + "]";
	}

}
