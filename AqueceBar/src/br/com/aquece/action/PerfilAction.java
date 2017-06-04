package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.PerfilServiceFacade;
import br.com.aquece.Facade.PerfilServiceFacadeImpl;
import br.com.aquece.Vo.PerfilVO;

public class PerfilAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586094782415226414L;

	private PerfilVO perfilVO = new PerfilVO();
	private PerfilServiceFacadeImpl perfilServiceFacade = new PerfilServiceFacadeImpl();
	
	public String inserirPerfil(){
		perfilServiceFacade.inserirPerfil(perfilVO);
		return SUCCESS;
	}
	
	
	public String consultarPerfil(){
		perfilServiceFacade.consultarPerfil(perfilVO);
		return SUCCESS;
	}
	
	public String alterarPerfil(){
		perfilServiceFacade.alterarPerfil(perfilVO);
		return SUCCESS;
	}
	
	public String excluirPerfil(){
		perfilServiceFacade.excluirPerfil(perfilVO);
		return SUCCESS;
	}
	
	public String login(){
		perfilVO = perfilServiceFacade.login(perfilVO);

		return SUCCESS;
	}

	public String logout(){
		perfilServiceFacade.login(perfilVO);
		return SUCCESS;
	}


	public PerfilVO getPerfilVO() {
		return perfilVO;
	}


	public void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}


	public PerfilServiceFacadeImpl getPerfilServiceFacade() {
		return perfilServiceFacade;
	}


	public void setPerfilServiceFacade(PerfilServiceFacadeImpl perfilServiceFacade) {
		this.perfilServiceFacade = perfilServiceFacade;
	}

	
}
