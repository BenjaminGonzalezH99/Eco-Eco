package com.example.EcoEco.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "producto_original")
@NoArgsConstructor
@Data
public class ProductoOriginal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProductoOriginal;

    @Column(name = "nombre_po")
    private String nombreProductoOriginal;

    @Column(name = "imagen_po")
    private String imagenProductoOriginal;

    @Column(name = "precio_po")
    private Integer precioProductoOriginal;

    @Column(name = "durabilidad_po")
    private Double durabilidadProductoOriginal;

    @Column(name = "descripcion_po")
    private String descripcionProductoOriginal;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "productoOriginal")
    private List<ProductoAlternativo> alternativosProducto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
