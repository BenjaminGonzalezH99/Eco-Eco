package com.example.EcoEco.repository;




import com.example.EcoEco.models.ProductoAlternativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoAlternativoRepository extends JpaRepository<ProductoAlternativo, Long> {
    // Métodos de consulta personalizados si es necesario

    @Query("SELECT pa FROM ProductoAlternativo pa WHERE pa.nombreProductoAlternativo LIKE %:nombre%")
    List<ProductoAlternativo> findByNombre(@Param("nombre") String nombre);
}
