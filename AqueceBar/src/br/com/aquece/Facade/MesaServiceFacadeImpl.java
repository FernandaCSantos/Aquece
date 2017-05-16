package br.com.aquece.Facade;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.aquece.Dao.MesaDao;
import br.com.aquece.Vo.MesaVO;

public class MesaServiceFacadeImpl implements MesaServiceFacade {
	@Autowired
	private MesaDao mesaDao;
	
	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public void inserirMesa(MesaVO mesa) {
		try{
			mesaDao.inserirMesa(mesa);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public void excluirMesa(MesaVO mesa) {
		try{
			mesaDao.excluirMesa(mesa);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public MesaVO consultarMesa(MesaVO mesa) {
		return mesaDao.consultarMesa(mesa);
	}

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public void inserirArquivoMortoMesa(MesaVO mesa) {
		try{
			mesaDao.inserirArquivoMortoMesa(mesa);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	
}
