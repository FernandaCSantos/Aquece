package br.com.aquece.Facade;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.aquece.Dao.PerfilDao;
import br.com.aquece.Vo.PerfilVO;

public class PerfilServiceFacadeImpl implements PerfilServiceFacade {

	@Autowired
    private PerfilDao perfilDao;
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

}
