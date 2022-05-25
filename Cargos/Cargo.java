package Cargos;
import Pessoas.Cliente;

public interface Cargo{
  public void AbrirComanda(Cliente cliente);
  public String Descrisao();
  public void FecharComanda();
}