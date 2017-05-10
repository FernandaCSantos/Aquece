package br.com.aquece.Vo;

import java.io.Serializable;

public class ProdutoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private String desc;
	private Double preco;
	private Integer quantidade;
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "ProdutoVO [cod=" + cod + ", desc=" + desc + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
	
	
	

}
