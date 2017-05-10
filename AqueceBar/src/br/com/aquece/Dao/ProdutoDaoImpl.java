package br.com.aquece.Dao;

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
			 stmt.setInt(1, produto.getCod());
			 stmt.setString(2, produto.getDesc());
			 stmt.setDouble(3, produto.getPreco());
			 stmt.setInt(4,produto.getQuantidade());
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
			if(rs.next()){
				resp = new ProdutoVO();
				resp.setCod(rs.getInt("codProduto"));
				resp.setDesc(rs.getString("descricao"));
			 
			}

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
			 stmt = con.prepareStatement("update produto set descricao = ? where codProduto = ?");
			 stmt.setInt(2, produto.getCod());
			 stmt.setString(1, produto.getDesc());
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
			 stmt.setInt(1, produto.getCod());
			 stmt.setString(2, produto.getDesc());
			 
			 if(produto.getPreco() == null){
				stmt.setDouble(3, 0.);
			 }else{

				 stmt.setDouble(3, produto.getPreco());
			 }
			 
			 if(produto.getQuantidade() == null){
				 stmt.setInt(4,0);

			 }else{
				 stmt.setInt(4,produto.getQuantidade());

			 }
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	public static void main(String[] args) throws Exception {
		ProdutoVO c = new ProdutoVO();
		c.setCod(5);
		c.setDesc("test2");
		c.setPreco(12.0);
		c.setQuantidade(3);
		//		System.out.println(new ProdutoDaoImpl().consultarProduto(c));
//		new ProdutoDaoImpl().excluirProduto(c);
//		new ProdutoDaoImpl().inserirProduto(c);
}

}
