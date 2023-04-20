package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Usar strategy identity é o mesmo que dizer auto increment no MySQL
	private Long id;
	
	@NotBlank(message = "O Atributo nome é obrigatório!")
	@Size(max = 100, message = "O Atributo nome deve ter no máximo 100 caracteres!")
	private String nome;
	
	@NotBlank(message = "O Atributo descrição é obrigatório!") 
	@Size(min = 10, max = 1000, message = "O Atributo descrição deve ter no mínimo 10 caracteres e no máximo 1000 caracteres!")
	private String descricao;
	
	@NotNull(message = "O Atributo quantidade é obrigatório!")
	private int quantidade;
	
	@NotBlank(message = "O Atributo laboratório é obrigatório!")
	@Size(max = 100, message = "O Atributo laboratório deve ter no máximo 100 caracteres!")
	private String laboratorio;
	
	@NotNull(message = "O Atributo preço é obrigatório!")
	@Digits(integer = 5, fraction = 2)
	private BigDecimal preco;
	
	@Size(max = 500, message = "O link da foto não pode ser maior do que 500 caracteres!")
	private String foto;

	/* Relacionamento   */
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
