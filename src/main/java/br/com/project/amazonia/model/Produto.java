package br.com.project.amazonia.model;

import java.io.Serializable;

import br.com.project.amazonia.enums.TipoProdutoEnum;

public class Produto implements Serializable{

	private static final long serialVersionUID = -3896873593750452047L;
	
	private String nome = "";
	private int quantidade;
	private double pesoKg;
	private double valor;
	private double valorDesconto;
	private double valorImposto;
	private TipoProdutoEnum tipoProduto = TipoProdutoEnum.OUTROS;
	private boolean promocao;
	private boolean midiaDigital;
	
	
	public static class Builder{
		private String nome = "";
		private int quantidade;
		private double pesoKg;
		private double valor;
		private double valorDesconto;
		private double valorImposto;
		private TipoProdutoEnum tipoProduto = TipoProdutoEnum.OUTROS;
		private boolean promocao;
		private boolean midiaDigital;
		
		public Builder nome(String pNome){
			this.nome = pNome;
			return this;
		}
		
		public Builder quantidade(int pQuantidade){
			this.quantidade = pQuantidade;
			return this;
		}
		
		public Builder pesoKg(double pPesoKg){
			this.pesoKg = pPesoKg;
			return this;
		}
		
		public Builder valor(double pValor){
			this.valor = pValor;
			return this;
		}
		
		public Builder valorDesconto(double pValorDesconto){
			this.valorDesconto = pValorDesconto;
			return this;
		}
		
		public Builder valorImposto(double pValorImposto){
			this.valorImposto = pValorImposto;
			return this;
		}
		
		public Builder tipoProduto(TipoProdutoEnum pTipoProduto){
			this.tipoProduto = pTipoProduto;
			return this;
		}
		
		public Builder promocao(boolean pPromocao){
			this.promocao = pPromocao;
			return this;
		}
		
		public Builder midiaDigital(boolean pMidiaDigital){
			this.midiaDigital = pMidiaDigital;
			return this;
		}
		
		
		
		public Produto build(){
			return new Produto(this);
		}
		
	}
	
	private Produto(Builder builder){
		this.nome = builder.nome;
		this.quantidade = builder.quantidade;
		this.pesoKg = builder.pesoKg;
		this.valor = builder.valor;
		this.valorDesconto = builder.valorDesconto;
		this.valorImposto = builder.valorImposto;
		this.tipoProduto = builder.tipoProduto;
		this.promocao = builder.promocao;
		this.midiaDigital = builder.midiaDigital;
	}


	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPesoKg() {
		return pesoKg;
	}

	public double getValor() {
		return valor;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public TipoProdutoEnum getTipoProduto() {
		return tipoProduto;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public boolean isMidiaDigital() {
		return midiaDigital;
	}
	
	public double getValorTotal() {
		return getQuantidade() * getValor();
	}

	public void setNome(String pNome) {
		nome = pNome;
	}


	public void setQuantidade(int pQuantidade) {
		quantidade = pQuantidade;
	}


	public void setPesoKg(double pPesoKg) {
		pesoKg = pPesoKg;
	}


	public void setValor(double pValor) {
		valor = pValor;
	}


	public void setValorDesconto(double pValorDesconto) {
		valorDesconto = pValorDesconto;
	}


	public void setValorImposto(double pValorImposto) {
		valorImposto = pValorImposto;
	}


	public void setTipoProduto(TipoProdutoEnum pTipoProduto) {
		tipoProduto = pTipoProduto;
	}


	public void setPromocao(boolean pPromocao) {
		promocao = pPromocao;
	}


	public void setMidiaDigital(boolean pMidiaDigital) {
		midiaDigital = pMidiaDigital;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade
				+ ", pesoKg=" + pesoKg + ", valor=" + valor
				+ ", valorDesconto=" + valorDesconto + ", valorImposto="
				+ valorImposto + ", tipoProduto=" + tipoProduto + ", promocao="
				+ promocao + ", midiaDigital=" + midiaDigital + "]";
	}
	
}
