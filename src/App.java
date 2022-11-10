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
        while (opcao != 0) {
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
                        float valor = ler.nextInt();
                        arma.setValor(valor);
                        System.out.println("Digite a quantidade em estoque");
                        int qtd = ler.nextInt();
                        arma.setEstoque(qtd);
                        armaDao.adicionarArma(arma);
                    } else if (opcao == 2) {
                        List<Arma> listaResultado = armaDao.selectArmas();

                        for (Arma arma1 : listaResultado) {
                            System.out.println("Número de série: " + arma1.getNumeroDeSerie() +
                                    " Nome: " + arma1.getNome() +
                                    " Marca: " + arma1.getMarca() +
                                    " Modelo: " + arma1.getModelo() +
                                    " Valor: " + arma1.getValor() +
                                    " Estoque: " + arma1.getEstoque());
                        }
                        armaDao.selectArmas();
                    } else if (opcao == 3) {
                        System.out.println("Digite o número de série para atualizar");
                        int num = ler.nextInt();
                        arma.setNumeroDeSerie(num);
                        System.out.println("Digite o valor para atualizar");
                        int valor = ler.nextInt();
                        arma.setValor(valor);
                        armaDao.updateArma(arma);
                    } else if (opcao == 4) {
                        System.out.println("Digite o número de série");
                        int numSerie = ler.nextInt();
                        arma.setNumeroDeSerie(numSerie);
                        armaDao.deletaArma(arma);
                    } else {
                        System.out.println("Número incorreto , digite novamente");
                    }
                    break;
                case 2:
                    if (opcao == 1) {
                        System.out.println("Digite o nome do usuário");
                        String nome = ler.next();
                        usuario.setNome(nome);
                        System.out.println("Digite o id do usuário");
                        int id = ler.nextInt();
                        usuario.setId(id);
                        System.out.println("Digite o cpf do usuário");
                        String cpf = ler.next();
                        usuario.setCpf(cpf);
                        System.out.println("Digite o email do usuário");
                        String email = ler.next();
                        usuario.setEmail(email);
                        System.out.println("Digite o telefone do usuário");
                        String telefone = ler.next();
                        usuario.setTelefone(telefone);
                        usuarioDao.adicionarUsuario(usuario);
                    } else if (opcao == 2) {
                        List<Usuario> listaResultado = usuarioDao.selectUsuario();

                        for (Usuario usuario1 : listaResultado) {
                            System.out.println("O id é: " + usuario1.getId() +
                                    " Nome: " + usuario1.getNome() +
                                    " Cpf: " + usuario1.getCpf() +
                                    " Email: " + usuario1.getEmail() +
                                    " Telefone: " + usuario1.getTelefone());

                        }
                    } else if (opcao == 3) {
                        System.out.println("Digito id do usuário");
                        int id = ler.nextInt();
                        usuario.setId(id);
                        System.out.println("Digite a atualização do nome");
                        String nome = ler.next();
                        usuario.setNome(nome);
                        System.out.println("Digite a atualização do email");
                        String email = ler.next();
                        usuario.setEmail(email);
                        System.out.println("Digite a atualização do telefone");
                        String telefone = ler.next();
                        usuario.setTelefone(telefone);
                        usuarioDao.updateUsuario(usuario);
                    } else if (opcao == 4) {
                        System.out.println("Digite o id do usuário");
                        int id = ler.nextInt();
                        usuario.setId(id);
                        usuarioDao.deletaUsuario(usuario);
                    } else {
                        System.out.println("Número incorreto , digite novamente");
                    }
                    break;
                case 3:
                    // vendaDao = new VendaDAO();
                    break;
            }
            System.out
                    .println("Digite (1 - inserir) , (2- buscar todos) , (3 - atualizar) , (4 - deletar) , (0 - sair)");
            opcao = ler.nextInt();
        }

    }
}
