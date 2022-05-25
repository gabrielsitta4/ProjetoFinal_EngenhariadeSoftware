package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;

public class Repositor implements Cargo{
  public void AbrirComanda(Cliente cliente){
    System.out.println("Repositor não pode abrir comandas");
}
  public String Descrisao(){
    return "Repositor";
  }
  public void FecharComanda(){
    System.out.println("Repositor não pode fechar comandas");
  }
}