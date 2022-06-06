package EstadosDeClientes;
public class ComPendencia implements Estado{
  public void fazerPedido(){
    System.out.println("você não pode fazer pedidos, pois possuia pendencia");
  } 
  public void fazerCadastro(){
    System.out.println("Você já possui um cadastro");
  }
  public void quitardividas(){
    System.out.println("dívidas quitadas");
  }

  public String descrisao(){
    return "Cliente inadimplente";
  }
}