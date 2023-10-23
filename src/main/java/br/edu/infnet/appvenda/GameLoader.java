package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Game;
import br.edu.infnet.appvenda.model.service.GameService;

@Order(4)
@Component
public class GameLoader implements ApplicationRunner {
	
    @Autowired
	private GameService gameService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/games.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Game game = new Game();
			game.setCodigo(Integer.valueOf(campos[0]));
			game.setDescricao(campos[1]);
			game.setEstoque(Boolean.valueOf(campos[2]));
			game.setPreco(Float.valueOf(campos[3]));
			game.setCodigoConsole(Integer.valueOf(campos[4]));
			game.setDescricaoGame(campos[5]);
			game.setGarantiaMeses(Integer.valueOf(campos[6]));
			
			gameService.incluir(game);
			
			linha = leitura.readLine();
		}

		for(Game game: gameService.obterLista()) {
			System.out.println("[Game] " + game);			
		}

		leitura.close();
	}
}
