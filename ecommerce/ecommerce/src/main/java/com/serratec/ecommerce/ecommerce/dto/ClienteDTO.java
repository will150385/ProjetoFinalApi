package com.serratec.ecommerce.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.serratec.ecommerce.ecommerce.model.Cliente;
import com.serratec.ecommerce.ecommerce.model.Endereco;

public class ClienteDTO {

  private Long id;
  @NotBlank(message = "Campo Obrigatorio")
  private String email;
  @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracters")
  @NotBlank(message = "Campo Obrigatorio")
  private String nomeCompleto;
  @NotBlank(message = "Campo Obrigatorio")
  private String cpf;
  private String dataNascimento;
  private Endereco endereco;

  public ClienteDTO() {
  }

  public ClienteDTO(Long id, String email, String nomeCompleto, String cpf, String dataNascimento,
      Endereco endereco) {
    this.id = id;
    this.email = email;
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
  }

  public ClienteDTO(Cliente cliente) {
    id = cliente.getId();
    email = cliente.getEmail();
    nomeCompleto = cliente.getNomeCompleto();
    cpf = cliente.getCpf();
    dataNascimento = cliente.getDataNascimento();
    endereco = cliente.getEndereco();

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

  public Endereco getEndereco() {
    return this.endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

}