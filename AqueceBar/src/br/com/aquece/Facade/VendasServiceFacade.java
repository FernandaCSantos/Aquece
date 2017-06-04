package br.com.aquece.Facade;

import java.util.List;

import br.com.aquece.Vo.VendasVO;

public interface VendasServiceFacade {

	/**
	 * M�todo para realizar o cadastro de vendas.
	 * @param venda
	 */
	public Integer inserirVendas(VendasVO venda, String status);
	
	/**
	 * M�todo para realizar a exclus�o de vendas.
	 * @param venda
	 */
	public void fecharVendas(VendasVO venda);
	/**
	 * M�todo para realizar a altera��o de mesas.
	 * @param mesa
	 */
	public void alterarVendas(VendasVO venda);
	
	/**
	 * M�todo para consultar venda por codigo
	 * @param venda
	 * @return vendaVo
	 */
	public VendasVO consultarVendas(VendasVO venda);
	
	/**
	 *  M�todo para inserir venda no arquivo morto.
	 * @param venda
	 */
	public void inserirArquivoMortoVendas(VendasVO venda);

	List<VendasVO> inicializarTelaVendas();

}
