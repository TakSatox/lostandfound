package com.facapetecweb.lostandfound.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facapetecweb.lostandfound.item.model.entity.Item;
import com.facapetecweb.lostandfound.item.model.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {
    
    private final ItemRepository repository;

    public Item save(Item item) {
        return repository.save(item);
    }

    public Optional<Item> getById(Long id) {
        return repository.findById(id);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public void update(Long id, Item updatedItem) {
        Item item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

        Optional.ofNullable(updatedItem.getTitle()).ifPresent(item::setTitle);
        Optional.ofNullable(updatedItem.getPictureLink()).ifPresent(item::setPictureLink);
        Optional.ofNullable(updatedItem.getCurrentLocation()).ifPresent(item::setCurrentLocation);
        Optional.ofNullable(updatedItem.getFoundLocation()).ifPresent(item::setFoundLocation);
        Optional.ofNullable(updatedItem.getFoundDate()).ifPresent(item::setFoundDate);
        Optional.ofNullable(updatedItem.getWhoFound()).ifPresent(item::setWhoFound);
        Optional.ofNullable(updatedItem.getIsRetrieved()).ifPresent(item::setIsRetrieved);
        Optional.ofNullable(updatedItem.getWhoRetrieved()).ifPresent(item::setWhoRetrieved);
        Optional.ofNullable(updatedItem.getRetrievedDate()).ifPresent(item::setRetrievedDate);

        repository.save(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
