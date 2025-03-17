package com.diegodev.stood.entites;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min=4,max = 30,message = " o nome deve ter entre 4 e 30 caracteres")
    private String name;

    @Column(nullable = true)
    private String photo;

    @NotBlank(message = "O sobrenome é obrigatório")
    @Size(min=4,max = 30,message = " o sobrenome deve ter entre 4 e 30 caracteres")
    private String lastname;

    @Pattern(regexp = "^[0-9]+$", message = "O telefone deve conter apenas números")
    private String tel;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6,max=30,message = "A senha deve ter pelo menos 6 caracteres,e  no maximo 30 caracteres")
    private String password;
}