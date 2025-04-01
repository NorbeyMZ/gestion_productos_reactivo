package com.example.productos.repository; 
import com.example.productos.model.Producto;

import reactor.core.publisher.Mono;

import org.springframework.data.repository.reactive.ReactiveCrudRepository; 
import org.springframework.stereotype.Repository; 
@Repository 
public interface ProductoRepository extends ReactiveCrudRepository<Producto, String> 
{ 
    Mono<Producto> findByNombre(String nombre);
}