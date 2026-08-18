package com.tiendagenerica.config;
import com.tiendagenerica.model.Usuario; import com.tiendagenerica.repository.UsuarioRepository; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*;
@Configuration public class DataInitializer {
@Bean CommandLineRunner init(UsuarioRepository r){return args->{if(!r.existsById("0")){Usuario u=new Usuario();u.setCedula("0");u.setNombreCompleto("Administrador Inicial");u.setCorreo("admin@tienda.local");u.setUsuario("admininicial");u.setContrasena("admin123456");r.save(u);}};}
}