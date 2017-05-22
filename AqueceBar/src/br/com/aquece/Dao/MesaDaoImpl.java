package br.com.aquece.Dao;

import java.sql.ResultSet;
import java.util.List;

import br.com.aquece.Vo.MesaVO;

public class MesaDaoImpl extends Conexao implements MesaDao {

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public void inserirMesa(MesaVO mesa) {
			try	{
				open();
				 stmt = con.prepareStatement("insert into mesa values (?)");
				 setDadosMesa(mesa);
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
	public MesaVO consultarMesa(MesaVO mesa) {
		MesaVO resp = null;

		try	{
			open();
			 stmt = con.prepareStatement("select * from mesa where codMesa = ?");
			 stmt.setInt(1, mesa.getNumeroMesa());
			 rs=stmt.executeQuery();
			 getMesa(rs,resp);
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
	public List<MesaVO> consultarSituacaoMesa() {
		MesaVO resp = null;
		List<MesaVO> lst = null;
		try	{
			open();
			 stmt = con.prepareStatement("select * from vendas where horaFechamento is null");
			 rs=stmt.executeQuery();
			 while(rs.next()){
				 resp = getMesa(rs,resp);
				 lst.add(resp);
			 }
			close();
		}catch (Exception e) {
			e.getMessage();
		}		
		
		return lst;
	}


	public MesaVO getMesa(ResultSet rs, MesaVO resp){
		try{
			if(rs.next()){
				resp = new MesaVO();
				resp.setNumeroMesa(rs.getInt("codMesa"));
			}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoMesa(MesaVO mesa) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("insert into mesa values (?)");
			 setDadosMesa(mesa);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirMesa(MesaVO mesa) {
		try	{
			MesaVO mesavo= new MesaVO();
			mesavo = consultarMesa(mesa);
			inserirArquivoMortoMesa(mesavo);
			
			open();
			 stmt = con.prepareStatement("delete from mesa where codMesa = ?");
			 stmt.setInt(1, mesa.getNumeroMesa());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	/**
	 * Classe para inserir os dados da mesa;
	 * @param mesa
	 */
	public void setDadosMesa(MesaVO mesa){
		try{
			stmt.setInt(1, mesa.getNumeroMesa());
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");
			
		}
	}

}
