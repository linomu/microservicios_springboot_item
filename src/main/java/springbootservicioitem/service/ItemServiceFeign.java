package springbootservicioitem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import feign.FeignException;
import springbootservicioitem.clientes.ProductoClienteRest;
import springbootservicioitem.model.Item;
import springbootservicioitem.model.Producto;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clientFeign;

	@Override
	public List<Item> findAll() {
		try {
			return clientFeign.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
		} catch (FeignException e) {
			e.getStackTrace();
			return null;
		}
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clientFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clientFeign.crear(producto);
	}

	@Override
	public void deleteById(Long id) {
		clientFeign.eliminar(id);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clientFeign.update(producto, id);
	}

}
