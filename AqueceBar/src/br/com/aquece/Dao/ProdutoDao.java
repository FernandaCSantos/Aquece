package br.com.aquece.Dao;

import br.com.aquece.Vo.ProdutoVO;
/**
 * Interface Dao do Produto
 * @author Fernanda Santos
 *
 */
public interface ProdutoDao {
	
	/**
	 * Método responsável pela inserção de produto
	 * @param produto
	 */
	public void inserirProduto(ProdutoVO produto);

	/**
	 * Método para consultar produtos
	 * @param produto
	 * @return produtoVO
	 */
	public ProdutoVO consultarProduto(ProdutoVO produto);
	
	/**
	 * Método para alterar produto
	 * @param produto
	 */
	public void alterarProduto(ProdutoVO produto);
	
	/**
	 * Método para inserir os dados de exclusão no arquivo morto
	 * @param produto
	 */
	public void inserirArquivoMortoProduto(ProdutoVO produto);
	
	/**
	 * Método para excluir produto
	 * @param produto
	 */
	public void excluirProduto(ProdutoVO produto);


}
