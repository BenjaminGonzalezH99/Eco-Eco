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

    @Column(name = "nombre_PA")
    private String nombreProductoAlternativo;


    @Column(name = "durabilidad_PA")
    private int durabilidadProductoAlternativo;

    @Column(name = "descripción_PA")
    private String descripcionProductoAlternativo;

    @Column(name = "precio_PA")
    private Double precioProductoProductoAlternativo;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

   @JsonIgnore
    @ManyToOne()
    @JoinColumn(name= "Prod_original_id")
    private ProductoOriginal productoOriginal;

}
