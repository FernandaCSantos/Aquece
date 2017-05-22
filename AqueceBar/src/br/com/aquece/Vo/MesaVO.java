package br.com.aquece.Vo;

import java.io.Serializable;
import java.util.Calendar;

public class MesaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroMesa;
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	@Override
	public String toString() {
		return "MesaVO [numeroMesa=" + numeroMesa + "]";
	}

	
	
	
	
}
