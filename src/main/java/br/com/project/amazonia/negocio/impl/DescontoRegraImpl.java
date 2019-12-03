package br.com.project.amazonia.negocio.impl;

import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;

public class DescontoRegraImpl implements IRegra {

	@Override
	public void aplicarRegra(Venda pVenda) {
		pVenda.getProdutos().stream()
				.filter(produto -> hasDesconto(pVenda, produto))
				.forEach(produto -> calcularValorDesconto(pVenda, produto));
	}

	private void calcularValorDesconto(Venda pVenda, Produto produto) {
		produto.setValorDesconto(produto.getValorTotal()
				* pVenda.getCupom().getPorcentagem() / 100);
	}

	private boolean hasDesconto(Venda pVenda, Produto produto) {
		return pVenda.getCupom() != null
				&& pVenda.getCupom().getPorcentagem() != 0
				&& produto.isPromocao();
	}

}
