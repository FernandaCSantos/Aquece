package br.com.aquece.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.aquece.Vo.MesaVO;

@Repository
public class MesaDaoImpl extends Conexao implements MesaDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirMesa(MesaVO mesa) {
		try {
			open();
			mesa.setSituacao(0);
			stmt = con.prepareStatement("INSERT INTO MESA VALUES (?,?)");
			setDadosMesa(mesa);
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MesaVO consultarMesa(MesaVO mesa) {
		MesaVO resp = null;

		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM MESA WHERE CODMESA = ?");
			stmt.setInt(1, mesa.getNumeroMesa());
			rs = stmt.executeQuery();
			getMesa(rs);
			close();
		} catch (Exception e) {
			e.getMessage();
		}

		return resp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MesaVO> consultarSituacaoMesa() {
		MesaVO resp = null;

		List<MesaVO> lst = new ArrayList<MesaVO>();
		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM MESA ORDER BY CODMESA");
			rs = stmt.executeQuery();
			while (rs.next()) {
				resp = getMesa(rs);
				lst.add(resp);
			}
			close();
		} catch (Exception e) {
			e.getMessage();
		}

		return lst;
	}

	public MesaVO getMesa(ResultSet rs) {
		MesaVO resultado = new MesaVO();
		try {
				try {
					resultado.setNumeroMesa(rs.getInt("CODMESA"));
				} catch (Exception e) {
					resultado.setNumeroMesa(null);
				}

				try {
					resultado.setSituacao(rs.getInt("SITUACAO"));
				} catch (Exception e) {
					resultado.setSituacao(null);
				}

		} catch (Exception e) {
			new Exception("Ocorreu um erro ao consultar os dados.");

		}
		return resultado;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirArquivoMortoMesa(MesaVO mesa) {
		try {
			openArquivoMorto();
			stmt = conArquivoMorto.prepareStatement("INSERT INTO MESA VALUES (?)");
			setDadosMesa(mesa);
			stmt.execute();
			closeArquivoMorto();
		} catch (Exception e) {
			new Exception("Erro Interno");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluirMesa(MesaVO mesa) {
		try {
			MesaVO mesavo = new MesaVO();
			mesavo = consultarMesa(mesa);
			inserirArquivoMortoMesa(mesavo);

			open();
			stmt = con.prepareStatement("DELETE FROM MESA WHERE CODMESA = ?");
			stmt.setInt(1, mesa.getNumeroMesa());
			stmt.execute();
			close();
		} catch (Exception e) {
			new Exception("Erro Interno");
		}
	}

	/**
	 * Classe para inserir os dados da mesa;
	 * 
	 * @param mesa
	 */
	public void setDadosMesa(MesaVO mesa) {
		try {
			stmt.setInt(1, mesa.getNumeroMesa());
			stmt.setInt(2, mesa.getSituacao());
		} catch (Exception e) {
			new Exception("Ocorreu um erro ao inserir os dados.");

		}
	}

}
