package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.ProdutosServiceFacade;
import br.com.aquece.Facade.ProdutosServiceFacadeImpl;
import br.com.aquece.Vo.ProdutoVO;

public class ProdutosAction extends ActionSupport{

	/**  
	 * 
	 */
	private static final long serialVersionUID = -4267497289471576180L;

	private ProdutoVO produtoVO = new ProdutoVO();
	private ProdutosServiceFacadeImpl produtosServiceFacade = new ProdutosServiceFacadeImpl();

	public String inserirProduto(){
		produtosServiceFacade.inserirProduto(produtoVO);;
		return SUCCESS;
	}

	public String consultarProduto(){
		produtoVO = produtosServiceFacade.consultarProduto(produtoVO);
		return SUCCESS;
	}
	
	public String alterarProduto(){
		produtosServiceFacade.alterarProduto(produtoVO);
		return SUCCESS;
	}
	
	public String excluirProduto(){
		produtosServiceFacade.excluirProduto(produtoVO);
		return SUCCESS;
	}

	public ProdutoVO getProdutoVO() {
		return produtoVO;
	}

	public void setProdutoVO(ProdutoVO produtoVO) {
		this.produtoVO = produtoVO;
	}

	public ProdutosServiceFacadeImpl getProdutosServiceFacade() {
		return produtosServiceFacade;
	}

	public void setProdutosServiceFacade(ProdutosServiceFacadeImpl produtosServiceFacade) {
		this.produtosServiceFacade = produtosServiceFacade;
	}
	
	
}
