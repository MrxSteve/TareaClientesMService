package com.stevedev.clientesmservice.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
}
