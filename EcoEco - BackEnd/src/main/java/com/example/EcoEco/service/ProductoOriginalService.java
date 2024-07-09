package com.example.EcoEco.service;

import com.example.EcoEco.models.ProductoOriginal;
import com.example.EcoEco.repository.ProductoOriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoOriginalService {

    @Autowired
    private ProductoOriginalRepository productoOriginalRepository;

    public List<ProductoOriginal> getProductoOriginalByNombre(String nombre) {
        return productoOriginalRepository.findByNombre(nombre);
    }

    public List<ProductoOriginal> getAllProductoOriginales() {
        return productoOriginalRepository.findAll();
    }

    public Optional<ProductoOriginal> getProductoOriginalById(Long id) {
        return productoOriginalRepository.findById(id);
    }

    public ProductoOriginal saveProductoOriginal(ProductoOriginal productoOriginal) {
        return productoOriginalRepository.save(productoOriginal);
    }

    public void deleteProductoOriginal(Long id) {
        productoOriginalRepository.deleteById(id);
    }
}
