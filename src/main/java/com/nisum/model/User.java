package com.nisum.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Entidad que representa la tabla user.
 * 
 * @author PABI1
 *
 */
@Data
@Table(name = "user")
@Entity
@ApiModel(description = "Información del usuario.")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user", insertable = false, updatable = false, nullable = false)
	private UUID id;

	@ApiModelProperty(notes = "Nombre debe tener entre 2 y 100 caracteres")
	@NotBlank(message = "Name may not be empty")
	@Size(min = 2, max = 100, message = "Nombre debe tener entre 2 y 100 caracteres")
	@Column(name = "name")
	private String name;

	@ApiModelProperty(notes = "Email de usuario.")
	@NotBlank(message = "Email no puede estar vacio")
	@Column(name = "email")
	@Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String email;

	@ApiModelProperty(notes = "Password")
	@NotBlank(message = "Passwor de usuario.")
	@Column(name = "password")
	private String password;

	@ApiModelProperty(notes = "Fecha de creación.")
	@Column(name = "created")
	private LocalDateTime created;

	@ApiModelProperty(notes = "Fecha de modificación.")
	@Column(name = "modified")
	private LocalDateTime modified;

	@ApiModelProperty(notes = "Fecha último login")
	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@ApiModelProperty(notes = "Token acceso.")
	@Column(name = "token")
	private String token;

	@ApiModelProperty(notes = "Indica si el usuario sigue habilitado dentro del sistema.")
	@Column(name = "isactive")
	private boolean isactive;

	@ApiModelProperty(notes = "Listado de teléfonos.")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Phone> phones;

	@PrePersist
	public void insertDateCreate() {
		created = LocalDateTime.now();
		lastLogin = created;
	}
}
