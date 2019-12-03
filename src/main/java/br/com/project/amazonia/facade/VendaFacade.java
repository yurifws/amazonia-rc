package br.com.project.amazonia.facade;

import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;
import br.com.project.amazonia.negocio.impl.DescontoRegraImpl;
import br.com.project.amazonia.negocio.impl.EmailRegraImpl;
import br.com.project.amazonia.negocio.impl.FreteRegraImpl;
import br.com.project.amazonia.negocio.impl.ImpostoRegraImpl;
import br.com.project.amazonia.negocio.impl.VendaRegraImpl;
import br.com.project.amazonia.util.Util;

public class VendaFacade {
	
	IRegra descontoRegra = new DescontoRegraImpl();
	IRegra impostoRegra = new ImpostoRegraImpl();
	IRegra freteRegra = new FreteRegraImpl();
	IRegra emailRegra = new EmailRegraImpl();
	IRegra vendaRegra = new VendaRegraImpl();
	
	public void vender(Venda pVenda){
		
		descontoRegra.aplicarRegra(pVenda);
		impostoRegra.aplicarRegra(pVenda);
		freteRegra.aplicarRegra(pVenda);
		vendaRegra.aplicarRegra(pVenda);
		emailRegra.aplicarRegra(pVenda);
		
		Util.LOGGER.info(pVenda.toString());
	}
	

}
