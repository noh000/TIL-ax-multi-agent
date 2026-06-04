package com.sesac.aibackendintegrationspring.dto;

import com.sesac.aibackendintegrationspring.domain.Region;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record RegionRequest(
        @NotBlank String name,
        @DecimalMin("0.0") Double area,
        @Min(0) Long population
) {
    public Region toEntity() {

        return Region.builder()
                .name(name)
                .area(area)
                .population(population)
                .build();
    }
}
