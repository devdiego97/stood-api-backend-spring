package com.diegodev.stood.dtos.concourses;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import com.diegodev.stood.enums.Abrangency;
import com.diegodev.stood.enums.Levels;
import com.diegodev.stood.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConcourseRequest(
    @NotBlank(message = "campo titulo obrigatório")
    @Size(min = 5,max = 50,message = " o titulo do concurso deve ter entre 5  e 50 caracteres")
    String title,

    @NotBlank(message = "campo sobre é obrigatório")
    @Size(min = 100,max=4000,message = "campo sobre deve ter entre 100 e 4000 caracteres")
    String about,

    String cover,

    @Column(name="average-salary", precision = 10, scale = 2)
    @NotNull(message = "campo média salarial obrigatório")
    BigDecimal mediaSalary,

    @Temporal(TemporalType.DATE)
    @NotNull(message = "campo data máxima de inscrição obrigatória")
     Date dateMaxSubscription,

     @Temporal(TemporalType.DATE)
     @NotNull(message = "campo data mínima de inscrição obrigatória")
    Date dateMinSubscription,
    @Enumerated(EnumType.STRING)
    Status status,

    @Enumerated(EnumType.STRING)
    Abrangency abrangency,

    @Enumerated(EnumType.STRING)
    Levels level,

    @NotBlank(message = "campo urlSubscription obrigatório")
    @Size(min = 5,max = 50,message = " o urlSubscription deve ter entre 5  e 50 caracteres")
    String urlSubscription




) {

}
