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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="concourses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcoursesEntity {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "campo titulo obrigatório")
    @Size(min = 5,max = 50,message = " o titulo da vaga deve ter entre 5  e 50 caracteres")
    private String title;
    
    @NotBlank(message = "campo sobre é obrigatório")
    @Size(min = 100,max=4000,message = "campo sobre deve ter entre 100 e 4000 caracteres")
    private String about;
    
    private String cover;
    
    @Column(name="average-salary",precision = 10, scale = 2)
    private BigDecimal mediaSalary;

    @Temporal(TemporalType.DATE)
    @NotBlank(message = "campo data máxima de inscrição obrigatória")
    private Date dateMaxSubscription;

    @Enumerated(EnumType.STRING)
    private  Status status;
    
    @Enumerated(EnumType.STRING)
    private Abrangency Abrangency;
        
    @Enumerated(EnumType.STRING)
    private Levels level;
    
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "campo data minima de inscrição obrigatória")
    private Date dateMinSubscription;

    @NotBlank(message = "campo url  de inscrição obrigatória")
    private  String urlSubscription;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}



