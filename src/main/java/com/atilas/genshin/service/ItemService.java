package com.atilas.genshin.service;

import com.atilas.genshin.exception.BusinessException;
import com.atilas.genshin.exception.ItemBadRequest;
import com.atilas.genshin.exception.ItemNotFoundException;
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
        try {
            Optional<Item> item = itemRepository.findById(id);
            if (item.isEmpty()) {
                throw new ItemNotFoundException("Character by id " + id + "was not found");
            }
            return item.get();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Item update(Integer id, Item item){
        try {
            if (!item.getId().equals(id)) {
                throw new ItemBadRequest(id + " And " + item.getId() + "Don't Match");
            }
            Optional<Item> optional = itemRepository.findById(id);
            if (optional.isEmpty()) {
                throw new ItemNotFoundException("Character by id " + id + "was not found");
            }
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
    public void delete(Integer id){
        try {
            Optional<Item> item = itemRepository.findById(id);
            if (item.isEmpty()) {
                throw new ItemNotFoundException("Character by id " + id + "was not found");
            }
            itemRepository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
