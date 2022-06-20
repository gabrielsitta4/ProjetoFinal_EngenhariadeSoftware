package Pedidos;
import java.util.ArrayList;
import Produtos.Produto;


public class Pedido{
  static int ind=0;
  private int codpedido;
  private ArrayList<Produto> lista;

  public Pedido(int codigo,ArrayList<Produto> lista){
    inicializa(codigo,lista);
  }
  
  public Pedido(){
    inicializa(ind++);
  }

  public int getQuantidadeProdutos(){
    return lista.size();
  }
  
  public int getCodigo(){
    return codpedido;
  }

  public ArrayList<Produto> getProdutos(){
    return lista;
  }
  
  public Produto getProduto(int ind){
    return lista.get(ind);
  }
  
  public void adicionarProduto(Produto produto){
    lista.add(produto);
  }
  public void adicionarProduto(ArrayList<Produto> lista){
    this.lista.addAll(lista);
    }

  public double valorDoPedido(){
    double valor=0;
    for(Produto t:lista){
      valor+=t.getValor();
    }
      
    
    return valor;
  }
  
  private void inicializa(int cod,ArrayList<Produto> lista){
    this.codpedido=cod;
    this.lista=lista;
  }
  
  private void inicializa(int cod){
    this.codpedido=cod;
    this.lista=new ArrayList<Produto>();
  }
  
}