package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;
import Produtos.*;
import java.util.*;
import Relatorios.RelatorioCompra;

import Comandas.*;
import Pessoas.*;

public class Repositor implements Cargo{

  ArrayList<Produto> produtos;
  Gerente gerente;
  Scanner ler ;
  RelatorioCompra compra;
  public Repositor(ArrayList<Produto> produto,Gerente gerente){
    this.produtos=produto;
    this.gerente=gerente;
    compra=gerente.getCompras();
    ler=new Scanner(System.in);
  }
  
  
  public void cadastrarProduto(){
    limpaTela();
    print("informe o valor do produto:");
    double valor=ler.nextFloat();
    Scanner lerString=new Scanner(System.in);
    print("informe a descrisão");
    String descrisao=lerString.nextLine();

    print("informe a fornecedor");
    String fornecedor=lerString.nextLine();
    
    
    print("quantidade");
    int quant=ler.nextInt();
    print("quantidade máxima");
    int quantidademaxima=ler.nextInt();
    Produto produto=new Produto(valor*1.15,descrisao,fornecedor,quant,quantidademaxima,valor);
    produtos.add(produto);
    compra.adicionar(produto.copia());
    
    print("produto cadastrado com sucesso");
  }

  public void repor(Produto produto){
    try{
      limpaTela();
      print("informe a quantidade: ");
      int quantidade=ler.nextInt();
      produto.reporProduto(quantidade);
      compra.adicionar(produto.copia(quantidade));
     print("Produto foi reposto");
    }catch(Exception ex){
      print(ex.getMessage());
    }
  }
  
  public Produto buscarProduto()throws Exception{
    limpaTela();
    mostraProduto();
    print("digite o codigo do produto");
    int ind=ler.nextInt();
    for(Produto t: produtos){
      if(t.getCodigo()==ind){
        return t;
      }
    }
    throw new Exception(" produto não encontrado");
    
  }

  
  public String descrisao(){
    return "Repositor"+" existem tantos produtos abaixo do limite: "+this.getProdutosAbaixoDoLimite().size();
  }

    public void abrirComanda(Cliente cliente){
      print("Cargo de repositor não tem permissão para executar essa função");
    }
  public Cliente buscarCliente()throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }
  public Comanda buscarComandaPorCliente()throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }
  public void fecharComanda(Cliente cliente){
    print("Cargo de repositor não tem permissão para executar essa função");
  }
  public Cliente cadastrarCliente()throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }
  public Comanda buscarComandaCodigo(int codigo)throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }

  public void fazerPedido(Comanda comanda)throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }

  public Funcionario buscarFuncionario()throws Exception{
    throw new Exception("Cargo de repositor não tem permissão para executar essa função");
  }
  public void demetirFuncionario(Funcionario funcionario){
    print("Cargo de repositor não tem permissão para executar essa função");
  }
  public void cadastrarFuncionario(){
    print("Cargo de repositor não tem permissão para executar essa função");
  }

  public void gerarNotificacao(Funcionario funcionario){
    limpaTela();
    print("Produtos abaixo do limite");
    for(Produto p:this.getProdutosAbaixoDoLimite()){
      print("produto "+p.getCodigo()+" está abaixo do limite, só tem essa quantidade "+p.getQuantidade());
    }
    
    print("deseja informar o gerente sobre os produtos em falta aperte 0");
    if(ler.nextInt()==0){
      String mensagem="O repositor "+funcionario.getNome()+" informa que os produtos estão abaixo do limite";  
      int ind=0;
        for(Produto p:this.getProdutosAbaixoDoLimite()){
          mensagem+="\nproduto "+p.getCodigo()+" está abaixo do limite, só tem essa quantidade "+p.getQuantidade();
          ind++;
      }
      if(ind>0){
        gerente.adicionarNotificao(mensagem);
      }
    }

    print("quer informar o gerente sobre algo mais aperte 0:");
    if(ler.nextInt()==0){
      Scanner leitura=new Scanner(System.in);
      gerente.adicionarNotificao("nome :"+funcionario.getNome()+" cargo:"+"Repositor"+" informa que: "+leitura.nextLine());
    }
  }

  public void gerarRelatorio(){
    print("Repositor não tem permissão pra gerar o relatório");
  }
  private ArrayList<Produto> getProdutosAbaixoDoLimite(){
    ArrayList<Produto> pr=new ArrayList<Produto>(); 
    for(Produto p:this.produtos){
        if(p.getQuantidade()*100/p.getQuantidadeMaxima()<=20.0){
          pr.add(p);
        }
      }
    return pr;
  }
  
  private void limpaTela(){
    for(int i=0;i<20;i++)
      print("");
  }
  

  private void mostraProduto(){
    for(Produto t: produtos){
     t.descrisaoCompleta();
    }
  }
  
  private void print(String conteudo){
    System.out.println(conteudo);
  }
}