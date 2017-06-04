package br.com.aquece.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.VendasServiceFacadeImpl;
import br.com.aquece.Vo.VendasVO;

public class VendasAction extends ActionSupport{

	private VendasVO vendas;
	private String status;
	private VendasServiceFacadeImpl vendasServiceFacade = new VendasServiceFacadeImpl();
	private List<VendasVO> lst = new ArrayList<VendasVO>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2874228230601816056L;

	public String inicializarTelaVendas(){
		lst = vendasServiceFacade.inicializarTelaVendas();
		return SUCCESS;
	}
	public String inserirVendas(){
		vendasServiceFacade.inserirVendas(vendas,status);
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

	public VendasServiceFacadeImpl getVendasServiceFacade() {
		return vendasServiceFacade;
	}

	public void setVendasServiceFacade(VendasServiceFacadeImpl vendasServiceFacade) {
		this.vendasServiceFacade = vendasServiceFacade;
	}

	public VendasVO getVendas() {
		return vendas;
	}

	public void setVendas(VendasVO vendas) {
		this.vendas = vendas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public List<VendasVO> getLst() {
		return lst;
	}
	public void setLst(List<VendasVO> lst) {
		this.lst = lst;
	}
	
	
}
