package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.ConsoleService;
import br.edu.infnet.appvenda.model.service.GameService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ConsoleService consoleService;
	@Autowired
	private GameService gameService;
	
	//@RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String showHome(Model model) 
	{	
		model.addAttribute("qtdVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdProduto", produtoService.obterQtde());
		model.addAttribute("qtdConsole", consoleService.obterQtde());
		model.addAttribute("qtdGame", gameService.obterQtde());
		
		return "home";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterListaVendedor(Model model)
	{
		model.addAttribute("titulo", "Vendedores:");
		model.addAttribute("lista", vendedorService.obterLista());
		
		return showHome(model);
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model)
	{
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("lista", produtoService.obterLista());
		
		return showHome(model);
	}
	
	@GetMapping(value = "/console/lista")
	public String obterListaConsole(Model model)
	{
		model.addAttribute("titulo", "Consoles:");
		model.addAttribute("lista", consoleService.obterLista());
		
		return showHome(model);
	}
	
	@GetMapping(value = "/game/lista")
	public String obterListaGame(Model model)
	{
		model.addAttribute("titulo", "Games:");
		model.addAttribute("lista", gameService.obterLista());
		
		return showHome(model);
	}
}
