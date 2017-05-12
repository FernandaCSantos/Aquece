package br.com.aquece.Dao;

import br.com.aquece.Vo.PerfilVO;
import br.com.aquece.Vo.ProdutoVO;

/**
 * Interface facade de Perfil
 * @author Fernanda Santos
 *
 */
public interface PerfilDao {

	/**
	 * Método responsável pela inserção de perfil
	 * @param perfil
	 */
	public void inserirPerfil(PerfilVO perfil);

	/**
	 * Método para consultar perfil
	 * @param perfil
	 * @return perfilVO
	 */
	public PerfilVO consultarPerfil(PerfilVO produto);
	
	/**
	 * Método para alterar perfil
	 * @param perfil
	 */
	public void alterarPerfil(PerfilVO produto);
	
	/**
	 * Método para inserir os dados de exclusão no arquivo morto
	 * @param perfil
	 */
	public void inserirArquivoMortoPerfil(PerfilVO produto);
	
	/**
	 * Método para excluir perfil
	 * @param perfil
	 */
	public void excluirPerfil(PerfilVO produto);

}
