package com.serratec.ecommerce.ecommerce.dto;

import com.serratec.ecommerce.ecommerce.model.Categoria;

public class CategoriaDTO {

  private Long id;
  private String nome;
  private String descricao;

  public CategoriaDTO(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public CategoriaDTO(Categoria categoria) {
    this.nome = categoria.getNome();
    this.descricao = categoria.getDescricao();
    this.id = categoria.getId();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}