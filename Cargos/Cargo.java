package Cargos;
import Pessoas.Cliente;
import Comandas.Comanda;
import java.util.ArrayList;

public interface Cargo{

  public void abrirComanda(Cliente cliente);
  public Cliente buscarCliente();
  public Comanda buscarComandaPorCliente();
  public void fecharComanda(Cliente cliente);
  public Cliente cadastrarCliente();

  public void fazerPedido(Cliente cliente);
  public Comanda buscarComandaPorCliente();

  public Funcionario buscarFuncionario();
  public void demetirFuncionario(Funcionario funcionario);
  public void cadastrarFuncionario();

  public void repor(Produto produto);
  public Produto buscarProduto()
  
  public void menuDeOpcoes();
  public String descrisao();
}