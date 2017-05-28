package br.com.aquece.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.MesaServiceFacadeImpl;
import br.com.aquece.Vo.MesaVO;
import br.com.aquece.Vo.VendasVO;

public class InicioAction extends ActionSupport{
	
	private MesaServiceFacadeImpl mesaServiceFacadeImpl = new MesaServiceFacadeImpl();
	private List<MesaVO> listaMesas = new ArrayList<MesaVO>();
	private List<MesaVO> listaMesasVazias = new ArrayList<MesaVO>();
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
//		listaMesas = mesaServiceFacadeImpl.consultarSituacaoMesa(0);
//		listaMesasVazias = mesaServiceFacadeImpl.consultarSituacaoMesa(1);
		return SUCCESS;
	}

	public MesaServiceFacadeImpl getMesaServiceFacadeImpl() {
		return mesaServiceFacadeImpl;
	}

	public void setMesaServiceFacadeImpl(MesaServiceFacadeImpl mesaServiceFacadeImpl) {
		this.mesaServiceFacadeImpl = mesaServiceFacadeImpl;
	}

	public List<MesaVO> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<MesaVO> listaMesas) {
		this.listaMesas = listaMesas;
	}

	public List<MesaVO> getListaMesasVazias() {
		return listaMesasVazias;
	}

	public void setListaMesasVazias(List<MesaVO> listaMesasVazias) {
		this.listaMesasVazias = listaMesasVazias;
	}
	
	
	
}
