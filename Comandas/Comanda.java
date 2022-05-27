package Comandas;
import java.util.ArrayList;
import Pedidos.Pedido;
import FormasDePagamentos.*;

public class Comanda{
  static int ind;
  int codcomada;
  ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
  boolean quitada;
  FormaDePagamento forma;

  public Comanda(){
    quitada=false;
    pedidos=new ArrayList<Pedido>();
    codcomada=ind++;
  } 
  
  public void AdicionarPedido(Pedido pedido){
    pedidos.add(pedido);
  }

  public double ValorDaComanda(){
    double valor =0;
    for(Pedido p : pedidos){
      valor+=p.ValorDoPedido();
    }
    return valor;
  }

  public void QuitarComanda(FormaDePagamento pag){
    quitada=true;
    forma=pag;
  }
}