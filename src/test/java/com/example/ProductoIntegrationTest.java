package com.example.productos.integration;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ProductoRepository productoRepository;

    private Producto producto;

    @BeforeEach
    void setup() {
       
        producto = new Producto(null, "Producto Test", 99.99);
        producto = productoRepository.save(producto).block(); // Asegura que el producto se guarda antes de los tests
    }
    

    @Test
    void testCrearProducto() {
        webTestClient.post().uri("/api/productos")
                .headers(headers -> headers.setBasicAuth("usuario", "clave123"))
                .body(Mono.just(producto), Producto.class)
                .exchange()
                .expectStatus().isCreated()  // Asegura que la respuesta es 201
                .expectBody(Producto.class)
                .value(p -> {
                    assertThat(p.getId()).isNotNull();
                    assertThat(p.getNombre()).isEqualTo("Producto Test");
                    assertThat(p.getPrecio()).isEqualTo(99.99);
                });
    }

    @Test
    void testObtenerProductoPorId() {
        Producto productoGuardado = productoRepository.save(new Producto(null, "Producto Test", 99.99)).block();
        assertThat(productoGuardado).isNotNull(); // Asegura que se guardó correctamente
        
        webTestClient.get().uri("/api/productos/{id}", productoGuardado.getId())
                .exchange()
                .expectStatus().isOk()  // Asegura que la respuesta es 200 OK
                .expectBody(Producto.class)
                .value(p -> assertThat(p.getNombre()).isEqualTo("Producto Test"));
    }
    
    @Test
    void testEliminarProducto() {
        Producto productoGuardado = productoRepository.save(producto).block();

        webTestClient.delete().uri("/api/productos/{id}", productoGuardado.getId())
                .headers(headers -> headers.setBasicAuth("usuario", "clave123"))
                .exchange()
                .expectStatus().isNoContent();  // Asegura que la respuesta es 204

        webTestClient.get().uri("/api/productos/{id}", productoGuardado.getId())
                .headers(headers -> headers.setBasicAuth("usuario", "clave123"))
                .exchange()
                .expectStatus().isNotFound();  // Asegura que el producto no se encuentra (404)
    }
}
