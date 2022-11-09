import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bean.Arma;
import bean.Usuario;
import bean.Venda;
import dao.ArmaDao;
import dao.UsuarioDao;
import dao.VendaDAO;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);
        int tabela;
        int opcao;

        System.out.println("Escolha uma opção de tabela");
        System.out.println("1 - arma");
        System.out.println("2 - usuario");
        System.out.println("3 - venda");
        tabela = ler.nextInt();

        Arma arma = new Arma();
        Usuario usuario = new Usuario();
        Venda venda = new Venda();

        ArmaDao armaDao = null;
        UsuarioDao usuarioDao = null;
        VendaDAO vendaDao = null;

        try {
            switch (tabela) {
                case 1:
                    armaDao = new ArmaDao();
                    break;
                case 2:
                    usuarioDao = new UsuarioDao();
                    break;
                case 3:
                    vendaDao = new VendaDAO();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Digite (1 - inserir) , (2- buscar todos) , (3 - atualizar) , (4 - deletar) , (0 - sair)");
        opcao = ler.nextInt();
        switch (tabela) {
            case 1:
                if (opcao == 1) {
                    System.out.println("Digite o nome da arma");
                    String nome = ler.next();
                    arma.setNome(nome);
                    System.out.println("Digite o número de série");
                    int num = ler.nextInt();
                    arma.setNumeroDeSerie(num);
                    System.out.println("Digite a marca");
                    String marca = ler.next();
                    arma.setMarca(marca);
                    System.out.println("Digite o modelo");
                    String modelo = ler.next();
                    arma.setModelo(modelo);
                    System.out.println("Digite o valor");
                    int valor = ler.nextInt();
                    arma.setValor(valor);
                    System.out.println("Digite a quantidade em estoque");
                    int qtd = ler.nextInt();
                    arma.setValor(qtd);
                    armaDao.adicionarArma(arma);
                } else if (opcao == 2) {
                    List<Arma> listaResultado = armaDao.selectArmas();

                    for (Arma arma1 : listaResultado) {
                        System.out.println("Número de série: " + arma.getNumeroDeSerie() +
                                " Nome: " + arma1.getNome() +
                                " Marca: " + arma1.getMarca() +
                                " Modelo: " + arma1.getModelo() +
                                " Valor: " + arma1.getValor() +
                                " Estoque: " + arma1.getEstoque());
                    }
                    armaDao.selectArmas();
                } else if (opcao == 3) {
                    System.out.println("Digite o nome da arma para atualizar");
                    String nome = ler.next();
                    arma.setNome(nome);
                    System.out.println("Digite o número de série para atualizar");
                    int num = ler.nextInt();
                    arma.setNumeroDeSerie(num);
                    System.out.println("Digite a marca para atualizar");
                    String marca = ler.next();
                    arma.setMarca(marca);
                    System.out.println("Digite o modelo para atualizar");
                    String modelo = ler.next();
                    arma.setModelo(modelo);
                    System.out.println("Digite o valor para atualizar");
                    int valor = ler.nextInt();
                    arma.setValor(valor);
                    System.out.println("Digite a quantidade em estoque para atualizar");
                    int qtd = ler.nextInt();
                    arma.setValor(qtd);
                    armaDao.updateArma(arma);
                } else if (opcao == 4){
                    System.out.println("Digite o número de série");
                    int numSerie = ler.nextInt();
                    arma.setNumeroDeSerie(numSerie);
                    armaDao.deletaArma(arma);
                } else {
                    System.out.println("Finalizado !!");
                }
                break;
            case 2:
                // usuarioDao = new UsuarioDao();
                break;
            case 3:
                // vendaDao = new VendaDAO();
                break;
        }

    }
}
