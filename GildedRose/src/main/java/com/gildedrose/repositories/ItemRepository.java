package com.gildedrose.repositories;

import com.gildedrose.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item, String> {

    List<Item> findAll();
}
