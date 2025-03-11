package com.diegodev.stood.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/concourses")
public class ConcourseController {
    

    @GetMapping()
    public String getAllConcourses(){
        return "lista de concursos";
    }

    public String getConcourseId(){
        return "lista de concursos";
    }
    public String addNewConcourse(){
        return "lista de concursos";
    }
    public String updateConcourseId(){
        return "lista de concursos";
    }
    public String deleteConcourseId(){
        return "lista de concursos";
    }
}
