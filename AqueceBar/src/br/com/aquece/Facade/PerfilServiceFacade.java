package br.com.aquece.Facade;

import br.com.aquece.Vo.PerfilVO;

/**
 * Interface facade de Perfil
 * @author Fernanda Santos
 *
 */
public interface PerfilServiceFacade {
	
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
		public PerfilVO consultarPerfil(PerfilVO perfil);
		
		/**
		 * M�todo para alterar perfil
		 * @param perfil
		 */
		public void alterarPerfil(PerfilVO perfil);
		
		/**
		 * M�todo para inserir os dados de exclus�o no arquivo morto
		 * @param perfil
		 */
		public void inserirArquivoMortoPerfil(PerfilVO perfil);
		
		/**
		 * M�todo para excluir perfil
		 * @param perfil
		 */
		public void excluirPerfil(PerfilVO perfil);

	}

