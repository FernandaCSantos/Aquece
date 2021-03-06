package br.com.aquece.Vo;

import java.io.Serializable;

public class PerfilVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6196554750223790303L;
	
	private Integer cod;
	private String nomePerfil;
	private String user;
	private String password;
	
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "PerfilVO [cod=" + cod + ", nomePerfil=" + nomePerfil + ", user=" + user + "]";
	}
	
	
}
