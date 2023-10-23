package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Console;

@Service
public class ConsoleService {

	private Map<Integer, Console> mapaConsole = new HashMap<Integer, Console>();

	public void incluir(Console console) {
		mapaConsole.put(console.getCodigo(), console);
	}
	
	public Collection<Console> obterLista(){	
		return mapaConsole.values();
	}
}