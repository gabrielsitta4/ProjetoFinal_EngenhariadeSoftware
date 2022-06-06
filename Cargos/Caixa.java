package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;
import EstadosDeClientes.*;
import java.util.ArrayList;
import Comandas.Comanda;
import EstadosDeClientes.*;

public class Caixa implements Cargo{
public void abrirComanda(Cliente cliente){}
  public void fazerPedido(Comanda comanda){}
  public String descrisao(){}
  public Cliente buscarCliente(ArrayList<Cliente> cliente){}
  public Comanda buscarComandaPorCliente(ArrayList<Cliente> cliente){}
  public void fecharComanda(Cliente cliente){}

 
}