package com.example.EcoEco.service;



import com.example.EcoEco.models.ProductoAlternativo;
import com.example.EcoEco.repository.ProductoAlternativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoAlternativoService {

    @Autowired
    private ProductoAlternativoRepository productoAlternativoRepository;

    public List<ProductoAlternativo> getProductoAlternativoByNombre(String nombre) {
        return productoAlternativoRepository.findByNombre(nombre);
    }

    public List<ProductoAlternativo> getAllProductoAlternativos() {
        return productoAlternativoRepository.findAll();
    }

    public Optional<ProductoAlternativo> getProductoAlternativoById(Long id) {
        return productoAlternativoRepository.findById(id);
    }

    public ProductoAlternativo saveProductoAlternativo(ProductoAlternativo productoAlternativo) {
        return productoAlternativoRepository.save(productoAlternativo);
    }

    public void deleteProductoAlternativo(Long id) {
        productoAlternativoRepository.deleteById(id);
    }
}
