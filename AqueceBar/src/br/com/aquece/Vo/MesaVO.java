package br.com.aquece.Vo;

import java.io.Serializable;

public class MesaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroMesa;
	private Integer situacao;
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	public Integer getSituacao() {
		return situacao;
	}
	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
		return "MesaVO [numeroMesa=" + numeroMesa + ", situacao=" + situacao + "]";
	}

	
	
	
	
	
}
