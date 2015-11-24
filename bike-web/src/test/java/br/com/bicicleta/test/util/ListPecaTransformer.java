package br.com.bicicleta.test.util;

import java.util.ArrayList;
import java.util.List;

import br.com.bicicleta.modelo.Peca;

import cucumber.api.Transformer;

public class ListPecaTransformer extends Transformer<List<Peca>>{

	@Override
	public List<Peca> transform(String raw) {

		List<Peca> pecas = new ArrayList<Peca>();

		if ("nulo".equals(raw)) {
			return pecas;
		}

		String[] pecasLines = raw.split(";");

		for (String pecaLine : pecasLines) {
			Peca peca = new Peca();
			String[] props = pecaLine.split(",");

			int i = 0;
			for(String prop : props) {
				String[] pairValue = prop.split(":");
				String value = pairValue[1];

				if ("nulo".equals(value)) {
					i++;
					continue;
				}

				switch (i) {

				case 0: peca.setNome(value);
				break;
				case 1: peca.setTipo(value);
				break;
				case 2: peca.setMarca(value);
				break;
				case 3: peca.setDescricao(value);
				break;

				}

				i++;

			}
			pecas.add(peca);

		}

		return pecas;
	}

}
