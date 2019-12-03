package br.com.project.amazonia.negocio.impl;

import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;

public class VendaRegraImpl implements IRegra {

	@Override
	public void aplicarRegra(Venda pVenda) {
		pVenda.setValorTotal(pVenda.getProdutos().stream()
				.mapToDouble(Produto::getValorTotal).sum());
		pVenda.setValorDescontoTotal(pVenda.getProdutos().stream()
				.mapToDouble(Produto::getValorDesconto).sum());
		pVenda.setValorImpostoTotal(pVenda.getProdutos().stream()
				.mapToDouble(Produto::getValorImposto).sum());
		pVenda.setValorAPagar(pVenda.getValorTotal()
				+ pVenda.getValorImpostoTotal() 
				+ pVenda.getFrete().getValor()
				- pVenda.getValorDescontoTotal());
	}

}
