package br.com.aquece.Vo;

import java.io.Serializable;
import java.util.Calendar;

public class VendasVO implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6324861075373997834L;

	private MesaVO mesaVO;
	private ProdutoVO produtoVO;
	private PerfilVO perfilVO;
	private Double total;
	private Integer cod;
	private Calendar horaAbertura;
	private Calendar horaFechamento;
	private Double quantidade;
	
	public MesaVO getMesaVO() {
		return mesaVO;
	}
	public void setMesaVO(MesaVO mesaVO) {
		this.mesaVO = mesaVO;
	}
	public ProdutoVO getProdutoVO() {
		return produtoVO;
	}
	public void setProdutoVO(ProdutoVO produtoVO) {
		this.produtoVO = produtoVO;
	}
	public PerfilVO getPerfilVO() {
		return perfilVO;
	}
	public void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
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
	
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "VendasVO [mesaVO=" + mesaVO + ", produtoVO=" + produtoVO + ", perfilVO=" + perfilVO + ", total=" + total
				+ ", cod=" + cod + ", horaAbertura=" + horaAbertura + ", horaFechamento=" + horaFechamento + "]";
	}
	
	
}
