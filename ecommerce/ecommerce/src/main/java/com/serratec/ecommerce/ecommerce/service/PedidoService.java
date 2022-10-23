package com.serratec.ecommerce.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.serratec.ecommerce.ecommerce.dto.PedidoDTO;
import com.serratec.ecommerce.ecommerce.model.Pedido;
import com.serratec.ecommerce.ecommerce.repository.PedidoRepository;
import com.serratec.ecommerce.ecommerce.service.exceptions.DatabaseExcption;
import com.serratec.ecommerce.ecommerce.service.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  public PedidoDTO findById(Long id) {

    Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Pedido nao econtrado"));
    PedidoDTO dto = new PedidoDTO(pedido);
    return dto;

  }

  public List<PedidoDTO> findAll() {
    List<Pedido> result = pedidoRepository.findAll();
    return result.stream().map(x -> new PedidoDTO(x)).toList();
  }

  @Transactional
  public PedidoDTO insert(PedidoDTO PedidoDTO) {

    Pedido entity = new Pedido();
    copyDtoToEntity(PedidoDTO, entity);

    entity = pedidoRepository.save(entity);

    return new PedidoDTO(entity);
  }

  public PedidoDTO update(PedidoDTO pedidoDto, Long id) {

    try {
      Pedido entity = new Pedido();
      copyDtoToEntity(pedidoDto, entity);
      entity = pedidoRepository.save(entity);
      return new PedidoDTO(entity);

    } catch (

    EntityNotFoundException e) {
      throw new ResourceNotFoundException("Pedido nao econtrado");

    }

  }

  // @Transactional(propagation = Propagation.SUPPORTS)
  public void deleteById(Long id) {

    try {
      pedidoRepository.deleteById(id);

    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException("Pedido nao econtrado");
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseExcption("Falha de integridade Referencial");
    }

  }

  private void copyDtoToEntity(PedidoDTO pedidoDto, Pedido entity) {

    entity.setDataEntrega(pedidoDto.getDataEntrega());
    entity.setDataEnvio(pedidoDto.getDataEnvio());
    entity.setDataPedido(pedidoDto.getDataPedido());
    entity.setValorTotal(pedidoDto.getValorTotal());
    entity.setStatus(pedidoDto.getStatus());

  }
}