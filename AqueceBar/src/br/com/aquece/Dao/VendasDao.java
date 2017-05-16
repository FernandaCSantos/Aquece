package br.com.aquece.Dao;

import br.com.aquece.Vo.VendasVO;

/**
 * Interface facade de Vendas
 * @author Fernanda Santos
 *
 */
public interface VendasDao {
	
	/**
	 * M�todo para realizar o cadastro de vendas.
	 * @param venda
	 */
	public void inserirVendas(VendasVO venda);
	
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

}
