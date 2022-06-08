package Cargos;
import Pessoas.Cliente;
import Comandas.Comanda;
import java.util.ArrayList;

public interface Cargo{
  public void abrirComanda(Cliente cliente);
  public void fazerPedido(Cliente clinte);
  public String descrisao();
  public Cliente buscarCliente();
  public Comanda buscarComandaPorCliente();
  public void fecharComanda(Cliente cliente);
}