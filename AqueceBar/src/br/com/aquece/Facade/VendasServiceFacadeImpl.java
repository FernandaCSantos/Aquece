package br.com.aquece.Facade;

import java.util.List;

import br.com.aquece.Dao.VendasDaoImpl;
import br.com.aquece.Vo.VendasVO;

public class VendasServiceFacadeImpl implements VendasServiceFacade {

	private VendasDaoImpl vendasDao = new VendasDaoImpl();

	/**
	 * {@inheritDoc}
	 * @param status 
	 */
	@Override
	public Integer inserirVendas(VendasVO venda, String status) {
		Integer retorno = null;
		try{
			retorno = vendasDao.inserirVendas(venda,status);
			
		}catch (Exception e) {
			e.getMessage();		
		}
		
		return retorno;
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
	@Override
	public List<VendasVO> inicializarTelaVendas(){
		return vendasDao.inicializarTelaVendas();
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

	public VendasDaoImpl getVendasDao() {
		return vendasDao;
	}

	public void setVendasDao(VendasDaoImpl vendasDao) {
		this.vendasDao = vendasDao;
	}

	
}
