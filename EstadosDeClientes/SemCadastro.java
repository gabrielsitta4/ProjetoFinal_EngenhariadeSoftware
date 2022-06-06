package EstadosDeClientes;
public class SemCadastro implements Estado{
  public void fazerPedido(){
    System.out.println("você não possui um cadastro ainda");
  } 
  public void fazerCadastro(){
    System.out.println("Cadastro feito");
  }
  public void quitardividas(){
    System.out.println("você não possui um cadastro ainda");
  }
  public String descrisao(){
    return "Cliente Sem cadastro";
  }
}