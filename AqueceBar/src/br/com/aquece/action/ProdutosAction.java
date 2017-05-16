package br.com.aquece.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.aquece.Facade.ProdutosServiceFacade;
import br.com.aquece.Vo.ProdutoVO;

public class ProdutosAction extends ActionSupport{

	/**  
	 * 
	 */
	private static final long serialVersionUID = -4267497289471576180L;

	private ProdutoVO produto;
	private ProdutosServiceFacade produtosServiceFacade;

	public String inserirProduto(){
		produtosServiceFacade.inserirProduto(produto);;
		return SUCCESS;
	}

	public String consultarProduto(){
		produtosServiceFacade.consultarProduto(produto);
		return SUCCESS;
	}
	
	public String alterarProduto(){
		produtosServiceFacade.alterarProduto(produto);
		return SUCCESS;
	}
	
	public String excluirProduto(){
		produtosServiceFacade.excluirProduto(produto);
		return SUCCESS;
	}
}
