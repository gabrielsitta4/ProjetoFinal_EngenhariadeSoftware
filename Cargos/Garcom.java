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

  public void abrirComanda(Cliente cliente){
   System.out.println("Garçom não abre comanda, vá até o caixa seu nóia"); 
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
      System.out.println("Permissão não concessida");
      
      
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
    System.out.println("não existe Clinte Cadastrado com esse CFP");
    throw new Exception("Erro em relação ao garçom, não tem a permissão necessária para cadastrar cliente");
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
  
  public void fecharComanda(Cliente cliente){
    System.out.println("Garçom nãom pode fechar comanda, mande ao caixa");
  }
  

 
  private void menuMostraProdutos(){
    for(Produto t:estoque){
      t.descrisaoVenda();
    }
  }

  private void limparTela(){
    System("clear");
  }
}