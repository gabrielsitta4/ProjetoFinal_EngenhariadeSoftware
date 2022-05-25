package EstadosDeClientes;
public class ComCadastro implements Estado{
  public void FazerPedido(){
    System.out.println("chame um garçom para fazer o pedido");
  } 
  public void FazerCadastro(){
    System.out.println("Você já possui um cadastro");
  }
  public void Quitardividas(){
    System.out.println("você não possui dívidas ainda");
  }
}