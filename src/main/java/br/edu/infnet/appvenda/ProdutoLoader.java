package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Console;
import br.edu.infnet.appvenda.model.domain.Game;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[7]) {
			case "C":
				Console console = new Console();
				console.setCodigo(Integer.valueOf(campos[0]));
				console.setDescricao(campos[1]);
				console.setEstoque(Boolean.valueOf(campos[2]));
				console.setPreco(Float.valueOf(campos[3]));
				console.setDescricaoConsole(campos[4]);
				console.setModelo(campos[5]);
				console.setGarantiaMeses(Integer.valueOf(campos[6]));
				
				produtoService.incluir(console);
				
				break;

			case "G":
				Game game = new Game();
				game.setCodigo(Integer.valueOf(campos[0]));
				game.setDescricao(campos[1]);
				game.setEstoque(Boolean.valueOf(campos[2]));
				game.setPreco(Float.valueOf(campos[3]));
				game.setCodigoConsole(Integer.valueOf(campos[4]));
				game.setDescricaoGame(campos[5]);
				game.setGarantiaMeses(Integer.valueOf(campos[6]));
				
				produtoService.incluir(game);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}