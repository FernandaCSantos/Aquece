package br.com.aquece.Dao;

import java.sql.ResultSet;

import br.com.aquece.Vo.VendasVO;

public class VendasDaoImpl extends Conexao implements VendasDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirVendas(VendasVO venda) {
		try	{
			open();
			 stmt = con.prepareStatement("ALTERAR");
			 setDadosVendas(venda);
			 stmt.execute();
			close();
		}catch (Exception e) {
			e.getMessage();
		}		

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fecharVendas(VendasVO venda) {
		try	{
			VendasVO vendavo = new VendasVO();
			vendavo = consultarVendas(venda);
			inserirArquivoMortoVendas(vendavo);
			
			open();
			 stmt = con.prepareStatement("ALTERAR");
			 stmt.setInt(1, venda.getCod());
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
	public void alterarVendas(VendasVO venda) {
		try	{
			open();
			 stmt = con.prepareStatement("ALTERAR");
//			 stmt.set
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
	public VendasVO consultarVendas(VendasVO venda) {
		VendasVO resp = null;

		try	{
			open();
			 stmt = con.prepareStatement("ALTERAR");
			 stmt.setInt(1, venda.getCod());
			 rs=stmt.executeQuery();
			 getVendas(rs,resp);
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
	public void inserirArquivoMortoVendas(VendasVO venda) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("ALTERAR");
			 setDadosVendas(venda);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	/**
	 * Classe para inserir os dados da mesa;
	 * @param mesa
	 */
	public void setDadosVendas(VendasVO venda){
		try{
//			stmt.setInt(1, mesa.getNumeroMesa());
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");
			
		}
	}

	public VendasVO getVendas(ResultSet rs, VendasVO resp){
		try{
			if(rs.next()){
				resp = new VendasVO();
				resp.setCod(rs.getInt("codVendas"));
			}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}

}
