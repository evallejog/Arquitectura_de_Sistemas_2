package com.tiendagenerica.repository;
import com.tiendagenerica.model.Usuario; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface UsuarioRepository extends JpaRepository<Usuario,String>{ Optional<Usuario> findByUsuarioAndContrasena(String usuario,String contrasena); boolean existsByUsuario(String usuario); }