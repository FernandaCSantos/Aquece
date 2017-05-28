package br.com.aquece.Dao;

import java.sql.ResultSet;

import br.com.aquece.Vo.PerfilVO;

public class PerfilDaoImpl extends Conexao implements PerfilDao {

	@Override
	public void inserirPerfil(PerfilVO perfil) {
		try	{
			perfil.setCod(lastId()+1);
			open();
			 stmt = con.prepareStatement("insert into perfil values (?,?,?,?)");
			 setDadosPerfil(perfil);
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}		
	}

	public Integer lastId(){
		ResultSet resp = null;
		Integer chave = null;
		try {
			open();
			stmt = con.prepareStatement("select max(codPerfil) as maximo from perfil");
			resp = stmt.executeQuery();
			if(resp.next()){
			chave = (resp.getInt("maximo"));
			}
			close();
		} catch (Exception e) {
			new Exception("Erro Interno");
		}
	
		return chave;
	}
	@Override
	public PerfilVO consultarPerfil(PerfilVO perfil) {
		PerfilVO resp = null;

		try	{
			open();
			 stmt = con.prepareStatement("select codPerfil,nomePerfil,usuario,senha from perfil where codPerfil= ?");
			 stmt.setInt(1, perfil.getCod());
			 rs=stmt.executeQuery();
			 getPerfil(rs,resp);
			close();
		}catch (Exception e) {
			e.getMessage();
		}		
		
		return resp;
	}

	@Override
	public void alterarPerfil(PerfilVO perfil) {
		try	{
			open();
			 stmt = con.prepareStatement("update perfil set nomePerfil = ?, usuario = ? , senha = ? where codPerfil = ?");
			 stmt.setString(1, perfil.getNomePerfil());
			 stmt.setString(2, perfil.getUser());
			 stmt.setString(3, perfil.getPassword());
			 stmt.setInt(4, perfil.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}		
	}
	

	@Override
	public void excluirPerfil(PerfilVO perfil) {
		try	{
			PerfilVO perfilvo= new PerfilVO();
			perfilvo = consultarPerfil(perfil);
			inserirArquivoMortoPerfil(perfilvo);
			
			open();
			 stmt = con.prepareStatement("delete from perfil where codPerfil = ?");
			 stmt.setInt(1, perfil.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}	
	}
	
	@Override
	public void inserirArquivoMortoPerfil(PerfilVO perfil) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("insert into perfil values (?,?,?,?)");
			 setDadosPerfil(perfil);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno");
		}				
	}

	/**
	 * Classe para inserir os dados do perfil;
	 * @param perfil
	 */
	public void setDadosPerfil(PerfilVO perfil){
		try{
			stmt.setInt(1, perfil.getCod());
			stmt.setString(2, perfil.getNomePerfil());
			try{
				stmt.setString(3, perfil.getUser());
			}catch (Exception e) {
				stmt.setString(3, null);
			}
			
			try{
				stmt.setString(4,perfil.getPassword());
			}catch (Exception e) {
				stmt.setString(4,null);
			}
			
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");
			
		}
	}
	
	/**
	 * Classe para resgatar os dados do perfil;
	 * @param perfil
	 */
	public PerfilVO getPerfil(ResultSet rs, PerfilVO resp){
		try{
			if(rs.next()){
				resp = new PerfilVO();
				resp.setCod(rs.getInt("codPerfil"));
				resp.setNomePerfil(rs.getString("nomePerfil"));
				resp.setUser(rs.getString("usuario"));
				resp.setPassword(rs.getString("senha"));
		 
		}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}

}
