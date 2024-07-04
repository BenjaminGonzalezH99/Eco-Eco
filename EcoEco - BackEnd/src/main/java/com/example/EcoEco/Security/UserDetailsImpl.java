package com.example.EcoEco.Security;

import com.example.EcoEco.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String usuario;

    private String correo;

    private String contrasena;

    //crear autoridades que se extienden del bisabuelo con grantedAuthorities
    private Collection<? extends GrantedAuthority> authorities;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    //con Builder construyo usuarios para autenticar
    public static  UserDetailsImpl build(UsuarioDTO usuarioDTO) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuarioDTO.getNombreUsuario()));

        return new UserDetailsImpl(
                usuarioDTO.getNombreUsuario(),
                usuarioDTO.getCorreoUsuario(),
                usuarioDTO.getContrasenaUsuario(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getUsuario() {
        return usuario;
    }
    @Override
    public String getCorreo() {
        return correo;
    }
    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
