package br.com.aquece.Dao;

import java.sql.ResultSet;

import br.com.aquece.Vo.ProdutoVO;

public class ProdutoDaoImpl extends Conexao implements ProdutoDao{

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public void inserirProduto(ProdutoVO produto) {
		try	{
			open();
			 stmt = con.prepareStatement("INSERT INTO PRODUTO VALUES (?,?,?,?)");
			 setDadosProduto(produto);
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProdutoVO consultarProduto(ProdutoVO produto) {
		ProdutoVO resp = null;

		try	{
			open();
			 stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE CODPRODUTO = ?");
			 stmt.setInt(1, produto.getCod());
			 rs=stmt.executeQuery();
			resp = getProduto(rs);
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");		
		
		}		
		
		return resp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void alterarProduto(ProdutoVO produto) {
		try	{
			open();
			 stmt = con.prepareStatement("UPDATE PRODUTO SET DESCRICAO = ?, PRECO = ? , QUANTIDADE = ? WHERE CODPRODUTO = ?");
			 stmt.setString(1, produto.getDesc());
			 stmt.setDouble(2, produto.getPreco());
			 stmt.setInt(3, produto.getQuantidade());
			 stmt.setInt(4, produto.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");	
		}				
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirProduto(ProdutoVO produto) {
		try	{
			ProdutoVO produtovo = new ProdutoVO();
			produtovo = consultarProduto(produto);
			inserirArquivoMortoProduto(produtovo);
			
			open();
			 stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE CODPRODUTO = ?");
			 stmt.setInt(1, produto.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");	
			
		}				
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoProduto(ProdutoVO produto) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("INSERT INTO PRODUTO VALUES (?,?,?,?)");
			 setDadosProduto(produto);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno.");	
			
		}				
	}
	
	/**
	 * Classe para inserir os dados do produto;
	 * @param produto
	 */
	public void setDadosProduto(ProdutoVO produto){
		try{
			stmt.setInt(1, produto.getCod());
			stmt.setString(2, produto.getDesc());
			try{
				stmt.setDouble(3, produto.getPreco());
			}catch (Exception e) {
				stmt.setDouble(3, 0.0);
			}
			try{
				stmt.setInt(4,produto.getQuantidade());
			}catch (Exception e) {
				stmt.setInt(4, 0);
			}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");
			
		}
	}
	
	/**
	 * Classe para resgatar os dados do produto;
	 * @param produto
	 */
	public ProdutoVO getProduto(ResultSet rs){
		ProdutoVO retorno = new ProdutoVO();
		try{
			if(rs.next()){
				retorno.setCod(rs.getInt("CODPRODUTO"));
				retorno.setDesc(rs.getString("DESCRICAO"));
				retorno.setPreco(rs.getDouble("PRECO"));
				retorno.setQuantidade(rs.getInt("QUANTIDADE"));
			}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return retorno;
		
	}
}
