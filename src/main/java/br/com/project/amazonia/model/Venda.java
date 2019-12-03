package br.com.project.amazonia.model;

import java.io.Serializable;
import java.util.List;

public class Venda implements Serializable {

	private static final long serialVersionUID = 4950046301494272842L;

	private Cliente cliente;
	private List<Produto> produtos;
	private Cupom cupom;
	private Frete frete;

	private double valorTotal;
	private double valorDescontoTotal;
	private double valorImpostoTotal;
	private double valorAPagar;

	public static class Builder {

		private Cliente cliente;
		private List<Produto> produtos;
		private Cupom cupom;
		private Frete frete;

		private double valorTotal;
		private double valorDescontoTotal;
		private double valorImpostoTotal;
		private double valorAPagar;

		public Builder cliente(Cliente pCliente) {
			this.cliente = pCliente;
			return this;
		}

		public Builder produtos(List<Produto> pProdutos) {
			this.produtos = pProdutos;
			return this;
		}

		public Builder cupom(Cupom pCupom) {
			this.cupom = pCupom;
			return this;
		}

		public Builder frete(Frete pFrete) {
			this.frete = pFrete;
			return this;
		}

		public Builder valorTotal(double pValorTotal) {
			this.valorTotal = pValorTotal;
			return this;
		}

		public Builder valorDescontoTotal(double pValorDescontoTotal) {
			this.valorDescontoTotal = pValorDescontoTotal;
			return this;
		}

		public Builder valorImpostoTotal(double pValorImpostoTotal) {
			this.valorImpostoTotal = pValorImpostoTotal;
			return this;
		}
		
		public Builder valorAPagar(double pValorAPagar) {
			this.valorAPagar = pValorAPagar;
			return this;
		}

		public Venda build() {
			return new Venda(this);
		}

	}

	private Venda(Builder builder) {
		this.cliente = builder.cliente;
		this.produtos = builder.produtos;
		this.cupom = builder.cupom;
		this.frete = builder.frete;
		this.valorTotal = builder.valorTotal;
		this.valorDescontoTotal = builder.valorDescontoTotal;
		this.valorImpostoTotal = builder.valorImpostoTotal;
		this.valorAPagar = builder.valorAPagar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public Frete getFrete() {
		return frete;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public double getValorDescontoTotal() {
		return valorDescontoTotal;
	}

	public double getValorImpostoTotal() {
		return valorImpostoTotal;
	}
	
	public double getValorAPagar() {
		return valorAPagar;
	}

	public void setCliente(Cliente pCliente) {
		cliente = pCliente;
	}

	public void setProdutos(List<Produto> pProdutos) {
		produtos = pProdutos;
	}

	public void setCupom(Cupom pCupom) {
		cupom = pCupom;
	}

	public void setFrete(Frete pFrete) {
		frete = pFrete;
	}

	public void setValorTotal(double pValorTotal) {
		valorTotal = pValorTotal;
	}

	public void setValorDescontoTotal(double pValorDescontoTotal) {
		valorDescontoTotal = pValorDescontoTotal;
	}

	public void setValorImpostoTotal(double pValorImpostoTotal) {
		valorImpostoTotal = pValorImpostoTotal;
	}
	
	public void setValorAPagar(double pValorAPagar) {
		valorAPagar = pValorAPagar;
	}

	@Override
	public String toString() {
		return "Venda [" + cliente.toString() 
				+ ", " + produtos.toString()
				+ ", " + cupom.toString() 
				+ ", " + frete.toString() 
				+ ", valorTotal=" + valorTotal
				+ ", valorDescontoTotal=" + valorDescontoTotal
				+ ", valorImpostoTotal=" + valorImpostoTotal 
				+ ", valorAPagar= " + valorAPagar + "]";
	}

}
