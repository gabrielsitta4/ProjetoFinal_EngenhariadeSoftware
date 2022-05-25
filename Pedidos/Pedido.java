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

  public void AdicionarProduto(Produto produto){
    lista.add(produto);
  }
  public void AdicionarProduto(ArrayList<Produto> lista){
    this.lista.addAll(lista);
    }

  public double ValorDoPedido(){
    double valor=0;
    for(Produto t:lista){
      valor+=t.GetValor();
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