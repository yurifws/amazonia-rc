package br.com.project.amazonia.model;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = -8765869716262640871L;
	
	private String email= "";
	private String cep = "";
		
	
	public static class Builder{
		private String email= "";
		private String cep = "";
		
		public Builder email(String pEmail){
			this.email = pEmail;
			return this;
		}
		public Builder cep(String pCep){
			this.cep = pCep;
			return this;
		}
		
		public Cliente build(){
			return new Cliente(this);
		}
		
	}
	
	private Cliente(Builder builder){
		this.email = builder.email;
		this.cep = builder.cep;
	}

	public String getEmail() {
		return email;
	}

	public String getCep() {
		return cep;
	}

	public void setEmail(String pEmail) {
		email = pEmail;
	}

	public void setCep(String pCep) {
		cep = pCep;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", cep=" + cep + "]";
	}
	
}
