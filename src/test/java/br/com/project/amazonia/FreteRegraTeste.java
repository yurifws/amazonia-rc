package br.com.project.amazonia;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.project.amazonia.enums.TipoProdutoEnum;
import br.com.project.amazonia.model.Cliente;
import br.com.project.amazonia.model.Cupom;
import br.com.project.amazonia.model.Frete;
import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;
import br.com.project.amazonia.negocio.IRegra;
import br.com.project.amazonia.negocio.impl.FreteRegraImpl;
import br.com.project.amazonia.negocio.impl.VendaRegraImpl;
import br.com.project.amazonia.util.Util;

public class FreteRegraTeste {
	
	IRegra freteRegra = new FreteRegraImpl();
	IRegra vendaRegra = new VendaRegraImpl();

	@Test
	public void testComMidiaDigital() {

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("50751-370")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(0)
				.build();
		
		Produto produto = new Produto.Builder()
				.nome("produto 1")
				.quantidade(1)
				.valorDesconto(0)
				.valorImposto(0)
				.midiaDigital(true)
				.promocao(false)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(1000)
				.build();
		produtos.add(produto);
		
		Frete frete = new Frete.Builder()
				.cepOrigem("04094-050")
				.valor(0)
				.build();
		
		Venda venda = new Venda.Builder()
				.cliente(cliente)
				.cupom(cupom)
				.produtos(produtos)
				.frete(frete)
				.valorAPagar(0)
				.valorDescontoTotal(0)
				.valorImpostoTotal(0)
				.valorTotal(0)
				.build();
		
		freteRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getFrete().getValor() == 0);
	}
	
	@Test
	public void testSemMidiaDigital() {

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("50751-370")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(0)
				.build();
		
		Produto produto = new Produto.Builder()
				.nome("produto 1")
				.quantidade(1)
				.valorDesconto(0)
				.valorImposto(0)
				.midiaDigital(false)
				.promocao(false)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(1000)
				.build();
		produtos.add(produto);
		
		Frete frete = new Frete.Builder()
				.cepOrigem("04094-050")
				.valor(0)
				.build();
		
		Venda venda = new Venda.Builder()
				.cliente(cliente)
				.cupom(cupom)
				.produtos(produtos)
				.frete(frete)
				.valorAPagar(0)
				.valorDescontoTotal(0)
				.valorImpostoTotal(0)
				.valorTotal(0)
				.build();
		
		freteRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getFrete().getValor() > 0);
	}
	
	@Test
	public void testErroConeccao() {

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("04094-050")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(0)
				.build();
		
		Produto produto = new Produto.Builder()
				.nome("produto 1")
				.quantidade(1)
				.valorDesconto(0)
				.valorImposto(0)
				.midiaDigital(false)
				.promocao(false)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(1000)
				.build();
		produtos.add(produto);
		
		Frete frete = new Frete.Builder()
				.cepOrigem("04094-050")
				.valor(0)
				.build();
		
		Venda venda = new Venda.Builder()
				.cliente(cliente)
				.cupom(cupom)
				.produtos(produtos)
				.frete(frete)
				.valorAPagar(0)
				.valorDescontoTotal(0)
				.valorImpostoTotal(0)
				.valorTotal(0)
				.build();
		
		freteRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getFrete().getValor() > 0);
	}
	



}
