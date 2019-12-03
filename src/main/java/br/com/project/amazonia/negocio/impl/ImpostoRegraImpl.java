package br.com.project.amazonia.negocio.impl;

import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;
import br.com.project.amazonia.util.Util;

public class ImpostoRegraImpl implements IRegra {

	@Override
	public void aplicarRegra(Venda pVenda) {
		pVenda.getProdutos().stream()
				.filter(produto -> !hasIsentoImposto(produto))
				.forEach(produto -> produto.setValorImposto(produto.getValorTotal()* Util.IMPOSTO / 100));
	}

	private boolean hasIsentoImposto(Produto produto) {
		return Util.getProdutosIsentosImposto().contains(produto.getTipoProduto());
	}

}
