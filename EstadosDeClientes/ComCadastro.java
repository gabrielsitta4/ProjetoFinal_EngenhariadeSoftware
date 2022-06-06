package EstadosDeClientes;
public class ComCadastro implements Estado{
  public void fazerPedido(){
    System.out.println("Pedido feito com sucesso");
  } 
  public void fazerCadastro(){
    System.out.println("Você já possui um cadastro");
  }
  public void quitardividas(){
    System.out.println("você não possui dívidas ainda");
  }
}