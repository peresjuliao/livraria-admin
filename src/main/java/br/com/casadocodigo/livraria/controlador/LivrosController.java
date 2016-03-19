package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Controller
public class LivrosController {

	private final Estante estante;
	private final Result result;
	private final Validator validator;

	@Inject
	public LivrosController(Estante estante, Result result, Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	public LivrosController() {
		this(null, null, null);
	}

	@Get
	public void formulario() {

	}

	@Post
	public void salva(Livro livro) {
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();
		estante.guarda(livro);
		result.redirectTo(this).lista();
	}

	@Get
	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	@Get
	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}
	}

}
