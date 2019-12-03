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
import br.com.project.amazonia.negocio.impl.DescontoRegraImpl;
import br.com.project.amazonia.negocio.impl.VendaRegraImpl;
import br.com.project.amazonia.util.Util;

public class DescontoRegraTeste {
	
	IRegra descontoRegra = new DescontoRegraImpl();
	IRegra vendaRegra = new VendaRegraImpl();

	@Test
	public void testComCupomComPromocao() {

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("50751-370")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(10)
				.build();
		
		Produto produto = new Produto.Builder()
				.nome("produto 1")
				.valorDesconto(0)
				.valorImposto(0)
				.quantidade(1)
				.midiaDigital(false)
				.promocao(true)
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
		
		descontoRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorDescontoTotal() > 0);
	}
	
	@Test
	public void testSemCupomComPromocao() {

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
				.promocao(true)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(500)
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
		
		descontoRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorDescontoTotal() == 0);
	}
	
	@Test
	public void testSemCupomSemPromocao() {

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
		
		descontoRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorDescontoTotal() == 0);
	}
	
	@Test
	public void testComCupomSemPromocao() {

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("50751-370")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(50)
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
		
		descontoRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorDescontoTotal() == 0);
	}

	
	@Test
	public void testComCupomSemPromocaoComSet() {

		List<Produto> produtos = new ArrayList<>(0);

		Cliente cliente = new Cliente.Builder().build();
		cliente.setEmail("yurifws@gmail.com");
		cliente.setCep("50751-370");
		Cupom cupom = new Cupom.Builder().build();
		cupom.setPorcentagem(50);

		Produto produto = new Produto.Builder().build();
		produto.setNome("produto 1");
		produto.setQuantidade(1);
		produto.setValorDesconto(0);
		produto.setValorImposto(0);
		produto.setMidiaDigital(false);
		produto.setPromocao(false);
		produto.setPesoKg(0.25);
		produto.setTipoProduto(TipoProdutoEnum.OUTROS);
		produto.setValor(1000);
		produtos.add(produto);

		Frete frete = new Frete.Builder().build();
		frete.setCepOrigem("04094-050");
		frete.setValor(0);

		Venda venda = new Venda.Builder().build();
		venda.setCliente(cliente);
		venda.setCupom(cupom);
		venda.setProdutos(produtos);
		venda.setFrete(frete);
		

		descontoRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorDescontoTotal() == 0);
	}



}
