package com.diegodev.stood.entites;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Indexed;

import com.diegodev.stood.enums.Status;
import com.diegodev.stood.enums.Abrangency;
import com.diegodev.stood.enums.Levels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="concourses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcourseEntity {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "campo titulo obrigatório")
    @Size(min = 5,max = 50,message = " o titulo do concurso deve ter entre 5  e 50 caracteres")
    private String title;
    
    @NotBlank(message = "campo sobre é obrigatório")
    @Size(min = 100,max=4000,message = "campo sobre deve ter entre 100 e 4000 caracteres")
    private String about;
    @NotBlank(message = "campo urlSubscription obrigatório")
    @Size(min = 5,max = 50,message = " o urlSubscription deve ter entre 5  e 50 caracteres")
    private String urlSubscription;
    
    private String cover;
    
    @Column(name="average-salary", precision = 10, scale = 2)
    @NotNull(message = "campo média salarial obrigatório") // Adicione se for obrigatório
    private BigDecimal mediaSalary;

    @Enumerated(EnumType.STRING)
    private  Status status;
    
    @Enumerated(EnumType.STRING)
    private Abrangency abrangency;
        
    @Enumerated(EnumType.STRING)
    private Levels level;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "campo data máxima de inscrição obrigatória") // Use @NotNull em vez de @NotBlank
    private Date dateMaxSubscription;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "campo data mínima de inscrição obrigatória") // Use @NotNull em vez de @NotBlank
    private Date dateMinSubscription;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}



