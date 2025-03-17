package com.diegodev.stood.dtos.users;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
    @NotBlank(message = "O nome é obrigatório")
    @Size(min=4,max = 30,message = " o nome deve ter entre 4 e 30 caracteres")
   String name,

    @Column(nullable = true)
    String photo,

    @NotBlank(message = "O sobrenome é obrigatório")
    @Size(min=4,max = 30,message = " o sobrenome deve ter entre 4 e 30 caracteres")
     String lastname,

    @Pattern(regexp = "^[0-9]+$", message = "O telefone deve conter apenas números")
    String tel,

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Column(nullable = false, unique = true)
   String email,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6,max=30,message = "A senha deve ter pelo menos 6 caracteres,e  no maximo 30 caracteres")
    String password
) {}
