package com.sesac.aibackendintegrationspring.repository;

import com.sesac.aibackendintegrationspring.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
