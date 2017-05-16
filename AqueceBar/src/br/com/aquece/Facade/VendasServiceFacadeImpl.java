package br.com.aquece.Facade;

import br.com.aquece.Dao.VendasDao;
import br.com.aquece.Vo.VendasVO;

public class VendasServiceFacadeImpl implements VendasServiceFacade {

	private VendasDao vendasDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirVendas(VendasVO venda) {
		try{
			vendasDao.inserirVendas(venda);
		}catch (Exception e) {
			e.getMessage();		
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fecharVendas(VendasVO venda) {
		try{
			vendasDao.fecharVendas(venda);
		}catch (Exception e) {
			e.getMessage();
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void alterarVendas(VendasVO venda) {
		try{
			vendasDao.alterarVendas(venda);
		}catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public VendasVO consultarVendas(VendasVO venda) {
		return vendasDao.consultarVendas(venda);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoVendas(VendasVO venda) {
		try{
			vendasDao.inserirArquivoMortoVendas(venda);
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
