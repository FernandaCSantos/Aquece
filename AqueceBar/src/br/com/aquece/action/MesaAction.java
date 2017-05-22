package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.MesaServiceFacade;
import br.com.aquece.Vo.MesaVO;

public class MesaAction extends ActionSupport {

	private MesaServiceFacade mesaServiceFacade;
	private MesaVO mesa;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955863363270237394L;

	public String inserirMesa() {
		mesaServiceFacade.inserirMesa(mesa);
		return SUCCESS;
	}

	public String excluirMesa() {
		mesaServiceFacade.excluirMesa(mesa);
		return SUCCESS;
	}

}
