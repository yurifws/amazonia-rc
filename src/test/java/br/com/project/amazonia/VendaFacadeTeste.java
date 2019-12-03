package br.com.project.amazonia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.project.amazonia.enums.TipoProdutoEnum;
import br.com.project.amazonia.facade.VendaFacade;
import br.com.project.amazonia.model.Cliente;
import br.com.project.amazonia.model.Cupom;
import br.com.project.amazonia.model.Frete;
import br.com.project.amazonia.model.Produto;
import br.com.project.amazonia.model.Venda;

public class VendaFacadeTeste {

	@Test
	public void testComCupomComPromocao() {
		VendaFacade facade = new VendaFacade();

		List<Produto> produtos = new ArrayList<>(0);
		
		Cliente cliente = new Cliente.Builder()
				.email("yurifws@gmail.com")
				.cep("50751-370")
				.build();
		
		Cupom cupom = new Cupom.Builder()
				.porcentagem(5)
				.build();
		
		Produto produto = new Produto.Builder()
				.nome("produto 1")
				.quantidade(1)
				.midiaDigital(true)
				.promocao(false)
				.pesoKg(0.2)
				.tipoProduto(TipoProdutoEnum.OUTROS)
				.valor(150)
				.build();
		produtos.add(produto);
		
		Produto produto2 = new Produto.Builder()
				.nome("produto 2")
				.quantidade(1)
				.valorDesconto(0)
				.valorImposto(0)
				.midiaDigital(false)
				.promocao(true)
				.pesoKg(0.1)
				.tipoProduto(TipoProdutoEnum.JORNAL)
				.valor(150)
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
		
		facade.vender(venda);
	}
	
	
}
