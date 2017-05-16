package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.PerfilServiceFacade;
import br.com.aquece.Vo.PerfilVO;

public class PerfilAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586094782415226414L;

	private PerfilVO perfil;
	private PerfilServiceFacade perfilServiceFacade;
	
	public String inserirPerfil(){
		perfilServiceFacade.inserirPerfil(perfil);
		return SUCCESS;
	}
	
	
	public String consultarPerfil(){
		perfilServiceFacade.consultarPerfil(perfil);
		return SUCCESS;
	}
	
	public String alterarPerfil(){
		perfilServiceFacade.alterarPerfil(perfil);
		return SUCCESS;
	}
	
	public String excluirPerfil(){
		perfilServiceFacade.excluirPerfil(perfil);
		return SUCCESS;
	}

}
