package br.com.aquece.Facade;

import java.util.List;

import br.com.aquece.Vo.MesaVO;

/**
 * Interface facade de Mesa
 * @author Fernanda Santos
 *
 */
public interface MesaServiceFacade {
	
	/**
	 * Método para realizar o cadastro de mesas.
	 * @param mesa
	 */
	public void inserirMesa(MesaVO mesa);
	/**
	 * Método para realizar a exclusão de mesas.
	 * @param mesa
	 */
	public void excluirMesa(MesaVO mesa);
	
	/**
	 * Método para consultar mesa por codigo
	 * @param mesa
	 * @return mesaVo
	 */
	public MesaVO consultarMesa(MesaVO mesa);
	
	/**
	 *  Método para inserir mesa no arquivo morto.
	 * @param mesa
	 */
	public void inserirArquivoMortoMesa(MesaVO mesa);

	public List<MesaVO> consultarSituacaoMesa(int flag);

}
