package br.com.aquece.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.MesaServiceFacadeImpl;
import br.com.aquece.Vo.MesaVO;

public class MesaAction extends ActionSupport {

	private MesaServiceFacadeImpl mesaServiceFacade = new MesaServiceFacadeImpl();
	private MesaVO mesaVO = new MesaVO();
	private List<MesaVO> listaMesas = new ArrayList<MesaVO>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955863363270237394L;

	public String inserirMesa() {
		mesaServiceFacade.inserirMesa(mesaVO);
		return SUCCESS;
	}

	public String excluirMesa() {
		mesaServiceFacade.excluirMesa(mesaVO);
		return SUCCESS;
	}

	public String consultarSituacaoMesa() {
		listaMesas = mesaServiceFacade.consultarSituacaoMesa(0);
		return SUCCESS;
	}

	public MesaServiceFacadeImpl getMesaServiceFacade() {
		return mesaServiceFacade;
	}

	public void setMesaServiceFacade(MesaServiceFacadeImpl mesaServiceFacade) {
		this.mesaServiceFacade = mesaServiceFacade;
	}

	public MesaVO getMesaVO() {
		return mesaVO;
	}

	public void setMesaVO(MesaVO mesaVO) {
		this.mesaVO = mesaVO;
	}

	public List<MesaVO> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<MesaVO> listaMesas) {
		this.listaMesas = listaMesas;
	}

	
	
	
}
