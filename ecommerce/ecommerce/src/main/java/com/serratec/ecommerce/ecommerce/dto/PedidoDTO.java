package com.serratec.ecommerce.ecommerce.dto;

import java.time.Instant;

import com.serratec.ecommerce.ecommerce.model.Pedido;
import com.serratec.ecommerce.ecommerce.model.Status;

public class PedidoDTO {

  private Long id;
  private Instant dataPedido;
  private String dataEntrega;
  private String dataEnvio;
  private Status status;
  private String valorTotal;

  public PedidoDTO() {
  }

  public PedidoDTO(Instant dataPedido, String dataEntrega, String dataEnvio, Status status, String valorTotal) {
    this.dataPedido = dataPedido;
    this.dataEntrega = dataEntrega;
    this.dataEnvio = dataEnvio;
    this.status = status;
    this.valorTotal = valorTotal;
  }

  public PedidoDTO(Pedido pedido) {
    this.id = pedido.getId();
    this.dataPedido = pedido.getDataPedido();
    this.dataEntrega = pedido.getDataEntrega();
    this.dataEnvio = pedido.getDataEnvio();
    this.status = pedido.getStatus();
    this.valorTotal = pedido.getValorTotal();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getDataPedido() {
    return this.dataPedido;
  }

  public void setDataPedido(Instant dataPedido) {
    this.dataPedido = dataPedido;
  }

  public String getDataEntrega() {
    return this.dataEntrega;
  }

  public void setDataEntrega(String dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public String getDataEnvio() {
    return this.dataEnvio;
  }

  public void setDataEnvio(String dataEnvio) {
    this.dataEnvio = dataEnvio;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(String valorTotal) {
    this.valorTotal = valorTotal;
  }

}