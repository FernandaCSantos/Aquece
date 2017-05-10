package br.com.aquece.Vo;

import java.io.Serializable;
import java.util.Calendar;

public class MesaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroMesa;
	private Calendar horaAbertura;
	private Calendar horaFechamento;
	private ProdutoVO produtoVO;
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public Calendar getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(Calendar horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	public Calendar getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento(Calendar horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
	public ProdutoVO getProdutoVO() {
		return produtoVO;
	}
	public void setProdutoVO(ProdutoVO produtoVO) {
		this.produtoVO = produtoVO;
	}
	
	@Override
	public String toString() {
		return "MesaVO [numeroMesa=" + numeroMesa + ", horaAbertura=" + horaAbertura + ", horaFechamento="
				+ horaFechamento + ", produtoVO=" + produtoVO + "]";
	}
	
	
	
}
