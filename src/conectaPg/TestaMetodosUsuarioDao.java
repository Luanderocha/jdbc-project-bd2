package conectaPg;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import bean.Usuario;
import dao.UsuarioDao;

public class TestaMetodosUsuarioDao {

    public static void testaDelete() {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        UsuarioDao dao = null;

        try {
            dao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        dao.deletaUsuario(usuario);

    }

    public static void testaInsert() {
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setNome("Luan");
        usuario1.setCpf("12345678900");
        usuario1.setEmail("luan@teste.com");
        usuario1.setTelefone("83999887766");

        UsuarioDao usuarioDao = null;

        try {
            usuarioDao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        usuarioDao.adicionarUsuario(usuario1);
    }

    public static void testaUpdate() {
        Usuario usuarioUpdate = new Usuario();
        usuarioUpdate.setId(1);
        usuarioUpdate.setNome("fulano de tal");
        usuarioUpdate.setEmail("fulano_de_tal@gmail.com");
        usuarioUpdate.setTelefone("83933669955");

        UsuarioDao usuariodao = null;

        try {
            usuariodao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        usuariodao.updateUsuario(usuarioUpdate);

    }

    public static void testaSelectTodos() {
        UsuarioDao usuarioDao = null;

        try {
            usuarioDao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        List<Usuario> listaResultado = usuarioDao.selectUsuario();


        for (Usuario usuario : listaResultado) {
            System.out.println("O id é: "+ usuario.getId()+
                    " Nome: "+ usuario.getNome()+
                    " Cpf: "+ usuario.getCpf()+
                    " Email: "+ usuario.getEmail() +
                    " Telefone: "+ usuario.getTelefone());

        }
    }
}
