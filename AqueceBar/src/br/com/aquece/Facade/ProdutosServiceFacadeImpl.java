package br.com.aquece.Facade;


import br.com.aquece.Dao.ProdutoDaoImpl;
import br.com.aquece.Vo.ProdutoVO;


public class ProdutosServiceFacadeImpl implements ProdutosServiceFacade {

	private ProdutoDaoImpl produtoDao = new ProdutoDaoImpl();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirProduto(ProdutoVO produto) {
		produtoDao.inserirProduto(produto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProdutoVO consultarProduto(ProdutoVO produto) { 
		return produtoDao.consultarProduto(produto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void alterarProduto(ProdutoVO produto) {
		produtoDao.alterarProduto(produto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoProduto(ProdutoVO produto) {
		produtoDao.inserirArquivoMortoProduto(produto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirProduto(ProdutoVO produto) {
		produtoDao.excluirProduto(produto);
	}

	public ProdutoDaoImpl getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDaoImpl produtoDao) {
		this.produtoDao = produtoDao;
	}

	
}
