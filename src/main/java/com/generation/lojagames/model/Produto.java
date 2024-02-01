package com.generation.lojagames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!") 
	@Size(min = 5, max = 100, message = "O nome do produto deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo descricao é Obrigatório!")
	@Size(min = 10, max = 300, message = "O atributo descricao deve conter no mínimo 10 e no máximo 300 caracteres")
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O atributo preço é obrigatório.")
	@Positive(message = "O atributo preço deve ser positivo.")
	private BigDecimal preco;
	
	@JsonIgnoreProperties("produto")
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	private Long estoque;
	
	//getters e setters
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}
}
	