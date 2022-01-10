package com.nisum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Entidad para representar la tabla phone.
 * 
 * @author PABI1
 *
 */
@Data
@Table(name = "phone")
@Entity
@ApiModel(description = "Información del teléfono.")
public class Phone {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phone", insertable = false, updatable = false, nullable = false)
	private Long id;

	@ApiModelProperty(notes = "Número de teléfono.")
	@NotBlank(message = "Número no debe estar vacío")
	@Column(name = "number")
	private String number;

	@ApiModelProperty(notes = "Código de pais.")
	@NotBlank(message = "Código de pais no debe estar vacío")
	@Column(name = "city_code")
	private String citycode;

	@ApiModelProperty(notes = "Código de ciudad.")
	@NotBlank(message = "Código de ciudad no debe estar vacío ")
	@Column(name = "country_code")
	private String contrycode;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
}
