package com.example.EcoEco.repository;

import com.example.EcoEco.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByNombreAdmin(String nombre);
    Admin findAdminByCorreoAdmin(String correo);
}
