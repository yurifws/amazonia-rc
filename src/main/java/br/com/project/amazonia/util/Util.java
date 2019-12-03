package br.com.project.amazonia.util;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.project.amazonia.AmazoniaRC;
import br.com.project.amazonia.enums.TipoProdutoEnum;

public class Util {
	
	public static final Logger LOGGER = Logger.getLogger(AmazoniaRC.class.getName());
	
	public static final double IMPOSTO = 10.0;
	
	protected static final List<TipoProdutoEnum> produtosIsentosImposto = Arrays.asList(
											TipoProdutoEnum.LIVRO, 
											TipoProdutoEnum.JORNAL,
											TipoProdutoEnum.REVISTA, 
											TipoProdutoEnum.E_READER);

	private Util() {
	}

	public static Document converterStringParaXMLDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(new StringReader(
					xmlString)));
		} catch (Exception e) {
			Util.LOGGER.log(Level.SEVERE, "Ocorreu um erro ao tentar converter para XML");
		}
		return null;
	}

	public static List<TipoProdutoEnum> getProdutosIsentosImposto() {
		return produtosIsentosImposto;
	}
	
}
