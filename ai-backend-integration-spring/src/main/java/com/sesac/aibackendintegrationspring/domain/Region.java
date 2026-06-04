package com.sesac.aibackendintegrationspring.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Region {

    private Long id;
    private String name;
    private List<String> landmarks;
    private Double area;
    private Long population;
}