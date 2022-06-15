package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;
import Produtos.Produto;
import Pedidos.Pedido;
import Comandas.Comanda;
import EstadosDeClientes.*;
import java.util.*;

public class Garcom implements Cargo{
  ArrayList<Produto> estoque;
  ArrayList<Cliente> clientes;
  
  public Garcom(ArrayList<Produto> produtos,ArrayList<Cliente> clientes){
    this.estoque=produtos;
    this.clientes=clientes;
    //O caixa precisa ter acesso ao estoque e aos clintes;
  }

  public void menuDeOpcoes(){
    limparTela();
    print("Comandos que a caixa pode executar:");
    print("0 para sair ");
    print("1 para fazer pedido");
    Scanner ler=new Scanner(System.in);
    switch(ler.nextInt()){
      case 0:
        print("saindo da tela");
        break;
      case 1:
        fazerPedido(buscarCliente());
        break;
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

  
  public void fazerPedido(Cliente cliente){
    Pedido pedido = new Pedido();
    if(!(cliente.getEstado() instanceof ComCadastro)){
      throw new Exception("Cliente com cadastro com falha");
    }
    
    Scanner leitura = new Scanner(System.in);
    
    try{
      int ind=0;
      do{
        //mostra a seleção de produtos
        limparTela();
        menuMostraProdutos();
        print("Digite o codigo do produto ou digite -1 para sair");
        ind=leitura.nextInt();
        for(Produto t:estoque){
          if(t.getCodigo()==ind){
            print("Digite a quantidade");
            //metodo colocar no carinho não retira do estoque
            //mas deixa guardado esperando a confirmação
            pedido.adicionarProduto(t.colocarNoCarinho(leitura.nextInt()));
          }
        }
      }while(ind!=0);
      
      limparTela();
      print("aperte 1 para confirmar");
      if(leitura.nextInt()==1){
        ArrayList<Produto> produtos=new ArrayList<Produto>();
        for(int i=0;i<pedido.getQuantidadeProdutos();i++){
          produtos.addAll(estoque.get(pedido.getProduto(i).getCodigo()).venderProdutos(1));
          
        }
        pedido=new Pedido(pedido.getCodigo(),produtos);
        cliente.obtemComandaAberta().adicionarPedido(pedido);
        }
        
    }catch(Exception ex){
      limparTela();
      print(ex.getMessage());
      print("Permissão não concessida");
      
      
    }
  }
  
  public String descrisao(){
    return "Caixa";
  }
  
  public Cliente buscarCliente(){
    limparTela();
    Scanner ler=new Scanner(System.in);
    System.out.println("Informe seu cpf");
    int cpf=ler.nextInt();
    
    for(Cliente c:clientes){
      if(c.getCPF()==cpf){
        return c;
      }
    }
    throw new Exception("Cliente não cadastrado");
  }
  
  public Comanda buscarComandaPorCliente(){
    Scanner ler=new Scanner(System.in);
    Cliente cliente = buscarCliente();
    try{
      
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
     System.out.println("erro:"+ex);
      throw new Exception("Erro na busca da comanda do cliente: "+cliente.getCPF());
    }
  }
 
  private void menuMostraProdutos(){
    for(Produto t:estoque){
      t.descrisaoVenda();
    }
  }

  private void limparTela(){
    for(int i=0;i<20;i++)
      print("");
  }
  
  private void print(String conteudo){
    System.out.println(conteudo);
  }
}