package com.example.EcoEco.controller;

import com.example.EcoEco.models.ProductoOriginal;
import com.example.EcoEco.service.ProductoOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productoOriginales")
public class ProductoOriginalController {

    @Autowired
    private ProductoOriginalService productoOriginalService;

    @GetMapping("/buscar/todos-los-productos")
    public ResponseEntity<List<ProductoOriginal>> getAllProductoOriginales() {
        List<ProductoOriginal> productoOriginales = productoOriginalService.getAllProductoOriginales();
        return new ResponseEntity<>(productoOriginales, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductoOriginal> getProductoOriginalById(@PathVariable Long id) {
        Optional<ProductoOriginal> productoOriginal = productoOriginalService.getProductoOriginalById(id);
        if (productoOriginal.isPresent()) {
            return new ResponseEntity<>(productoOriginal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<ProductoOriginal>> getProductoOriginalByNombre(@PathVariable String nombre) {
        List<ProductoOriginal> productosOriginales = productoOriginalService.getProductoOriginalByNombre(nombre);
        if (!productosOriginales.isEmpty()) {
            return new ResponseEntity<>(productosOriginales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/nuevo")
    public ResponseEntity<ProductoOriginal> createProductoOriginal(@RequestBody ProductoOriginal productoOriginal) {
        ProductoOriginal savedProductoOriginal = productoOriginalService.saveProductoOriginal(productoOriginal);
        return new ResponseEntity<>(savedProductoOriginal, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProductoOriginal> updateProductoOriginal(@PathVariable Long id, @RequestBody ProductoOriginal productoOriginalDetails) {
        Optional<ProductoOriginal> productoOriginalOptional = productoOriginalService.getProductoOriginalById(id);
        if (productoOriginalOptional.isPresent()) {
            ProductoOriginal productoOriginal = productoOriginalOptional.get();
            productoOriginal.setNombreProductoOriginal(productoOriginalDetails.getNombreProductoOriginal());
            productoOriginal.setImagenProductoOriginal(productoOriginalDetails.getImagenProductoOriginal());
            productoOriginal.setPrecioProductoOriginal(productoOriginalDetails.getPrecioProductoOriginal());
            productoOriginal.setDurabilidadProductoOriginal(productoOriginalDetails.getDurabilidadProductoOriginal());
            productoOriginal.setDescripcionProductoOriginal(productoOriginalDetails.getDescripcionProductoOriginal());
            productoOriginal.setCategoria(productoOriginalDetails.getCategoria());
            // No actualizamos la fecha de creación ni la lista de productos alternativos
            ProductoOriginal updatedProductoOriginal = productoOriginalService.saveProductoOriginal(productoOriginal);
            return new ResponseEntity<>(updatedProductoOriginal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> deleteProductoOriginal(@PathVariable Long id) {
        productoOriginalService.deleteProductoOriginal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
