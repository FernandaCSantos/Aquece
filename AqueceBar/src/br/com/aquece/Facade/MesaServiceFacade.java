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
	 * M�todo para realizar o cadastro de mesas.
	 * @param mesa
	 */
	public void inserirMesa(MesaVO mesa);
	/**
	 * M�todo para realizar a exclus�o de mesas.
	 * @param mesa
	 */
	public void excluirMesa(MesaVO mesa);
	
	/**
	 * M�todo para consultar mesa por codigo
	 * @param mesa
	 * @return mesaVo
	 */
	public MesaVO consultarMesa(MesaVO mesa);
	
	/**
	 *  M�todo para inserir mesa no arquivo morto.
	 * @param mesa
	 */
	public void inserirArquivoMortoMesa(MesaVO mesa);

	public List<MesaVO> consultarSituacaoMesa();

}
