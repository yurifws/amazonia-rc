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
		if (pVenda.getCliente() != null 
				&& !pVenda.getCliente().getEmail().isEmpty())
			Util.LOGGER.info(
					String.format("Foi enviado email para: %s", pVenda.getCliente().getEmail()));
		else
			Util.LOGGER.info("Não foi possível enviar email!");
	}

}
