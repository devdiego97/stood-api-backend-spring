package com.diegodev.stood.dtos.concourses;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.diegodev.stood.enums.Abrangency;
import com.diegodev.stood.enums.Levels;
import com.diegodev.stood.enums.Status;

public record ConcourseResponseDTO(
   Long id,
    String title,
    String about,
    String cover,
    Date dateMaxSubscription,
    Date dateMinSubscription,
    Status status,
    Abrangency abrangency,
    Levels level,
    String urlSubscription,
    BigDecimal mediaSalary,
    BigInteger numVacancies,
    String city,
    String state,
    String organization,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
