package com.serratec.ecommerce.ecommerce.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.ecommerce.ecommerce.dto.PedidoDTO;
import com.serratec.ecommerce.ecommerce.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

  @Autowired
  PedidoService pedidoService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {
    PedidoDTO dto = pedidoService.findById(id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping
  public ResponseEntity<List<PedidoDTO>> findAll() {
    List<PedidoDTO> dto = pedidoService.findAll();
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<PedidoDTO> insert(@Valid @RequestBody PedidoDTO PedidoDTO) {
    PedidoDTO dto = pedidoService.insert(PedidoDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<PedidoDTO> update(@Valid @PathVariable Long id, @RequestBody PedidoDTO productDto) {
    productDto = pedidoService.update(productDto, id);
    return ResponseEntity.ok(productDto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    pedidoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}