package com.example.EcoEco.repository;


import com.example.EcoEco.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Métodos de consulta personalizados si es necesario
    @Query("SELECT c FROM Categoria c WHERE c.nombreCategoria LIKE %:nombre%")
    List<Categoria> findByNombre(@Param("nombre") String nombre);

}