package com.stevedev.clientesmservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
}
