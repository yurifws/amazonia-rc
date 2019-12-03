package br.com.project.amazonia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.project.amazonia.util.Util;

public class CorreiosWebService {

	private static final String TAG_SERVICO = "cServico";
	private static final String TAG_VALOR_FRETE = "Valor";

	public double calcularFrete(String cepOrigem, String cepDestino, double peso) {
		HttpURLConnection httpURLConnection;
		String retorno;
		Document documento;
		try {
			if (isCalculaFrete(cepOrigem, cepDestino, peso)){
				httpURLConnection = conectar(cepOrigem, cepDestino, peso);
				retorno = consumir(httpURLConnection);
				documento = Util.converterStringParaXMLDocument(retorno);
				return retornarValor(documento);
			}
		} catch (IOException e) {
			Util.LOGGER.log(Level.SEVERE, "Ocorreu um erro ao tentar calcular o frete");
		}
		return 0;
	}

	private HttpURLConnection conectar(String cepOrigem, String cepDestino,
			double pesoKg) throws IOException {
		String urlStr = String
				.format("http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?sCepOrigem=%s&sCepDestino=%s&nVlPeso=%s&nVlComprimento=30&nVlAltura=2&nVlLargura=15&nVlDiametro=0.0&nCdFormato=1&sCdMaoPropria=N&sCdAvisoRecebimento=N&nVlValorDeclarado=0,00&nCdServico=04510&nCdEmpresa=&sDsSenha=&StrRetorno=xml",
						cepOrigem, cepDestino, pesoKg);
		URL url = new URL(urlStr);

		return (HttpURLConnection) url.openConnection();
	}

	private String consumir(HttpURLConnection httpURLConnection)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(httpURLConnection.getInputStream()));

		StringBuilder stringBuilder = new StringBuilder();
		String resultado;
		while ((resultado = bufferedReader.readLine()) != null) {
			if (!resultado.isEmpty()) {
				stringBuilder.append(resultado);
			}

		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

	private double retornarValor(Document documento) {
		NodeList nodeList = documento.getElementsByTagName(TAG_SERVICO);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (Node.ELEMENT_NODE == node.getNodeType()) {
				Element element = (Element) node;
				String retorno = element.getElementsByTagName(TAG_VALOR_FRETE)
						.item(0).getTextContent();
				if (retorno != null) {
					return Double.parseDouble(retorno.replace(",", "."));
				}
			}
		}
		return 0;
	}
	
	private boolean isCalculaFrete(String cepOrigem, String cepDestino, double peso){ 
		return  !cepOrigem.isEmpty()
				&& !cepDestino.isEmpty()
				&& peso > 0;
	}
}
