package com.stevedev.clientesmservice.services;

import com.stevedev.clientesmservice.dtos.ClienteRequest;
import com.stevedev.clientesmservice.dtos.ClienteResponse;
import com.stevedev.clientesmservice.entitites.ClienteEntity;
import com.stevedev.clientesmservice.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements IClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponse> getAllClientes() {
        List<ClienteEntity> entities = clienteRepository.findAll();
        return entities.stream().map(this::mapToResponse).toList();
    }

    @Override
    public ClienteResponse getClienteById(Long id) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return mapToResponse(entity);
    }

    @Override
    public ClienteResponse createCliente(ClienteRequest request) {
        ClienteEntity entity = mapToEntity(request);
        ClienteEntity savedEntity = clienteRepository.save(entity);

        return mapToResponse(savedEntity);
    }

    @Override
    public ClienteResponse updateCliente(Long id, ClienteRequest request) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (request.getNombre() != null) {
            entity.setNombre(request.getNombre());
        }
        if (request.getApellido() != null) {
            entity.setApellido(request.getApellido());
        }
        if (request.getEmail() != null) {
            entity.setEmail(request.getEmail());
        }
        if (request.getTelefono() != null) {
            entity.setTelefono(request.getTelefono());
        }
        if (request.getFechaNacimiento() != null) {
            entity.setFechaNacimiento(request.getFechaNacimiento());
        }

        ClienteEntity updatedEntity = clienteRepository.save(entity);
        return mapToResponse(updatedEntity);
    }

    @Override
    public void deleteCliente(Long id) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteRepository.delete(entity);
    }

    @Override
    public List<ClienteResponse> getClientesByNombre(String nombre) {
        List<ClienteEntity> entities = clienteRepository.findByNombreContainingIgnoreCase(nombre);

        return entities.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<ClienteResponse> getAllClientesOrderedByName() {
        List<ClienteEntity> entities = clienteRepository.findAllByOrderByNombreAsc();

        return entities.stream().map(this::mapToResponse).toList();
    }

    private ClienteResponse mapToResponse(ClienteEntity entity) {
        ClienteResponse response = new ClienteResponse();
        response.setId(entity.getId());
        response.setNombre(entity.getNombre());
        response.setApellido(entity.getApellido());
        response.setEmail(entity.getEmail());
        response.setTelefono(entity.getTelefono());
        response.setFechaNacimiento(entity.getFechaNacimiento());
        return response;
    }

    private ClienteEntity mapToEntity(ClienteRequest request) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(request.getNombre());
        entity.setApellido(request.getApellido());
        entity.setEmail(request.getEmail());
        entity.setTelefono(request.getTelefono());
        entity.setFechaNacimiento(request.getFechaNacimiento());
        return entity;
    }
}
