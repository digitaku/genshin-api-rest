package com.atilas.genshin.service;

import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.CharactersNotFoundException;
import com.atilas.genshin.exception.ItemBadRequest;
import com.atilas.genshin.exception.ItemNotFoundException;
import com.atilas.genshin.model.Characters;
import com.atilas.genshin.model.Item;
import com.atilas.genshin.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item add(Item item) {
        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Item> listAll() {
        try {
            return itemRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Item listOne(Integer id) {
        Optional<Item> item;
        try {
           item = itemRepository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (item.isEmpty()) {
            throw new ItemNotFoundException("Character by id:" + id + " was not found");
        }
        return item.get();
    }

    public Item update(Integer id, Item item) {
        if (!item.getId().equals(id)) {
            throw new ItemBadRequest("item id and url id don't Match");
        }
        Optional<Item> optional;
        try {
            optional = itemRepository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Character by id:" + id + " was not found");
        }
        return itemRepository.save(item);
    }

    public void delete(Integer id) {
        Optional<Item> optional;
        try {
            optional = itemRepository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Item by id:" + id + " was not found");
        }
        itemRepository.deleteById(id);
    }
}
