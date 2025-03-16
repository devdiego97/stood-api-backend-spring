package com.diegodev.stood.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diegodev.stood.dtos.concourses.ConcourseRequest;
import com.diegodev.stood.dtos.concourses.ConcourseResponse;
import com.diegodev.stood.entites.ConcourseEntity;
import com.diegodev.stood.exception.ResourceNotFoundException;
import com.diegodev.stood.repositorys.ConcourseRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ConcourseService {

    private final ConcourseRepository concourseRepository;

    public ConcourseResponse createConcourse(ConcourseRequest concourseRequest) {
        ConcourseEntity concourseEntity = ConvertDTOtoEntity(concourseRequest);
        ConcourseEntity savedConcourse = concourseRepository.save(concourseEntity);
        return convertToResponse(savedConcourse);
    }

    public Page<ConcourseResponse> listAllConcourses(Pageable pageable) {
        // Recupera uma página de entidades ConcourseEntity do banco de dados
        Page<ConcourseEntity> concoursePage = concourseRepository.findAll(pageable);

        // Converte cada ConcourseEntity em ConcourseResponse
        List<ConcourseResponse> concourseResponses = concoursePage.getContent().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());

        // Retorna uma página de ConcourseResponse
        return new PageImpl<>(concourseResponses, pageable, concoursePage.getTotalElements());
    }

    public ConcourseResponse getConcourseById(Long id) {
        ConcourseEntity concourseEntity = concourseRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Concurso não encontrado com o ID: " + id));
        return convertToResponse(concourseEntity);
    }

    public ConcourseResponse updateConcourse(Long id, ConcourseRequest concourseRequest) {
        ConcourseEntity concourseEntity = concourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concurso não encontrado"));
        concourseEntity.setTitle(concourseRequest.title());
        concourseEntity.setAbout(concourseRequest.about());
        concourseEntity.setAbrangency(concourseRequest.abrangency());
        concourseEntity.setCover(concourseRequest.cover());
        concourseEntity.setDateMaxSubscription(concourseRequest.dateMaxSubscription());
        concourseEntity.setDateMinSubscription(concourseRequest.dateMinSubscription());
        concourseEntity.setLevel(concourseRequest.level());
        concourseEntity.setMediaSalary(concourseRequest.mediaSalary());
        concourseEntity.setStatus(concourseRequest.status());
        concourseEntity.setUrlSubscription(concourseRequest.urlSubscription());
        ConcourseEntity updatedConcourse = concourseRepository.save(concourseEntity);
        return convertToResponse(updatedConcourse);
    }

    public void deleteConcourse(Long id) {
        if (!concourseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Concurso não encontrado");
        }
        concourseRepository.deleteById(id);
    }

    // Recebe os dados do DTO e converte para entidade
    private ConcourseEntity ConvertDTOtoEntity(ConcourseRequest concourse) {
        ConcourseEntity concourseEntity = new ConcourseEntity();
        concourseEntity.setTitle(concourse.title());
        concourseEntity.setAbout(concourse.about());
        concourseEntity.setAbrangency(concourse.abrangency());
        concourseEntity.setCover(concourse.cover());
        concourseEntity.setDateMaxSubscription(concourse.dateMaxSubscription());
        concourseEntity.setDateMinSubscription(concourse.dateMinSubscription());
        concourseEntity.setLevel(concourse.level());
        concourseEntity.setMediaSalary(concourse.mediaSalary());
        concourseEntity.setStatus(concourse.status());
        concourseEntity.setUrlSubscription(concourse.urlSubscription());
        return concourseEntity;
    }

    private ConcourseResponse convertToResponse(ConcourseEntity concourseEntity) {
        return new ConcourseResponse(
            concourseEntity.getId(),
            concourseEntity.getTitle(),
            concourseEntity.getAbout(),
            concourseEntity.getCover(),
            concourseEntity.getDateMaxSubscription(),
            concourseEntity.getDateMinSubscription(),
            concourseEntity.getStatus(),
            concourseEntity.getAbrangency(),
            concourseEntity.getLevel(),
            concourseEntity.getUrlSubscription(),
            concourseEntity.getMediaSalary(),
            concourseEntity.getCreatedAt(),
            concourseEntity.getUpdatedAt()
        );
    }
}