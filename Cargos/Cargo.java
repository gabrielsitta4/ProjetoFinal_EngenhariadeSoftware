package Cargos;
import Pessoas.Cliente;
import Comandas.Comanda;
import java.util.ArrayList;

public interface Cargo{
  public void abrirComanda(Cliente cliente,int codcomanda);
  public void fazerPedido(Comanda comanda);
  public String descrisao();
  public Cliente buscarCliente(ArrayList<Cliente> cliente);
  public Comanda buscarComandaPorCliente(ArrayList<Cliente> cliente);
  public void fecharComanda();
}