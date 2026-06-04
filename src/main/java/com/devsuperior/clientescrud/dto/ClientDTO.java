package com.devsuperior.clientescrud.dto;

import com.devsuperior.clientescrud.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @Size(min = 10, max = 50, message = "The name must be between 10 and 50 characters long")
    @NotBlank(message = "Field name is required")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Birthdate cannot be a future date")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client clientEntity) {
        id = clientEntity.getId();
        name = clientEntity.getName();
        cpf = clientEntity.getCpf();
        income = clientEntity.getIncome();
        birthDate = clientEntity.getBirthDate();
        children = clientEntity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
