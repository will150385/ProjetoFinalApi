package com.serratec.ecommerce.ecommerce.dto;

import com.serratec.ecommerce.ecommerce.model.Cliente;

public class ClienteInserirDTO {

  private Long id;
  private String email;
  private String nomeCompleto;
  private String cpf;
  private String dataNascimento;
  private EnderecoInserirDTO endereco;

  public ClienteInserirDTO() {
  }

  public ClienteInserirDTO(Cliente cliente) {
    this.email = cliente.getEmail();
    this.nomeCompleto = cliente.getNomeCompleto();
    this.cpf = cliente.getCpf();
    this.dataNascimento = cliente.getDataNascimento();
    this.endereco = new EnderecoInserirDTO(cliente.getEndereco());
  }

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

  public EnderecoInserirDTO getEndereco() {
    return this.endereco;
  }

  public void setEndereco(EnderecoInserirDTO endereco) {
    this.endereco = endereco;
  }

}