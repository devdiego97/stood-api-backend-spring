package com.diegodev.stood.controllers;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.diegodev.stood.dtos.concourses.ConcourseRequestDTO;
import com.diegodev.stood.dtos.concourses.ConcourseResponseDTO;
import com.diegodev.stood.services.ConcourseService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/concourses")
@CrossOrigin(origins = "http://localhost:4200") 
@RequiredArgsConstructor
public class ConcourseController {

    private final ConcourseService concourseService;



    @GetMapping
    public Page<ConcourseResponseDTO> getAllConcourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return concourseService.listAllConcourses(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcourseResponseDTO> getConcourseById(@PathVariable Long id) {
        ConcourseResponseDTO response = concourseService.getConcourseById(id);
        return ResponseEntity.ok(response);
    }
   

    @PostMapping()
    public ResponseEntity<ConcourseResponseDTO> addNewConcourse(
           @RequestBody ConcourseRequestDTO concourseRequest) {

        ConcourseResponseDTO response = concourseService.createConcourse(concourseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } 


    @PutMapping("/{id}")
    public ResponseEntity<ConcourseResponseDTO> updateConcourseById(
            @PathVariable Long id,
            @RequestBody ConcourseRequestDTO concourseRequest) {
        ConcourseResponseDTO response = concourseService.updateConcourse(id, concourseRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcourseById(@PathVariable Long id) {
        concourseService.deleteConcourse(id);
        return ResponseEntity.noContent().build();
    }
}