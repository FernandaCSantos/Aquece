package br.com.aquece.Facade;


import br.com.aquece.Dao.PerfilDaoImpl;
import br.com.aquece.Vo.PerfilVO;

public class PerfilServiceFacadeImpl implements PerfilServiceFacade {

    private PerfilDaoImpl perfilDao = new PerfilDaoImpl();
	
    /**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirPerfil(PerfilVO perfil) {
		perfilDao.inserirPerfil(perfil);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PerfilVO consultarPerfil(PerfilVO perfil) { 
		return perfilDao.consultarPerfil(perfil);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void alterarPerfil(PerfilVO perfil) {
		perfilDao.alterarPerfil(perfil);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoPerfil(PerfilVO perfil) {
		perfilDao.inserirArquivoMortoPerfil(perfil);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirPerfil(PerfilVO perfil) {
		perfilDao.excluirPerfil(perfil);
	}
	
	@Override
	public PerfilVO login(PerfilVO perfil){
		return perfilDao.login(perfil);
	}


	public PerfilDaoImpl getPerfilDao() {
		return perfilDao;
	}

	public void setPerfilDao(PerfilDaoImpl perfilDao) {
		this.perfilDao = perfilDao;
	}
	
	

	
}
