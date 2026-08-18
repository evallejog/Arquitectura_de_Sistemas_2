package com.tiendagenerica.service;
import com.tiendagenerica.model.Usuario; import com.tiendagenerica.repository.UsuarioRepository; import org.springframework.stereotype.Service; import java.util.*;
@Service public class UsuarioService {
private final UsuarioRepository repo; public UsuarioService(UsuarioRepository r){repo=r;}
public Optional<Usuario> autenticar(String u,String c){return repo.findByUsuarioAndContrasena(u,c);}
public Usuario crear(Usuario u){ if(repo.existsById(u.getCedula())||repo.existsByUsuario(u.getUsuario())) throw new IllegalArgumentException("La cédula o usuario ya existe"); return repo.save(u);}
public Optional<Usuario> buscar(String cedula){return repo.findById(cedula);}
public Usuario actualizar(Usuario u){if(!repo.existsById(u.getCedula())) throw new NoSuchElementException("Usuario Inexistente"); return repo.save(u);}
public void borrar(String cedula){if(cedula==null||cedula.isBlank()) throw new IllegalArgumentException("Cédula Errada"); if(!repo.existsById(cedula)) throw new NoSuchElementException("Usuario Inexistente"); repo.deleteById(cedula);}
}