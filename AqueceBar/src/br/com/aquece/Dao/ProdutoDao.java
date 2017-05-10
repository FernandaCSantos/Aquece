package br.com.aquece.Dao;

import br.com.aquece.Vo.ProdutoVO;
/**
 * Interface Dao do Produto
 * @author Fernanda Santos
 *
 */
public interface ProdutoDao {
	
	/**
	 * M�todo respons�vel pela inser��o de produto
	 * @param produto
	 */
	public void inserirProduto(ProdutoVO produto);

	/**
	 * M�todo para consultar produtos
	 * @param produto
	 * @return produtoVO
	 */
	public ProdutoVO consultarProduto(ProdutoVO produto);
	
	/**
	 * M�todo para alterar produto
	 * @param produto
	 */
	public void alterarProduto(ProdutoVO produto);
	
	/**
	 * M�todo para inserir os dados de exclus�o no arquivo morto
	 * @param produto
	 */
	public void inserirArquivoMortoProduto(ProdutoVO produto);
	
	/**
	 * M�todo para excluir produto
	 * @param produto
	 */
	public void excluirProduto(ProdutoVO produto);


}
