package com.lukaspkrr.backcursospring.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class StandardError implements Serializable {
	static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timestamp;

}
