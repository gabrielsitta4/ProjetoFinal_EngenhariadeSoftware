package EstadosDeClientes;
public class SemCadastro implements Estado{
  public void FazerPedido(){
    System.out.println("você não possui um cadastro ainda");
  } 
  public void FazerCadastro(){
    System.out.println("Cadastro feito");
  }
  public void Quitardividas(){
    System.out.println("você não possui um cadastro ainda");
  }
}