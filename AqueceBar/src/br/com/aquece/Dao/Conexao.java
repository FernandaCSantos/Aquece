package br.com.aquece.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe respons�vel pela conex�o dao
 * @author Fernanda Santos
 *
 */
public class Conexao {

	Connection con;
	Connection conArquivoMorto;
	PreparedStatement stmt;
	ResultSet rs;

	/**
	 * M�todo para abrir conex�o com o banco default
	 * @throws Exception
	 */
	public void open() throws Exception{
		 Class.forName("com.mysql.jdbc.Driver");

		 con = DriverManager. getConnection
		("jdbc:mysql://localhost:3306/Aquece","root","22547744");

	}
	
	/**
	 * M�todo para fechar conex�o com o banco default
	 * @throws Exception
	 */
	public void close() throws Exception{
		con.close();
	}

	/**
	 * M�todo para abrir conex�o com o arquivomorto
	 * @throws Exception
	 */
	public void openArquivoMorto() throws Exception{
	 Class.forName("com.mysql.jdbc.Driver");
	 conArquivoMorto = DriverManager. getConnection("jdbc:mysql://localhost:3306/AqueceArquivoMorto","root","22547744");
	}
	
	/**
	 * M�todo para fechar conex�o com o arquivomorto
	 * @throws Exception
	 */
	public void closeArquivoMorto() throws Exception{
		conArquivoMorto.close();
	}

}
