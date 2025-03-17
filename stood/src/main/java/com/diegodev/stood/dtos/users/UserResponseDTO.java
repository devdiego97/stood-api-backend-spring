package com.diegodev.stood.dtos.users;



public record UserResponseDTO(
    Long id,
    String name,
    String photo,
    String lastname,
    String tel,
    String email
) {}
