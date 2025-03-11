package com.diegodev.stood.dtos.concourses;

import java.sql.Date;

import com.diegodev.stood.enums.Abrangency;
import com.diegodev.stood.enums.Levels;
import com.diegodev.stood.enums.Status;

public record ConcourseResponse(
    Long id,
    String title,
    String about,
    String cover,
    Date dateMaxSubscription,
    Date dateMinSubscription,
    Status status,
    Abrangency abrangency,
    Levels level,
    String urlSubscription
) {

}
