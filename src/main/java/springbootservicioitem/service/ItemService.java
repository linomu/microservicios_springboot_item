package springbootservicioitem.service;

import java.util.List;

import springbootservicioitem.model.Item;
import springbootservicioitem.model.Producto;

public interface ItemService {
	public List<Item> findAll();

	public Item findById(Long id, Integer cantidad);

	public Producto save(Producto producto);

	public void deleteById(Long id);

	public Producto update(Producto producto, Long id);
}
