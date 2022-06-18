package Cargos;
import Cargos.Cargo;
import EstadosDeClientes.*;
import FormasDePagamentos.*;
import java.util.*;
import Comandas.Comanda;
import EstadosDeClientes.*;
import Pessoas.*;
import Produtos.*;

public class Caixa implements Cargo{


  ArrayList<Cliente> clientes;
  public Caixa(ArrayList<Cliente> clientes){
    this.clientes=clientes;
    //O caixa precisa ter acesso ao estoque e aos clintes;
  }

  public void abrirComanda(Cliente cliente){
    try{
      cliente.abrirComanda();
      limparTela();
      System.out.println("Comanda Aberta com sucesso");
    }catch(Exception ex){
      System.out.println(ex);
    }
  }
  
  public String descrisao(){
    return "Caixa";
  }
  
  public Cliente buscarCliente()throws Exception{
    limparTela();
    Scanner ler=new Scanner(System.in);
    print("Informe seu cpf");
    int cpf=ler.nextInt();
    
    for(Cliente c:clientes){
      if(c.getCPF()==cpf){
        return c;
      }
    }
    throw new Exception("Erro ao buscar por cliente");
    
     
  }
  
  public Comanda buscarComandaPorCliente()throws Exception{
    Scanner ler=new Scanner(System.in);
    try{
      Cliente cliente = buscarCliente();
      limparTela();
      System.out.println("deseja buscar a comanda já aberta aperte 0");
      if(ler.nextInt()==0)
        return cliente.obtemComandaAberta();
      for(int i=0;i<cliente.getQuantidadeComandas();i++){
        System.out.println(i+" valor da comanda"+cliente.getComanda(i).valorDaComanda());
      }
       System.out.println("qual é o codigo da comanda: ");
        return cliente.getComanda(ler.nextInt());
    }catch(Exception ex){
     throw new Exception(ex);
    }
  }
  
  public void fecharComanda(Cliente cliente){
    limparTela();
    cliente.fecharComanda();
    
    Scanner ler=new Scanner(System.in);
    int ind=0;
    System.out.println("Deseja pagar com pix 0 ou cartão 1 ou dinheiro (caso default)");
    ind=ler.nextInt();
    try{
      double valor =cliente.obtemComandaAberta().valorDaComanda();
      switch(ind){
        case 0:
          cliente.obtemComandaAberta().quitarComanda(new Pix(valor));
          break;
        case 1:
          cliente.obtemComandaAberta().quitarComanda(new Cartao(valor));
          break;
        default:
          cliente.obtemComandaAberta().quitarComanda(new Dinheiro(valor));
      }
    }catch(Exception ex){
      print(ex.getMessage());
    }
  }
  
  public Cliente cadastrarCliente()throws Exception{
    limparTela();
    Scanner ler=new Scanner(System.in);
    System.out.println("Nome: ");
    String nome=ler.nextLine();
    System.out.println("CPF: ");
    int cpf=ler.nextInt();
    System.out.println("Telefone: ");
    int telefone=ler.nextInt();
    Cliente c=new Cliente(nome,cpf,telefone);
    if(!clientes.contains(c)){
      clientes.add(c);
      return c;
    }
    else
      throw new Exception("cliente já cadastrado");
  }

  public Comanda buscarComandaCodigo(int codigo) throws Exception{

    for(Cliente c:clientes){
      try{
        return c.getComandaPorCodigo(codigo);
      }catch(Exception ex){
        
      }
    }
    throw new Exception("Comanda não existe");
    
  }
  
  public void fazerPedido(Cliente cliente){
    print("Caixa não pode fazer pedido");
  }
  
 

  public Funcionario buscarFuncionario()throws Exception{
    throw new Exception("Caixa não pode buscar Funcionário");
  }
  
  public void demetirFuncionario(Funcionario funcionario){
    print("Caixa não pode demitir funcionário ");
  }
  
  public void cadastrarFuncionario(){
    print("Caixa não pode cadastrar funcionário ");
  }

  public void repor(Produto produto){
    print("Caixa não poderepor produtos ");
  }
  
  public Produto buscarProduto()throws Exception{
    throw new Exception("Caixa não pode buscar produtos");
  }

  public void cadastrarProduto(){
    print("Caixa não pode cadastrar produto");
  }

  
  private void limparTela(){
    for(int i=0;i<20;i++)
      print("");
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
}