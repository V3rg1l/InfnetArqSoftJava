package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Console;
import br.edu.infnet.appvenda.model.service.ConsoleService;

@Order(3)
@Component
public class ConsoleLoader implements ApplicationRunner {
	
	@Autowired
	private ConsoleService consoleService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/consoles.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Console console = new Console();
			console.setCodigo(Integer.valueOf(campos[0]));
			console.setDescricao(campos[1]);
			console.setEstoque(Boolean.valueOf(campos[2]));
			console.setPreco(Float.valueOf(campos[3]));
			console.setDescricaoConsole(campos[4]);
			console.setModelo(campos[5]);
			console.setGarantiaMeses(Integer.valueOf(campos[6]));
			
			//consoleService.incluir(console);
			
			linha = leitura.readLine();
		}

		for(Console console: consoleService.obterLista()) {
			System.out.println("[Console] " + console);			
		}

		leitura.close();
	}
}
