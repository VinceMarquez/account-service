package com.mqz.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateAccountRequest(@NotNull @JsonProperty("name") String name,
                                   @NotNull @JsonProperty("birth_date") LocalDate birthDate) {
}
