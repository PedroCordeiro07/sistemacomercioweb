package br.com.fatec.sistemacomercioweb.controller;

import br.com.fatec.sistemacomercioweb.model.Produto;
import br.com.fatec.sistemacomercioweb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute("produto") Produto produto) {
        produtoService.cadastrarProduto(produto);
        return "redirect:/produtos";
    }
}