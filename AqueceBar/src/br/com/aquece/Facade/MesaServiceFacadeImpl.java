package br.com.aquece.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.aquece.Dao.MesaDaoImpl;
import br.com.aquece.Vo.MesaVO;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MesaServiceFacadeImpl implements MesaServiceFacade {
	private MesaDaoImpl mesaDao = new MesaDaoImpl();
	private List<MesaVO> lista = new ArrayList<MesaVO>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirMesa(MesaVO mesa) {
		try {
			mesaDao.inserirMesa(mesa);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirMesa(MesaVO mesa) {
		try {
			mesaDao.excluirMesa(mesa);
		} catch (Exception e) {
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
		try {
			mesaDao.inserirArquivoMortoMesa(mesa);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<MesaVO> consultarSituacaoMesa(int flag) {
		return mesaDao.consultarSituacaoMesa();
	}

	public MesaDaoImpl getMesaDao() {
		return mesaDao;
	}

	public void setMesaDao(MesaDaoImpl mesaDao) {
		this.mesaDao = mesaDao;
	}

	public List<MesaVO> getLista() {
		return lista;
	}

	public void setLista(List<MesaVO> lista) {
		this.lista = lista;
	}

}
