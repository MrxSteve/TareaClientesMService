package com.stevedev.clientesmservice.controllers;

import com.stevedev.clientesmservice.dtos.ClienteRequest;
import com.stevedev.clientesmservice.dtos.ClienteResponse;
import com.stevedev.clientesmservice.services.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class ClienteController {
    private final IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll() {
        List<ClienteResponse> response = clienteService.getAllClientes();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable Long id) {
        ClienteResponse response = clienteService.getClienteById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.createCliente(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.updateCliente(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClienteResponse>> findByNombre(@RequestParam String nombre) {
        List<ClienteResponse> response = clienteService.getClientesByNombre(nombre);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order")
    public ResponseEntity<List<ClienteResponse>> findByOrderByNombre() {
        List<ClienteResponse> response = clienteService.getAllClientesOrderedByName();
        return ResponseEntity.ok(response);
    }
}
