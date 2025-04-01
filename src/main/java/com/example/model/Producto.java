package com.example.productos.model; 
import lombok.AllArgsConstructor; 
import lombok.Builder; 
import lombok.Data; 
import lombok.NoArgsConstructor; 
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
@Document(collection = "productos") // Nombre de la colección en MongoDB 
@Data // Lombok: genera getters, setters, toString, equals y hashCode 
@NoArgsConstructor // Lombok: constructor vacío 
@AllArgsConstructor // Lombok: constructor con todos los campos 
@Builder // Lombok: patrón builder 
public class Producto { 
@Id 
private String id; 
private String nombre; 
private double precio; 
} 