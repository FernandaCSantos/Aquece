package br.com.aquece.Dao;

import br.com.aquece.Vo.VendasVO;

/**
 * Interface facade de Vendas
 * @author Fernanda Santos
 *
 */
public interface VendasDao {
	
	/**
	 * Método para realizar o cadastro de vendas.
	 * @param venda
	 */
	public void inserirVendas(VendasVO venda);
	
	/**
	 * Método para realizar a exclusão de vendas.
	 * @param venda
	 */
	public void fecharVendas(VendasVO venda);
	/**
	 * Método para realizar a alteração de mesas.
	 * @param mesa
	 */
	public void alterarVendas(VendasVO venda);
	
	/**
	 * Método para consultar venda por codigo
	 * @param venda
	 * @return vendaVo
	 */
	public VendasVO consultarVendas(VendasVO venda);
	
	/**
	 *  Método para inserir venda no arquivo morto.
	 * @param venda
	 */
	public void inserirArquivoMortoVendas(VendasVO venda);

}
