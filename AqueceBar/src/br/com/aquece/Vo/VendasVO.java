package br.com.aquece.Vo;

import java.io.Serializable;

public class VendasVO implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6324861075373997834L;

	private MesaVO mesaVO;
	private ProdutoVO produtoVO;
	private PerfilVO perfilVO;
	
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
	@Override
	public String toString() {
		return "VendasVO [mesaVO=" + mesaVO + ", produtoVO=" + produtoVO + ", perfilVO=" + perfilVO + "]";
	}
	
	

}
