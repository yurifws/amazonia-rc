package br.com.project.amazonia.model;

import java.io.Serializable;

public class Cupom implements Serializable{

	private static final long serialVersionUID = 5989802267822065856L;
	
	private int porcentagem;
	
	public static class Builder {

		private int porcentagem;

		public Builder porcentagem(int pPorcentagem) {
			this.porcentagem = pPorcentagem;
			return this;
		}

		public Cupom build() {
			return new Cupom(this);
		}
		
	}
	
	private Cupom(Builder builder) {
		this.porcentagem = builder.porcentagem;
	}

	public int getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(int pPorcentagem) {
		porcentagem = pPorcentagem;
	}

	@Override
	public String toString() {
		return "Cupom [porcentagem=" + porcentagem + "]";
	}
	
}
