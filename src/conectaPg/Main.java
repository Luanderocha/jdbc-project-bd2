package conectaPg;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {

    try{
      Connection con = Conecta.criarConexao();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }catch (SQLException e){
      e.printStackTrace();
    }
    
    TestaMetodosArmaDao.testaInsert();
    TestaMetodosArmaDao.testaSelectTodos();
    TestaMetodosArmaDao.testaUpdate();
    TestaMetodosArmaDao.testaSelectTodos();
    TestaMetodosArmaDao.testaDelete();
    
    TestaMetodosUsuarioDao.testaInsert();
    TestaMetodosUsuarioDao.testaSelectTodos();
    TestaMetodosUsuarioDao.testaUpdate();
    TestaMetodosUsuarioDao.testaSelectTodos();
    TestaMetodosUsuarioDao.testaDelete();
    
    TestaMetodosArmaDao.testaInsert();
    TestaMetodosUsuarioDao.testaInsert();
    
    TestaVenda.testaInsert();
    TestaVenda.testaSelectTodos();
    TestaVenda.testaUpdate();
    TestaVenda.testaSelectTodos();
    TestaVenda.testaDelete();
    
    TestaMetodosUsuarioDao.testaDelete();
    TestaMetodosArmaDao.testaDelete();
  }
}
