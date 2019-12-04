package br.com.project.amazonia.negocio.impl;

import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;
import br.com.project.amazonia.util.Util;

public class EmailRegraImpl implements IRegra {

	@Override
	public void aplicarRegra(Venda pVenda) {
		enviarEmail(pVenda);
	}

	private void enviarEmail(Venda pVenda) {
		String mensagem = "Não foi possível enviar email!";
		if (pVenda.getCliente() != null 
				&& !pVenda.getCliente().getEmail().isEmpty()){
			mensagem = String.format("Foi enviado email para: %s", pVenda.getCliente().getEmail());
		}
		Util.LOGGER.info(mensagem);	
	}

}
