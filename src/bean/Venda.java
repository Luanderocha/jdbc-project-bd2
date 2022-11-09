package bean;
import java.util.Date;

public class Venda {
	private int id;
	private int numeroDeSerieArma;
	private int idUsuario;
	private int notaFiscal;
	private Date dataVenda;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroDeSerieArma() {
		return numeroDeSerieArma;
	}
	public void setNumeroDeSerieArma(int numeroDeSerieArma) {
		this.numeroDeSerieArma = numeroDeSerieArma;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(int notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
}
