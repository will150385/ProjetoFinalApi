package com.serratec.ecommerce.ecommerce.dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.validation.constraints.Positive;

import com.serratec.ecommerce.ecommerce.model.Produto;

public class ProdutoDTO {
  private Long id;
  private String nome;
  private BigDecimal qtdEstoque;
  private Instant dataCadastro;
  @Positive(message = "o preco precisa ser positivo")
  private BigDecimal valorUnitario;
  private String imagemNome;
  private String imagemFileName;
  private String imagemUrl; 

  public ProdutoDTO() {
  }

  public ProdutoDTO(Long id, String nome, BigDecimal qtdEstoque, Instant dataCadastro, BigDecimal valorUnitario,
		  String imagemNome,String imagemFileName,String imagemUrl) {
    this.id = id;
    this.nome = nome;
    this.qtdEstoque = qtdEstoque;
    this.dataCadastro = dataCadastro;
    this.valorUnitario = valorUnitario;
    this.imagemNome =imagemNome;
    this.imagemFileName =imagemFileName;
    this.imagemUrl =imagemUrl;
    
  }
  

  public ProdutoDTO(Produto entity) {
    id = entity.getId();
    nome = entity.getNome();
    qtdEstoque = entity.getQtdEstoque();
    dataCadastro = entity.getDataCadastro();
    valorUnitario = entity.getValorUnitario();
    imagemNome =entity.getImagemFileName();
    imagemFileName =entity.getImagemFileName();
    imagemUrl = entity.getImagemUrl();
    
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

  public BigDecimal getQtdEstoque() {
    return this.qtdEstoque;
  }

  public void setQtdEstoque(BigDecimal qtdEstoque) {
    this.qtdEstoque = qtdEstoque;
  }

  public Instant getDataCadastro() {
    return this.dataCadastro;
  }

  public void setDataCadastro(Instant dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public BigDecimal getValorUnitario() {
    return this.valorUnitario;
  }

  public void setValorUnitario(BigDecimal valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

public String getImagemNome() {
	return imagemNome;
}

public void setImagemNome(String imagemNome) {
	this.imagemNome = imagemNome;
}

public String getImagemFileName() {
	return imagemFileName;
}

public void setImagemFileName(String imagemFileName) {
	this.imagemFileName = imagemFileName;
}

public String getImagemUrl() {
	return imagemUrl;
}

public void setImagemUrl(String imagemUrl) {
	this.imagemUrl = imagemUrl;
}

@Override
public String toString() {
	return "ProdutoDTO [id=" + id + ", nome=" + nome + ", qtdEstoque=" + qtdEstoque + ", dataCadastro=" + dataCadastro
			+ ", valorUnitario=" + valorUnitario + ", imagemNome=" + imagemNome + ", imagemFileName=" + imagemFileName
			+ ", imagemUrl=" + imagemUrl + "]";
}




}