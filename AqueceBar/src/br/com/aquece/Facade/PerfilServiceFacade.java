package br.com.aquece.Facade;

import br.com.aquece.Vo.PerfilVO;

/**
 * Interface facade de Perfil
 * @author Fernanda Santos
 *
 */
public interface PerfilServiceFacade {
	
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
		public PerfilVO consultarPerfil(PerfilVO perfil);
		
		/**
		 * Método para alterar perfil
		 * @param perfil
		 */
		public void alterarPerfil(PerfilVO perfil);
		
		/**
		 * Método para inserir os dados de exclusão no arquivo morto
		 * @param perfil
		 */
		public void inserirArquivoMortoPerfil(PerfilVO perfil);
		
		/**
		 * Método para excluir perfil
		 * @param perfil
		 */
		public void excluirPerfil(PerfilVO perfil);

	}

