package com.example.EcoEco.repository;


import com.example.EcoEco.models.ProductoOriginal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoOriginalRepository extends JpaRepository<ProductoOriginal, Long> {
    // Métodos de consulta personalizados si es necesario
        @Query("SELECT po FROM ProductoOriginal po WHERE po.nombreProductoOriginal LIKE %:nombre%")
        List<ProductoOriginal> findByNombre(@Param("nombre") String nombre);
    }


