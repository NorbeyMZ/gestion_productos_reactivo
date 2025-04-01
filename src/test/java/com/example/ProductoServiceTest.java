package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import com.example.productos.service.ProductoService; 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void listarProductos() {
        when(productoRepository.findAll()).thenReturn(Flux.just(
            new Producto("1", "Producto 1", 100.0),
            new Producto("2", "Producto 2", 200.0)
        ));

        var productos = productoService.listarproductos().collectList().block();

        assertNotNull(productos);
        assertEquals(2, productos.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void obtenerProductoPorId() {
        when(productoRepository.findById("1")).thenReturn(Mono.just(new Producto("1", "Producto 1", 100.0)));

        var producto = productoService.buscarPorId("1").block();

        assertNotNull(producto);
        assertEquals("1", producto.getId());
        assertEquals("Producto 1", producto.getNombre());
        verify(productoRepository, times(1)).findById("1");
    }

    @Test
    void crearProducto() {
        Producto nuevoProducto = new Producto(null, "Nuevo Producto", 150.0);
        Producto productoGuardado = new Producto("3", "Nuevo Producto", 150.0);

        when(productoRepository.save(any(Producto.class))).thenReturn(Mono.just(productoGuardado));

        var resultado = productoService.guardar(nuevoProducto).block();

        assertNotNull(resultado);
        assertEquals("3", resultado.getId());
        verify(productoRepository, times(1)).save(any(Producto.class));
    }
}
