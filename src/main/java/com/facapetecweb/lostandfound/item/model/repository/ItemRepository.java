package com.facapetecweb.lostandfound.item.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facapetecweb.lostandfound.item.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
