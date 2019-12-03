package br.com.project.amazonia.enums;

import java.io.Serializable;

public interface IEnum<T> extends Serializable {

	public String getDescricao();
	public T getCodigo();
}