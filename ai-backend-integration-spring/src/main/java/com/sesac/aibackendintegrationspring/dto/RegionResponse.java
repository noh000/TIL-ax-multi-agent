package com.sesac.aibackendintegrationspring.dto;

import com.sesac.aibackendintegrationspring.domain.Region;

import java.util.List;

public record RegionResponse(Long id, String name, List<String> landmarks) {

    public static RegionResponse from(Region region) {
        return new RegionResponse(region.getId(), region.getName(), region.getLandmarks());
    }
}
