package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;
import EstadosDeClientes.*;
import FormasDePagamentos.*;
import java.util.*;
import Comandas.Comanda;
import EstadosDeClientes.*;

public class Caixa implements Cargo{


  ArrayList<Cliente> clientes;
  public Caixa(ArrayList<Cliente> clientes){
    this.clientes=clientes;
    //O caixa precisa ter acesso ao estoque e aos clintes;
  }

  public void menuDeOpcoes(){
    limparTela();
    print("Comandos que a caixa pode executar:");
    print("0 para sair ");
    print("1 para abrir uma comanda");
    print("2 para fechar uma comanda");
    print("3 para cadastrar um cliente");
    Scanner ler=new Scanner(System.in);
    switch(ler.nextInt()){
      case 0:
        print("saindo da tela");
        break;
      case 1:
        abrirComanda(buscarCliente());
        break;
      case 2:
        fecharComanda(buscarCliente());
        break;
      case 3:
        cadastrarCliente();
    }
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
  
  public Cliente buscarCliente(){
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
  
  public Comanda buscarComandaPorCliente(){
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
  }
  
  public Cliente cadastrarCliente(){
    limparTela();
    Scanner ler=new Scanner(System.in);
    System.out.println("Nome: ");
    String nome=ler.nextLine();
    System.out.println("CPF: ");
    int cpf=ler.nextInt();
    System.out.println("Telefone: ");
    int telefone=ler.nextInt();
    clientes.add(new Cliente(nome,cpf,telefone));
    return new Cliente(nome,cpf,telefone);
  }

  private void limparTela(){
    for(int i=0;i<20;i++)
      print("");
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
}