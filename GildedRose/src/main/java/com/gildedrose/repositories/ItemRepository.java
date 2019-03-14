package com.gildedrose.repositories;

import com.gildedrose.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item, String> {
}
