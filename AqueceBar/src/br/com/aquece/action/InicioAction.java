package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Vo.VendasVO;

public class InicioAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8084102015405765773L;
	
	private VendasVO vendasVO;

	public VendasVO getVendasVO() {
		return vendasVO;
	}

	public void setVendasVO(VendasVO vendasVO) {
		this.vendasVO = vendasVO;
	}
	
	
	public String inicio(){
		return SUCCESS;
	}
	
}
