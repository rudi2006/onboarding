package com.lcl.onboarding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CustomerRegistrationRequest(
        @NotBlank(message = "Le prénom est obligatoire")
        String firstName,

        @NotBlank(message = "Le nom est obligatoire")
        String lastName,

        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "Format d'email invalide")
        String email,

        @NotNull(message = "La date de naissance est obligatoire")
        @Past(message = "La date de naissance doit être dans le passé")
        LocalDate birthDate
) {}