package com.tiendagenerica.controller;
import com.tiendagenerica.service.UsuarioService; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.*; import javax.servlet.http.*;
@Controller public class AuthController { private final UsuarioService s; public AuthController(UsuarioService x){s=x;}
@GetMapping({"/","/login"}) public String login(){return "login";}
@PostMapping("/login") public String ingresar(@RequestParam String usuario,@RequestParam String contrasena,HttpSession sesion){
return s.autenticar(usuario,contrasena).map(u->{sesion.setAttribute("usuarioActivo",u.getUsuario());return "redirect:/usuarios";}).orElse("redirect:/login?error");
}
@GetMapping("/logout") public String salir(HttpSession s){s.invalidate();return "redirect:/login?logout";}
}