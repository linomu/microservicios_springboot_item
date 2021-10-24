package springbootservicioitem.service;

import java.util.List;

import springbootservicioitem.model.Item;

public interface ItemService {
	public List<Item> findAll();

	public Item findById(Long id, Integer cantidad);
}
