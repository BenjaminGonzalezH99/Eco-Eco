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

    @Column(name = "nombre_PO")
    private String nombreProductoOriginal;

    @Column(name = "precio_PO")
    private Integer precioProductoOriginal;

    @Column(name = "durabilidad_PO")
    private Double durabilidadProductoOriginal;

    @Column(name = "descripción_PO")
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
