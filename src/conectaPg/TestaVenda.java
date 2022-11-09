package conectaPg;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import bean.Venda;
import dao.VendaDAO;

public class TestaVenda {
	public static void testaInsert() {

		Venda venda = new Venda();
		venda.setId(1);
		venda.setNumeroDeSerieArma(1);
		venda.setIdUsuario(1);
		venda.setNotaFiscal(123456);
		venda.setDataVenda(new Date());

		VendaDAO venDAO = null;

		try {

			venDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		venDAO.adicionarVenda(venda);
	}

	public static void testaUpdate() {

		Venda venda = new Venda();
		venda.setNumeroDeSerieArma(1);
		venda.setNotaFiscal(654321);
		VendaDAO venDAO = null;

		try {

			venDAO = new VendaDAO();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		venDAO.updateVenda(venda);

	}

	public static void testaDelete() {

		Venda venda = new Venda();
		venda.setIdUsuario(1);
		VendaDAO venDAO = null;

		try {
			venDAO = new VendaDAO();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		venDAO.deleteVenda(venda);
	}

	public static void testaSelectTodos() {

		VendaDAO venDAO = null;

		try {
			venDAO = new VendaDAO();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		List<Venda> listaResultado = venDAO.selectTodos();

		for (Venda v : listaResultado) {

			System.out.println("id: " + v.getId() + " numeroDeSerieArma: " + v.getNumeroDeSerieArma() + " idUsuario: "
					+ v.getIdUsuario() + " notaFiscal: " + v.getNotaFiscal() + " dataVenda: " + v.getDataVenda());

		}

	}

}
