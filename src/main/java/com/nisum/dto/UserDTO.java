package com.nisum.dto;

import java.util.List;

import com.nisum.model.Phone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Información del usuario.")
public class UserDTO {

	@ApiModelProperty(notes = "Nombre debe tener entre 2 y 100 caracteres.")
	private String name;

	@ApiModelProperty(notes = "Email de usuario.")
	private String email;

	@ApiModelProperty(notes = "Password de usuario.")
	private String password;

	@ApiModelProperty(notes = "Telélefono de usuario.")
	private List<Phone> phones;
}
