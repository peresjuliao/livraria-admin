package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Controller
public class LivrosController {
	
	private final Estante estante;
	private final Result result;
	
	@Inject
	public LivrosController(Estante estante, Result result) {
		this.estante = estante;
		this.result = result;
	}
	
	@Get
	public void formulario() {
		
	}
	
	@Post
	public void salva(Livro livro, Result result) {
		estante.guarda(livro);
		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}
	
	@Get
	public List<Livro> lista() {
		return estante.todoOsLivros();
	}
	
	@Get
	public void edita(String isbn, Result result) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);
		result.of(this).formulario();
	}

}
