package br.com.project.amazonia.negocio.impl;

import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;
import br.com.project.amazonia.service.CorreiosWebService;

public class FreteRegraImpl implements IRegra {

	CorreiosWebService correiosService = new CorreiosWebService();

	@Override
	public void aplicarRegra(Venda pVenda) {
		double pesoKgTotal = pVenda.getProdutos().stream()
				.filter(produto -> !produto.isMidiaDigital())
				.mapToDouble(Produto::getPesoKg).sum();
		pVenda.getFrete().setValor(
				correiosService.calcularFrete(
						pVenda.getFrete().getCepOrigem(), 
						pVenda.getCliente().getCep(), 
						pesoKgTotal));
	}
	
}
