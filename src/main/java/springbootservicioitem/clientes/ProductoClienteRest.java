package springbootservicioitem.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springbootservicioitem.model.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	@GetMapping("/listar")
	public List<Producto> listar();

	@GetMapping("/listar/{id}")
	public Producto detalle(@PathVariable Long id);

}