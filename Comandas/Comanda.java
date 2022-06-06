package Comandas;
import java.util.ArrayList;
import Pedidos.Pedido;
import FormasDePagamentos.*;

public class Comanda{

  int codcomada;
  ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
  boolean quitada;
  FormaDePagamento forma;

  public Comanda(int codcomanda){
    quitada=false;
    pedidos=new ArrayList<Pedido>();
    this.codcomada=codcomanda;
  } 
  
  public void adicionarPedido(Pedido pedido){
    pedidos.add(pedido);
  }

  public double valorDaComanda(){
    double valor =0;
    for(Pedido p : pedidos){
      valor+=p.valorDoPedido();
    }
    return valor;
  }

  public boolean getQuitada(){
    return quitada;
  }
  
  public void quitarComanda(FormaDePagamento pag){
    quitada=true;
    forma=pag;
  }
}