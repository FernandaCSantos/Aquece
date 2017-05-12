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
	 * M�todo respons�vel pela inser��o de perfil
	 * @param perfil
	 */
	public void inserirPerfil(PerfilVO perfil);

	/**
	 * M�todo para consultar perfil
	 * @param perfil
	 * @return perfilVO
	 */
	public PerfilVO consultarPerfil(PerfilVO produto);
	
	/**
	 * M�todo para alterar perfil
	 * @param perfil
	 */
	public void alterarPerfil(PerfilVO produto);
	
	/**
	 * M�todo para inserir os dados de exclus�o no arquivo morto
	 * @param perfil
	 */
	public void inserirArquivoMortoPerfil(PerfilVO produto);
	
	/**
	 * M�todo para excluir perfil
	 * @param perfil
	 */
	public void excluirPerfil(PerfilVO produto);

}
