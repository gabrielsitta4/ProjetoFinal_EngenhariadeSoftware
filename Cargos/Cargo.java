package Cargos;
import Pessoas.Cliente;
import Comandas.Comanda;
import java.util.ArrayList;
import Pessoas.*;
import Produtos.*;


public interface Cargo{

  public void abrirComanda(Cliente cliente);
  public Cliente buscarCliente()throws Exception;
  public Comanda buscarComandaPorCliente()throws Exception;
  public void fecharComanda(Cliente cliente);
  public Cliente cadastrarCliente()throws Exception;
  public Comanda buscarComandaCodigo(int codigo)throws Exception;

  public void fazerPedido(Comanda comanda)throws Exception;

  public Funcionario buscarFuncionario()throws Exception;
  public void demetirFuncionario(Funcionario funcionario);
  public void cadastrarFuncionario();

  public void repor(Produto produto);
  public Produto buscarProduto()throws Exception;
  public void cadastrarProduto();
  public String descrisao();
  public void gerarNotificacao(Funcionario funcionario);
}