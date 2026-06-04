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
    private List<String> landmark;
    private double area;
    private long population;
}