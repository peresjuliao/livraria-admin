package br.com.casadocodigo.livraria.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "{campo.obrigatorio}")
	private String isbn;
	
	@NotNull(message = "{campo.obrigatorio}")
	private String titulo;
	
	@NotNull(message = "{campo.obrigatorio}")
    @DecimalMin(value="0.0")
	private BigDecimal preco;
	
	
	private Calendar dataPublicacao;
	
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
