package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Game;

@Service
public class GameService {

	private Map<Integer, Game> mapaGame = new HashMap<Integer, Game>();

	public void incluir(Game game) {
		mapaGame.put(game.getCodigo(), game);
	}
	
	public Collection<Game> obterLista(){	
		return mapaGame.values();
	}
}

