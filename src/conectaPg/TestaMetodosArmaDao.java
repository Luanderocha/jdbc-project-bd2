package conectaPg;
import java.sql.SQLException;

import java.util.List;

import bean.Arma;
import dao.ArmaDao;

public class TestaMetodosArmaDao {
	
	public static void testaDelete() {
			Arma arma = new Arma();
			arma.setNumeroDeSerie(1);
			
			ArmaDao dao = null;
			
			try {
				dao = new ArmaDao();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			dao.deletaArma(arma);
			
	}
	
	public static void testaInsert() {
		Arma arma1 = new Arma();
		arma1.setNumeroDeSerie(1);
		arma1.setNome("Glock");
		arma1.setMarca("taurus");
		arma1.setModelo("pistola");
		arma1.setValor(550);
		arma1.setEstoque(3);
		
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		armadao.adicionarArma(arma1);
	}
	
	public static void testaUpdate() {
		Arma armaUpdate = new Arma();
		armaUpdate.setNumeroDeSerie(1);
		armaUpdate.setValor(520);
		
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		armadao.updateArma(armaUpdate);
		
	}
	
	public static void testaSelectTodos() {
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		List<Arma> listaResultado = armadao.selectArmas();
		
		
		for (Arma arma : listaResultado) {
			System.out.println("Número de série: "+ arma.getNumeroDeSerie()+
					" Nome: "+ arma.getNome()+
					" Marca: "+ arma.getMarca()+
					" Modelo: "+ arma.getModelo()+
					" Valor: "+ arma.getValor()+
					" Estoque: "+arma.getEstoque());
		}
	}
}
