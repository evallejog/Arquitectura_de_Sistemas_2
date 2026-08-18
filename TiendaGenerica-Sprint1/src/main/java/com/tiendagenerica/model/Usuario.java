package com.tiendagenerica.model;
import javax.persistence.*; import javax.validation.constraints.*;
@Entity @Table(name="usuarios") public class Usuario {
@Id @Column(nullable=false, unique=true, length=20) @NotBlank(message="Faltan datos del usuario") private String cedula;
@NotBlank(message="Faltan datos del usuario") @Column(name="nombre_completo") private String nombreCompleto;
@NotBlank(message="Faltan datos del usuario") @Email(message="Correo electrónico inválido") private String correo;
@NotBlank(message="Faltan datos del usuario") @Column(name="nombre_usuario", unique=true) private String usuario;
@NotBlank(message="Faltan datos del usuario") private String contrasena;
public String getCedula(){return cedula;} public void setCedula(String v){cedula=v;} public String getNombreCompleto(){return nombreCompleto;} public void setNombreCompleto(String v){nombreCompleto=v;} public String getCorreo(){return correo;} public void setCorreo(String v){correo=v;} public String getUsuario(){return usuario;} public void setUsuario(String v){usuario=v;} public String getContrasena(){return contrasena;} public void setContrasena(String v){contrasena=v;}
}