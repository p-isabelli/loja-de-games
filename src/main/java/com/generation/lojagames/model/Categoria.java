package com.generation.lojagames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table (name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idcat;
	
	@NotBlank (message = "O nome da Categoria é obrigatório! ")
	@Size(min = 3, max = 100, message = "O nome da Categoria deve conter no mínimo 03 caracteres e no máximo 100 caracteres!")
	private String categoria;
	
	@NotBlank (message = " A Descrição da categoria é obrigatória! ")
	@Size(min = 10, max = 100, message = "A descrição da categoria deve conter no mínimo 10 caracteres e no máximo 100 caracteres!")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Long getIdcat() {
		return idcat;
	}

	public void setIdcat(Long idcat) {
		this.idcat = idcat;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}