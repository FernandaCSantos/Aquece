package br.com.aquece.Dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.aquece.Vo.MesaVO;
import br.com.aquece.Vo.PerfilVO;
import br.com.aquece.Vo.ProdutoVO;
import br.com.aquece.Vo.VendasVO;

public class VendasDaoImpl extends Conexao implements VendasDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer inserirVendas(VendasVO venda,String status) {
		try	{
			if(status.equals("livre"))
			venda.setCod(chave(venda.getMesaVO()));
			open();
			 stmt = con.prepareStatement("Insert into vendas values(?,?,?,?,?,?,?)");
			 setDadosVendas(venda,status);
			 stmt.execute();
			close();
		}catch (Exception e) {
			e.getMessage();
		}		

		return venda.getCod();
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
			 getVendas(rs);
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
//			 setDadosVendas(venda);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}
	
	/**
	 * Classe para inserir os dados da Venda;
	 * @param venda
	 */
	public void setDadosVendas(VendasVO venda,String status){
		try{
			stmt.setInt(1, venda.getCod());
			stmt.setInt(2, venda.getMesaVO().getNumeroMesa());
			stmt.setInt(3, venda.getProdutoVO().getCod());
			stmt.setInt(4, venda.getPerfilVO().getCod());
			if(status.equals("livre"))
				stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			else
				stmt.setTimestamp(5, null);
			if(status.equals("fechar"))
				stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			else
				stmt.setTimestamp(6, null);				
			stmt.setDouble(7, venda.getQuantidade());
			
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");
			
		}
	}

	public VendasVO getVendas(ResultSet rs){
		VendasVO resp = null;
		try{
				
				Calendar cal1 = Calendar.getInstance();

				resp = new VendasVO();
				MesaVO mesa = new MesaVO();
				ProdutoVO produto = new  ProdutoVO();
				PerfilVO perfil = new PerfilVO();
				try{
					resp.setCod(rs.getInt("codVenda"));
				}catch (Exception e) {
					resp.setCod(null);
				}
				try{
					mesa.setNumeroMesa(rs.getInt("codMesa"));
				}catch (Exception e) {
					mesa.setNumeroMesa(null);
				}
				try{
					produto.setCod(rs.getInt("codProduto"));
				}catch (Exception e) {
					produto.setCod(null);
				}
				try{
					perfil.setCod(rs.getInt("codPerfil"));
				}catch (Exception e) {
					perfil.setCod(null);
				}
				try{
					cal1.setTime(rs.getDate("horaAbertura"));
					resp.setHoraAbertura(cal1);
						
				}catch (Exception e) {
					resp.setHoraAbertura(null);
				}
				try{
					cal1 = Calendar.getInstance();
					cal1.setTime(rs.getDate("horaFechamento"));
					resp.setHoraFechamento(cal1);
					
				}catch (Exception e) {
					resp.setHoraFechamento(null);
				}
				
				try{
					resp.setQuantidade(rs.getDouble("quantidade"));
				}catch (Exception e) {
					resp.setQuantidade(null);
				
				}
				resp.setPerfilVO(perfil);
				resp.setMesaVO(mesa);
				resp.setProdutoVO(produto);
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}

	public Integer chave(MesaVO mesa){
		Integer codigo = 0;
		try{
			open();
				 stmt = con.prepareStatement("SELECT MAX(CODVENDA)+1 as MAXIMO FROM VENDAS");
				 rs=stmt.executeQuery();
				 if(rs.next()){
					 codigo = rs.getInt("MAXIMO");
     				}
				 if(codigo < 0 || codigo.equals(null)){
					 codigo = 1;
				 }
			close();
			mudarSituacaoMesa(mesa, 1);
		}catch (Exception e) {
			e.getMessage();
		}
		return codigo;
		}

	public Integer mudarSituacaoMesa(MesaVO mesa, Integer situacao){
		Integer codigo = 0;
		try{
			open();
				 stmt = con.prepareStatement("UPDATE MESA SET SITUACAO = ? WHERE CODMESA = ? ");
				 stmt.setInt(1, situacao);
				 stmt.setInt(2, mesa.getNumeroMesa());
				 stmt.execute();
			close();
			
		}catch (Exception e) {
			e.getMessage();
		}

		return codigo;
	}
		
	@Override
	public List<VendasVO> inicializarTelaVendas(){
		VendasVO resp = null;
		List<VendasVO> lst = new ArrayList<VendasVO>();

		try {
			open();
			 stmt = con.prepareStatement("select * from vendas where horaFechamento is null");
			 rs=stmt.executeQuery();
				while (rs.next()) {
					resp = getVendas(rs);
					 	lst.add(resp);
				}
			 	close();
			
		} catch (Exception e) {
			e.getMessage();
		}

		return lst;
	}
}
