package com.serratec.ecommerce.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.serratec.ecommerce.ecommerce.config.MailConfig;
import com.serratec.ecommerce.ecommerce.dto.ClienteDTO;
import com.serratec.ecommerce.ecommerce.dto.ClienteInserirDTO;
import com.serratec.ecommerce.ecommerce.dto.EnderecoInserirDTO;
import com.serratec.ecommerce.ecommerce.model.Cliente;
import com.serratec.ecommerce.ecommerce.model.Endereco;
import com.serratec.ecommerce.ecommerce.repository.ClienteRepository;
import com.serratec.ecommerce.ecommerce.repository.EnderecoRepository;
import com.serratec.ecommerce.ecommerce.service.exceptions.DatabaseExcption;
import com.serratec.ecommerce.ecommerce.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

  @Autowired
  ClienteRepository clienteRepository;
  @Autowired
  EnderecoRepository enderecoRepository;

  @Autowired
  EnderecoService enderecoService;

  @Autowired
  private MailConfig mailConfig;

  public ClienteDTO findById(Long id) {

    Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente nao econtrado"));
    ClienteDTO dto = new ClienteDTO(cliente);
    return dto;

  }

  public List<ClienteDTO> findAll() {
    List<Cliente> result = clienteRepository.findAll();
    return result.stream().map(x -> new ClienteDTO(x)).toList();
  }

  public ClienteDTO inserir(ClienteInserirDTO c) {

    EnderecoInserirDTO endereco = c.getEndereco();
    Endereco enderecoViaCep = enderecoService.salvar(endereco.getCep(), endereco.getComplemento(),
        endereco.getNumero());

    Cliente cliente = new Cliente();
    cliente.setNomeCompleto(c.getNomeCompleto());
    cliente.setEmail(c.getEmail());
    cliente.setCpf(c.getCpf());
    cliente.setDataNascimento(c.getDataNascimento());
    cliente.setEndereco(enderecoViaCep);
    cliente = clienteRepository.save(cliente);

    mailConfig.sendEmail(c.getEmail(), "Cadastro de Usuário",
        cliente.toString());

    return new ClienteDTO(cliente);
  }

  public ClienteDTO update(ClienteDTO productDto, Long id) {

    try {
      Cliente entity = new Cliente();
      copyDtoToEntity(productDto, entity);
      entity = clienteRepository.save(entity);
      return new ClienteDTO(entity);

    } catch (

    EntityNotFoundException e) {
      throw new ResourceNotFoundException("Recurso nao encontrado");

    }

  }

  public void deleteById(Long id) {

    try {
      clienteRepository.deleteById(id);

    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException("Cliente nao econtrado");
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseExcption("Falha de integridade Referencial");
    }

  }

  private void copyDtoToEntity(ClienteDTO clienteDto, Cliente entity) {

    entity.setNomeCompleto(clienteDto.getNomeCompleto());
    entity.setDataNascimento(clienteDto.getDataNascimento());
    entity.setEmail(clienteDto.getEmail());
    entity.setCpf(clienteDto.getCpf());

  }
}