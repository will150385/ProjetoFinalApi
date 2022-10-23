package com.serratec.ecommerce.ecommerce.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")


@Entity
@Table(name = "tb_produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private BigDecimal qtdEstoque;
  private Instant dataCadastro;
  private BigDecimal valorUnitario;

  @OneToMany(mappedBy = "itemPedidoPk.produto")
  private Set<ItemPedido> items = new HashSet<>();

  public Produto() {
  }

  public Produto(String imagemUrl, String imagemFileName,String imageNome,Long id, String nome, BigDecimal qtdEstoque, Instant dataCadastro, BigDecimal valorUnitario,
      Set<ItemPedido> items) {
    this.id = id;
    this.nome = nome;
    this.qtdEstoque = qtdEstoque;
    this.dataCadastro = dataCadastro;
    this.valorUnitario = valorUnitario;
    this.items = items;
    this.imagemUrl = imagemUrl;
    this.imagemFileName =imagemFileName;
    this.imageNome = imageNome;
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

  public Set<ItemPedido> getItems() {
    return this.items;
  }

  public void setItems(Set<ItemPedido> items) {
    this.items = items;
  }
  @Column(name="imagem_nome")
  private String imageNome;
  
  @Column(name="imagem_filename")
  private String imagemFileName;
  
  @Column(name="imagem_url")
  private String imagemUrl;

public String getImagemUrl() {
	return imagemUrl;
}

public void setImagemUrl(String imagemUrl) {
	this.imagemUrl = imagemUrl;
}

public String getImageNome() {
	return imageNome;
}

public void setImageNome(String imageNome) {
	this.imageNome = imageNome;
}

public String getImagemFileName() {
	return imagemFileName;
}

public void setImagemFileName(String imagemFileName) {
	this.imagemFileName = imagemFileName;
}
  
}