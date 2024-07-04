package com.example.EcoEco.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin")

    private long idAdmin;
    @Column(name="admin_nombre")
    private String nombreAdmin;

    @Column(name="admin_correo")
    private String correoAdmin;

    @Column(name="admin_password")
    private String passwordAdmin;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaCreacion;


}
