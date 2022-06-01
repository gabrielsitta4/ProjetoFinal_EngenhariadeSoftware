package EstadosDeClientes;
public class ComCadastro implements Estado{
  public void FazerPedido(){
    System.out.println("Pedido feito com sucesso");
  } 
  public void FazerCadastro(){
    System.out.println("Você já possui um cadastro");
  }
  public void Quitardividas(){
    System.out.println("você não possui dívidas ainda");
  }
}