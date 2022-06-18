package Cargos;
import Pessoas.Cliente;
import Cargos.Cargo;
import Produtos.*;
import java.util.*;
import Comandas.*;
import Pessoas.*;

public class Repositor implements Cargo{

  ArrayList<Produto> produtos;
  Scanner ler ;
  public Repositor(ArrayList<Produto> produto){
    this.produtos=produto;
    ler=new Scanner(System.in);
  }
  public void menuDeOpcoes(){
    limpaTela();
    print("0 sair ");
    print("1 cadastrar novo produto");
    print("2 Repor produtos");
    try{
    switch(ler.nextInt()){
      case 0:
        print("Saindo");
        break;
      case 1:
        cadastrarProduto();
        break;
      case 2:
        repor(buscarProduto());
        break;
    }
    }catch(Exception ex){
      print(ex.getMessage());
    }
  
  }
  public void cadastrarProduto(){
    limpaTela();
    print("informe o valor do produto:");
    double valor=ler.nextFloat();
    print("informe a descrisão");
    String descrisao=ler.nextLine();
    print("Fornecedor: ");
    String fornecedor=ler.nextLine();
    print("quantidade");
    int quant=ler.nextInt();
    print("quantidade máxima");
    int quantidademaxima=ler.nextInt();
    produtos.add(new Produto(valor,descrisao,fornecedor,quant,quantidademaxima));
    print("produto cadastrado com sucesso");
  }

  public void repor(Produto produto){
    limpaTela();
    print("informe a quantidade: ");
    int quantidade=ler.nextInt();
    produto.reporProduto(quantidade);
    print("Produto foi reposto");
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
    return "Repositor";
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

  public void fazerPedido(Cliente cliente)throws Exception{
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