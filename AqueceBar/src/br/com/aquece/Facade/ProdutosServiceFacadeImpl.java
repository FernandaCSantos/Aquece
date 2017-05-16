package br.com.aquece.Facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.aquece.Dao.ProdutoDao;
import br.com.aquece.Vo.ProdutoVO;


@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProdutosServiceFacadeImpl implements ProdutosServiceFacade {

	@Autowired
	private ProdutoDao produtoDao;
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

}
