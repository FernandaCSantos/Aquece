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
			 stmt = con.prepareStatement("insert into produto values (?,?,?,?)");
			 setDadosProduto(produto);
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
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
			 stmt = con.prepareStatement("select * from produto where codProduto = ?");
			 stmt.setInt(1, produto.getCod());
			 rs=stmt.executeQuery();
			 getProduto(rs,resp);
			close();
		}catch (Exception e) {
			e.getMessage();
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
			 stmt = con.prepareStatement("update produto set descricao = ?, preco = ? , quantidade = ? where codProduto = ?");
			 stmt.setString(1, produto.getDesc());
			 stmt.setDouble(2, produto.getPreco());
			 stmt.setInt(3, produto.getQuantidade());
			 stmt.setInt(4, produto.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
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
			 stmt = con.prepareStatement("delete from produto where codProduto = ?");
			 stmt.setInt(1, produto.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoProduto(ProdutoVO produto) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("insert into produto values (?,?,?,?)");
			 setDadosProduto(produto);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
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
	public ProdutoVO getProduto(ResultSet rs, ProdutoVO resp){
		try{
			if(rs.next()){
				resp = new ProdutoVO();
				resp.setCod(rs.getInt("codProduto"));
				resp.setDesc(rs.getString("descricao"));
				resp.setPreco(rs.getDouble("preco"));
				resp.setQuantidade(rs.getInt("quantidade"));
			}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}
}
