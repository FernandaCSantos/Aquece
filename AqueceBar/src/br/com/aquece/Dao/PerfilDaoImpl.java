package br.com.aquece.Dao;

import java.sql.ResultSet;

import br.com.aquece.Vo.PerfilVO;

public class PerfilDaoImpl extends Conexao implements PerfilDao {

	@Override
	public void inserirPerfil(PerfilVO perfil) {
		try	{
			perfil.setCod(lastId()+1);
			open();
			 stmt = con.prepareStatement("INSERT INTO PERFIL VALUES (?,?,?,?)");
			 setDadosPerfil(perfil);
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}		
	}

	public Integer lastId(){
		ResultSet resp = null;
		Integer chave = null;
		try {
			open();
			stmt = con.prepareStatement("SELECT MAX(CODPERFIL) AS MAXIMO FROM PERFIL");
			resp = stmt.executeQuery();
			if(resp.next()){
			chave = (resp.getInt("MAXIMO"));
			}
			close();
		} catch (Exception e) {
			new Exception("Erro Interno.");
		}
	
		return chave;
	}
	
	@Override
	public PerfilVO consultarPerfil(PerfilVO perfil) {
		PerfilVO resp = null;

		try	{
			open();
			 stmt = con.prepareStatement("SELECT CODPERFIL,NOMEPERFIL,USUARIO,SENHA FROM PERFIL WHERE CODPERFIL = ?");
			 stmt.setInt(1, perfil.getCod());
			 rs=stmt.executeQuery();
			 getPerfil(rs);
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}		
		
		return resp;
	}

	@Override
	public void alterarPerfil(PerfilVO perfil) {
		try	{
			open();
			 stmt = con.prepareStatement("UPDATE PERFIL SET NOMEPERFIL = ?, USUARIO = ? , SENHA = ? WHERE CODPERFIL = ?");
			 stmt.setString(1, perfil.getNomePerfil());
			 stmt.setString(2, perfil.getUser());
			 stmt.setString(3, perfil.getPassword());
			 stmt.setInt(4, perfil.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}		
	}
	

	@Override
	public void excluirPerfil(PerfilVO perfil) {
		try	{
			PerfilVO perfilvo= new PerfilVO();
			perfilvo = consultarPerfil(perfil);
			inserirArquivoMortoPerfil(perfilvo);
			
			open();
			 stmt = con.prepareStatement("DELETE FROM PERFIL WHERE CODPERFIL = ?");
			 stmt.setInt(1, perfil.getCod());
			 stmt.execute();
			close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}	
	}
	
	@Override
	public void inserirArquivoMortoPerfil(PerfilVO perfil) {
		try	{
			openArquivoMorto();
			 stmt = conArquivoMorto.prepareStatement("INSERT INTO PERFIL VALUES (?,?,?,?)");
			 setDadosPerfil(perfil);
			 stmt.execute();
			closeArquivoMorto();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}				
	}

	@Override
	public PerfilVO login(PerfilVO perfil){
		PerfilVO retorno = new PerfilVO();
		ResultSet rs = null;
		try	{
			open();
			 stmt = con.prepareStatement("SELECT * FROM PERFIL WHERE USUARIO = ? AND SENHA = ?");
			 stmt.setString(1, perfil.getUser());
			 stmt.setString(2, perfil.getPassword());
			 rs = stmt.executeQuery();
			 retorno = getPerfil(rs);
			 close();
		}catch (Exception e) {
			new Exception("Erro Interno.");
		}	
		return retorno;
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
	public PerfilVO getPerfil(ResultSet rs){
		PerfilVO resp = new PerfilVO();
		try{
			if(rs.next()){
				resp.setCod(rs.getInt("CODPERFIL"));
				resp.setNomePerfil(rs.getString("NOMEPERFIL"));
				resp.setUser(rs.getString("USUARIO"));
				resp.setPassword(rs.getString("SENHA"));
		 
		}
		}catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");
			
		}
		return resp;
		
	}

}
