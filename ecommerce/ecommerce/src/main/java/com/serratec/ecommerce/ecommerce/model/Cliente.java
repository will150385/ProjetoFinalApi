package com.serratec.ecommerce.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String email;
  private String nomeCompleto;

  @Column(unique = true)
  private String cpf;

  @NotNull(message = "você deve digitar uma data correta")
  private String dataNascimento;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_endereco")
  private Endereco endereco;

  @OneToMany(mappedBy = "cliente")
  private Set<Pedido> pedidos = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNomeCompleto() {
    return this.nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Set<Pedido> getPedidos() {
    return this.pedidos;
  }

  public void setPedidos(Set<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  @Override
  public String toString() {
    return "Email: " + email + "\nNome Completo: " + nomeCompleto + "\nCpf: "
        + cpf + "\nData de Nascimento: " + dataNascimento;
  }

}