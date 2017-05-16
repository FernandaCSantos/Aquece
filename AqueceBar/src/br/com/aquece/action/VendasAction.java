package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.VendasServiceFacade;
import br.com.aquece.Vo.VendasVO;

public class VendasAction extends ActionSupport{

	private VendasVO vendas;
	private VendasServiceFacade vendasServiceFacade;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2874228230601816056L;

	public String inserirVendas(){
		vendasServiceFacade.inserirVendas(vendas);
		return SUCCESS;
	}
	
	public String fecharVendas(){
		vendasServiceFacade.fecharVendas(vendas);
		return SUCCESS;
	}
	
	public String alterarVendas(){
		vendasServiceFacade.alterarVendas(vendas);
		return SUCCESS;
	}

	public String consultarVendas(){
		vendasServiceFacade.consultarVendas(vendas);
		return SUCCESS;
	}
	
}
