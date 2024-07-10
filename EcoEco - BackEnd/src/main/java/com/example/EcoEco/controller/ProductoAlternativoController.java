package com.example.EcoEco.controller;

import com.example.EcoEco.models.ProductoAlternativo;
import com.example.EcoEco.service.ProductoAlternativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productoAlternativos")
@CrossOrigin("*")
public class ProductoAlternativoController {

    @Autowired
    private ProductoAlternativoService productoAlternativoService;

    @GetMapping("/buscar/todos-los-productos-alternativos")
    public ResponseEntity<List<ProductoAlternativo>> getAllProductoAlternativos() {
        List<ProductoAlternativo> productoAlternativos = productoAlternativoService.getAllProductoAlternativos();
        return new ResponseEntity<>(productoAlternativos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductoAlternativo> getProductoAlternativoById(@PathVariable Long id) {
        Optional<ProductoAlternativo> productoAlternativo = productoAlternativoService.getProductoAlternativoById(id);
        if (productoAlternativo.isPresent()) {
            return new ResponseEntity<>(productoAlternativo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<ProductoAlternativo>> getProductoAlternativoByNombre(@PathVariable String nombre) {
        List<ProductoAlternativo> productoAlternativos = productoAlternativoService.getProductoAlternativoByNombre(nombre);
        if (!productoAlternativos.isEmpty()) {
            return new ResponseEntity<>(productoAlternativos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProductoAlternativo> createProductoAlternativo(@RequestBody ProductoAlternativo productoAlternativo) {
        ProductoAlternativo savedProductoAlternativo = productoAlternativoService.saveProductoAlternativo(productoAlternativo);
        return new ResponseEntity<>(savedProductoAlternativo, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProductoAlternativo> updateProductoAlternativo(@PathVariable Long id, @RequestBody ProductoAlternativo productoAlternativoDetails) {
        Optional<ProductoAlternativo> productoAlternativoOptional = productoAlternativoService.getProductoAlternativoById(id);
        if (productoAlternativoOptional.isPresent()) {
            ProductoAlternativo productoAlternativo = productoAlternativoOptional.get();
            productoAlternativo.setNombreProductoAlternativo(productoAlternativoDetails.getNombreProductoAlternativo());
            productoAlternativo.setDurabilidadProductoAlternativo(productoAlternativoDetails.getDurabilidadProductoAlternativo());
            productoAlternativo.setDescripcionProductoAlternativo(productoAlternativoDetails.getDescripcionProductoAlternativo());
            productoAlternativo.setPrecioProductoProductoAlternativo(productoAlternativoDetails.getPrecioProductoProductoAlternativo());
            productoAlternativo.setProductoOriginal(productoAlternativoDetails.getProductoOriginal());
            // No actualizamos la fecha de creación
            ProductoAlternativo updatedProductoAlternativo = productoAlternativoService.saveProductoAlternativo(productoAlternativo);
            return new ResponseEntity<>(updatedProductoAlternativo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> deleteProductoAlternativo(@PathVariable Long id) {
        productoAlternativoService.deleteProductoAlternativo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
