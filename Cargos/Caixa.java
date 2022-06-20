package Cargos;
import Cargos.Cargo;
import EstadosDeClientes.*;
import FormasDePagamentos.*;
import Pedidos.Pedido;

import java.util.*;
import Comandas.Comanda;
import EstadosDeClientes.*;
import Pessoas.*;
import Produtos.*;
import Relatorios.*;

public class Caixa implements Cargo{


  ArrayList<Cliente> clientes;
  Gerente gerente;
  RelatorioDeVenda vendas;
  public Caixa(ArrayList<Cliente> clientes,Gerente gerente,RelatorioDeVenda vendas){
    this.clientes=clientes;
    this.gerente=gerente;
    //O caixa precisa ter acesso ao estoque e aos clintes;
    this.vendas=vendas;
  }

  public void abrirComanda(Cliente cliente){
    try{
      cliente.abrirComanda();
      limparTela();
      System.out.println("Comanda Aberta com sucesso");
      print("codigo da comanda: "+cliente.obtemComandaAberta().getCodigo());
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
    try{
      cliente.fecharComanda();
      
      Scanner ler=new Scanner(System.in);
      int ind=0;
      print(cliente.obtemComandaAberta().descrisao());
      System.out.println("Deseja pagar com pix 0 ou cartão 1 ou dinheiro (caso default)");
      ind=ler.nextInt();
      
        double valor =cliente.obtemComandaAberta().valorDaComanda();

      for(Pedido pedido:cliente.obtemComandaAberta().getPedidos()){
        vendas.adicionar(pedido.getProdutos());
      }
      print("em caso de perda de comanda ou aperte 0");
      if(ler.nextInt()==0)
      valor+=10;
        switch(ind){
          case 0:
            cliente.quitardividas(new Pix(valor));
            break;
          case 1:
            cliente.quitardividas(new Cartao(valor));
            break;
          default:
            cliente.quitardividas(new Dinheiro(valor));
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
  
  public void fazerPedido(Comanda comanda){
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

  public void gerarNotificacao(Funcionario funcionario){
    Scanner ler=new Scanner(System.in);
    print("quer informar o gerente aperte 0:");
    if(ler.nextInt()==0){
      Scanner leitura=new Scanner(System.in);
      gerente.adicionarNotificao("nome :"+funcionario.getNome()+" cargo:"+this.descrisao()+" informa que: "+leitura.nextLine());
    }
  }

  public void gerarRelatorio(){
    print("não tem permissão pra gerar um relatório");
  }

  private void limparTela(){
    for(int i=0;i<20;i++)
      print("");
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
}