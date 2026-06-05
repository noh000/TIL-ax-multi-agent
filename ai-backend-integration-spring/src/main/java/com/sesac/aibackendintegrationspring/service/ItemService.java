package com.sesac.aibackendintegrationspring.service;

import com.sesac.aibackendintegrationspring.domain.Item;
import com.sesac.aibackendintegrationspring.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> findAll() {
        return repository.findAll();
    }  // 전체 조회

    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }  // ID 값으로 조회

    public Item save(Item item) {
        return repository.save(item);
    }  // 값이 없으면 저장, 있으면 수정

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }  // Bool

    public void deleteById(Long id) {
        repository.deleteById(id);
    }  // ID로 한 건 삭제
}
