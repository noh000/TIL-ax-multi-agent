package com.sesac.aibackendintegrationspring.controller;

import com.sesac.aibackendintegrationspring.domain.Region;
import com.sesac.aibackendintegrationspring.dto.RegionRequest;
import com.sesac.aibackendintegrationspring.dto.RegionResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/regions")

public class RegionController {

    private final Map<Long, Region> regions = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @PostMapping
    public RegionResponse create(@Valid @RequestBody RegionRequest request) {

        Region region = request.toEntity();

        region.setId(sequence.getAndIncrement());
        region.setLandmarks(List.of("Sample Landmark 1", "Sample Landmark 2"));

        regions.put(region.getId(), region);

        return RegionResponse.from(region);
    }

    @GetMapping("/{id}")
    public RegionResponse findById(@PathVariable Long id) {

        Region region = regions.get(id);

        if (region == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Region not found"
            );
        }

        return RegionResponse.from(region);
    }

    @GetMapping
    public List<RegionResponse> findAll() {

        return regions.values()
                .stream()
                .map(RegionResponse::from)
                .toList();
    }
}
