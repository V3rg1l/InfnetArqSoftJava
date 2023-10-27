package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Console;
import br.edu.infnet.appvenda.model.repository.ConsoleRepository;

@Service
public class ConsoleService {

	@Autowired
	private ConsoleRepository consoleRepository;

	public void incluir(Console console) {
		consoleRepository.save(console);
	}
	
	public Collection<Console> obterLista(){	
		return (Collection<Console>) consoleRepository.findAll();
	}
}