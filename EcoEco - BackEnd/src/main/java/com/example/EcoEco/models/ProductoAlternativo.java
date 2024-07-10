package com.example.EcoEco.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Data
public class ProductoAlternativo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idProductoAlternativo;

    @Column(name = "nombre_pa")
    private String nombreProductoAlternativo;

    @Column(name = "imagen_pa")
    private String imagenProductoAlternativo;

    @Column(name = "durabilidad_pa")
    private int durabilidadProductoAlternativo;

    @Column(name = "descripcion_pa")
    private String descripcionProductoAlternativo;

    @Column(name = "precio_pa")
    private Double precioProductoAlternativo;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name= "prod_original_id")
    private ProductoOriginal productoOriginal;

}
