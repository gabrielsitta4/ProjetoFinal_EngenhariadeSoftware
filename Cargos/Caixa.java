package Cargos;
import Pessoas.Cliente;
import Produtos.Produto;
import Cargos.Cargo;
import EstadosDeClientes.*;
import Pedidos.Pedido;
import FormasDePagamentos.*;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;
import Comandas.Comanda;
import EstadosDeClientes.*;

public class Caixa implements Cargo{

  ArrayList<Produto> estoque;
  ArrayList<Cliente> clientes;
  public Caixa(ArrayList<Produto> produtos,ArrayList<Cliente> clientes){
    this.estoque=produtos;
    this.clientes=clientes;
    //O caixa precisa ter acesso ao estoque e aos clintes;
  }

  public void abrirComanda(Cliente cliente){
    try{
      cliente.abrirComanda();
      limparTela();
      System.out.println("Comanda Aberta com sucesso");
      System.out.println("Fazer o pedido aperte 0")
      Scanner ler =new Scanner(System.in);
      if(ler.nextInt()==0)
        fazerPedido(cliente);
    }catch(Exception ex){
      System.out.println(ex);
    }
  }
  
  public void fazerPedido(Cliente clinte){
    Pedido pedido = new Pedido();
    Scanner leitura = new Scanner(System.in);
    
    try{
      int ind=0;
      do{
        //mostra a seleção de produtos
        limparTela();
        menuMostraProdutos();
        System.out.println("Digite o codigo do produto ou digite -1 para sair");
        ind=leitura.nextInt();
        for(Produto t:estoque){
          if(t.getCodigo()==ind){
            System.out.println("Digite a quantidade");
            //metodo colocar no carinho não retira do estoque
            //mas deixa guardado esperando a confirmação
            pedido.adicionarProduto(t.colocarNoCarinho(leitura.nextInt()));
          }
        }
      }while(ind!=0);
      
      limparTela();
      System.out.println("aperte 1 para confirmar");
      if(leitura.nextInt()==1){
        ArrayList<Produto> produtos=new ArrayList<Produto>();
        for(int i=0;i<pedido.getQuantidadeProdutos();i++){

          produtos.addAll(estoque.get(pedido.getProduto(i).getCodigo()).venderProdutos(1));
          
        }
        pedido=new Pedido(pedido.getCodigo(),produtos);
        clinte.obtemComandaAberta().adicionarPedido(pedido);
        }
        
    }catch(Exception ex){
      limparTela();
      System.out.println(ex);
      if(cliente.getEstado instanceof SemCadastro ){
        cliente=cadastarCliente();
        System.out.println("deseja fazer o pedido 0")
        if(leitura.nextInt()==0){
          abrirComanda(cliente);
          clinte.obtemComandaAberta().adicionarPedido(pedido);
        }
      }
      
      
    }
  }
  
  public String descrisao(){
    return "Caixa";
  }
  public Cliente buscarCliente(){
    limparTela();
    Scanner ler=new Scanner(System.in);
    System.out.println("Informe seu cpf")
    int cpf=ler.nextInt();
    
    for(Cliente c:clientes){
      if(c.getCPF()==cpf){
        return c;
      }
    }
    System.out.println("não existe Clinte Cadastrado com esse CFP");
    System.out.println("Deseja se cadastrar aperte 0");
    if(ler.nextInt()==0){
      return cadastrarCliente();
    }else
      throw new Exception("Erro ao buscar por cliente com cpf "+cpf );
    
     
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
  
  private void menuMostraProdutos(){
    for(Produto t:estoque){
      t.descrisaoVenda();
    }
  }

  private void limparTela(){
    if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
  }
 
}