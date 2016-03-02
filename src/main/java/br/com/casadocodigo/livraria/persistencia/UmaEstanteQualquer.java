package br.com.casadocodigo.livraria.persistencia;

import java.util.Arrays;
import java.util.List;

import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

public class UmaEstanteQualquer implements Estante {

	@Override
	public void guarda(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Livro> todoOsLivros() {
		Livro vraptor = new Livro();
		vraptor.setIsbn("123-45");
		vraptor.setTitulo("VRaptor 4");
		vraptor.setDescricao("Um livro sobre arquitetura");
		
		Livro arquitetura = new Livro();
		arquitetura.setIsbn("5678-90");
		arquitetura.setTitulo("Arquitetura");
		arquitetura.setDescricao("Um livro sobre arquitetura");
		
		return Arrays.asList(vraptor, arquitetura);
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
