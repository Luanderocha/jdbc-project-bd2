package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Arma;
import conectaPg.Conecta;


public class ArmaDao {
	
	private Connection con;
	
	public ArmaDao()throws SQLException, ClassNotFoundException{
		con = Conecta.criarConexao();
	}
	
	public void adicionarArma(Arma arma) {
		String sql = "INSERT INTO Arma (numerodeserie, nome, marca, modelo, valor, estoque) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, arma.getNumeroDeSerie());
			preparador.setString(2, arma.getNome());
			preparador.setString(3, arma.getMarca());
			preparador.setString(4, arma.getModelo());
			preparador.setFloat(5, arma.getValor());
			preparador.setInt(6, arma.getEstoque());
			preparador.execute();
			preparador.close();
			System.out.println("Inserção realizada!");
		} catch (SQLException e) {
			System.out.println("ERRO - "+e.getMessage());
		}
	}
	
	public void updateArma(Arma arma) {
		String sql = "UPDATE Arma SET valor = ? , estoque = ? WHERE numeroDeSerie = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setFloat(1, arma.getValor());
			preparador.setInt(2, arma.getEstoque());
			preparador.setInt(3, arma.getNumeroDeSerie());
			preparador.execute();
			preparador.close();
			System.out.println("Atualização realizada!");
		}catch(SQLException e) {
			System.out.println("ERRO - "+e.getMessage());
		}
	}
	
	public void deletaArma(Arma arma) {
		String sql = "DELETE FROM Arma WHERE numeroDeSerie = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, arma.getNumeroDeSerie());
			preparador.execute();
			preparador.close();
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("ERRO - "+e.getMessage());
		}
	}
	
	public List<Arma> selectArmas(){
		String sql = "SELECT * FROM Arma";
		
		List<Arma> lista = new ArrayList<Arma>();		
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			
			while(resultados.next()) {
				Arma armaTemp = new Arma();
				armaTemp.setNumeroDeSerie(resultados.getInt("numerodeserie"));
				armaTemp.setNome(resultados.getString("nome"));
				armaTemp.setMarca(resultados.getString("marca"));
				armaTemp.setModelo(resultados.getString("modelo"));
				armaTemp.setValor(resultados.getFloat("valor"));
				armaTemp.setEstoque(resultados.getInt("estoque"));
				
				lista.add(armaTemp);
			}
		} catch (Exception e) {
			System.out.println("ERRO - "+e.getMessage());
		}
		
		return lista;
	
	}
	
}
