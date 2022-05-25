package EstadosDeClientes;
public class ComPendencia implements Estado{
  public void FazerPedido(){
    System.out.println("você não pode fazer pedidos, pois possuia pendencia");
  } 
  public void FazerCadastro(){
    System.out.println("Você já possui um cadastro");
  }
  public void Quitardividas(){
    System.out.println("dívidas quitadas");
  }
}