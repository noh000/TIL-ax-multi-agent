package com.sesac.aibackendintegrationspring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column(
            unique = true,
            nullable = false,
            length = 50
    )
    private String name;
}
