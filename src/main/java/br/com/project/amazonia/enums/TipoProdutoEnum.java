package br.com.project.amazonia.enums;


public enum TipoProdutoEnum implements IEnum<Integer>{
	OUTROS(0, "Outros"),
	JORNAL(1, "Jornal"),
	REVISTA(2, "Revista"),
	E_READER(3, "EReader"),
	LIVRO(4, "Livro");
	
	private TipoProdutoEnum(Integer pCodigo, String pDescricao) {
		this.codigo = pCodigo;
		this.descricao = pDescricao;
	}
	
	private String descricao;
	private int codigo;

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}
	
	

}
