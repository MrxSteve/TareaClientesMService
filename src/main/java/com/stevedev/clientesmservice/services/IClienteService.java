package com.stevedev.clientesmservice.services;

import com.stevedev.clientesmservice.dtos.ClienteRequest;
import com.stevedev.clientesmservice.dtos.ClienteResponse;

import java.util.List;

public interface IClienteService {
    List<ClienteResponse> getAllClientes();
    ClienteResponse getClienteById(Long id);
    ClienteResponse createCliente(ClienteRequest request);
    ClienteResponse updateCliente(Long id, ClienteRequest request);
    void deleteCliente(Long id);

    List<ClienteResponse> getClientesByNombre(String nombre);
    List<ClienteResponse> getAllClientesOrderedByName();
}
