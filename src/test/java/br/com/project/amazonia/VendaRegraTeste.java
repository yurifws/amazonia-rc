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
import br.com.project.amazonia.negocio.impl.FreteRegraImpl;
import br.com.project.amazonia.negocio.impl.ImpostoRegraImpl;
import br.com.project.amazonia.negocio.impl.VendaRegraImpl;
import br.com.project.amazonia.util.Util;

public class VendaRegraTeste {
	
	IRegra vendaRegra = new VendaRegraImpl();

	@Test
	public void testValorTotal() {

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
				.midiaDigital(false)
				.promocao(false)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(1000)
				.build();
		produtos.add(produto);
		
		Produto produto2 = new Produto.Builder()
				.nome("produto 2")
				.quantidade(1)
				.midiaDigital(false)
				.promocao(false)
				.pesoKg(0.25)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(500)
				.build();
		produtos.add(produto2);
		
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
		
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorTotal() > 1000);
	}
	
	
	@Test
	public void testValorDescontoTotal() {
		IRegra descontoRegra = new DescontoRegraImpl();

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
				.quantidade(2)
				.valorDesconto(0)
				.valorImposto(0)
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
		assertTrue(venda.getValorDescontoTotal() == venda.getValorTotal() * venda.getCupom().getPorcentagem()/100 );
	}
	
	@Test
	public void testValorImpostoTotal() {
		IRegra impostoRegra = new ImpostoRegraImpl();

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
				.quantidade(2)
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
		
		impostoRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorImpostoTotal() == venda.getValorTotal() * Util.IMPOSTO / 100);
	}
	
	
	@Test
	public void testValorAPagar() {
		IRegra descontoRegra = new DescontoRegraImpl();
		IRegra impostoRegra = new ImpostoRegraImpl();
		IRegra freteRegra = new FreteRegraImpl();
		
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
				.midiaDigital(true)
				.promocao(true)
				.pesoKg(0.3)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(1000)
				.build();
		produtos.add(produto);
		
		Produto produto2 = new Produto.Builder()
				.nome("produto 2")
				.quantidade(1)
				.valorDesconto(0)
				.valorImposto(0)
				.midiaDigital(false)
				.promocao(true)
				.pesoKg(0.5)
				.tipoProduto(TipoProdutoEnum.JORNAL)
				.valor(500)
				.build();
		produtos.add(produto2);
		
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
		impostoRegra.aplicarRegra(venda);
		freteRegra.aplicarRegra(venda);
		vendaRegra.aplicarRegra(venda);
		Util.LOGGER.info(venda.toString());
		assertTrue(venda.getValorAPagar()  == venda.getValorTotal()
				+ venda.getValorImpostoTotal() 
				+ venda.getFrete().getValor()
				- venda.getValorDescontoTotal());
	}
	


}
