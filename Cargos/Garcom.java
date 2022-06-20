package Cargos;
import Pessoas.*;
import Cargos.Cargo;
import Produtos.Produto;
import Pedidos.Pedido;
import Comandas.Comanda;
import EstadosDeClientes.*;
import java.util.*;

public class Garcom implements Cargo{
  ArrayList<Produto> estoque;
  ArrayList<Cliente> clientes;
  Gerente gerente;
  public Garcom(ArrayList<Produto> produtos,ArrayList<Cliente> clientes,Gerente gerente){
    this.estoque=produtos;
    this.clientes=clientes;
    //O caixa precisa ter acesso ao estoque e aos clintes;
    this.gerente=gerente;
  }

  
  public void fazerPedido(Comanda comanda)throws Exception{
    Pedido pedido = new Pedido();
    if(comanda.getQuitada()){
      throw new Exception("Comanda já quitadada");
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
      }while(ind!=-1);
      
      limparTela();
      print("aperte 1 para confirmar");
      if(leitura.nextInt()==1){
        ArrayList<Produto> produtos=new ArrayList<Produto>();
        for(int i=0;i<pedido.getQuantidadeProdutos();i++){
          produtos.addAll(estoque.get(pedido.getProduto(i).getCodigo()).venderProdutos(1));
          
        }
        pedido=new Pedido(pedido.getCodigo(),produtos);
        comanda.adicionarPedido(pedido);
        }
        
    }catch(Exception ex){
      limparTela();
      print(ex.getMessage());
      print("Permissão não concessida");
      
      
    }
  }
  
  public String descrisao(){
    return "Garçom";
  }
  
  public Cliente buscarCliente()throws Exception{
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
  
  public Comanda buscarComandaPorCliente()throws Exception{
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

  public void abrirComanda(Cliente cliente){
    print("Mande o cliente ao caixa para fazer o cadastro");
  }
 
  public void fecharComanda(Cliente cliente){
    print("Mande o clinte ao caixa");
  }
  
  public Cliente cadastrarCliente()throws Exception{
    throw new Exception("Garçom não pode cadastrar funcionário");
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



  public Funcionario buscarFuncionario()throws Exception{
    throw new Exception("Garçom porque se quer buscar os dados de um funcionário?");
  }
  public void demetirFuncionario(Funcionario funcionario){
    
    print("Garçom porque se quer demitir um funcionário?");
  
  }
  public void cadastrarFuncionario(){
     print("Garçom porque se quer cadastrar um funcionário?");
  }

  public void repor(Produto produto){
     print("Garçom se não pode repor os produtos");
  }
  public Produto buscarProduto()throws Exception{
    throw new Exception("Se não pode mexer no estoque");
  }

  public void cadastrarProduto(){
    print("Garçom não cadastra produto");
  }
  public void gerarNotificacao(Funcionario funcionario){
    Scanner ler =new Scanner(System.in);
    print("quer informar o gerente aperte 0:");
    if(ler.nextInt()==0){
      Scanner leitura=new Scanner(System.in);
      gerente.adicionarNotificao("nome :"+funcionario.getNome()+" cargo:"+this.descrisao()+" informa que: "+leitura.nextLine());
    }
  }

  public void gerarRelatorio(){
    print("não tem permissão pra gerar um relatório");
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