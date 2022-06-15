package Comandas;
import java.util.ArrayList;
import Pedidos.Pedido;
import FormasDePagamentos.*;

public class Comanda{
  static int ind=0;
  int codcomada;
  ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
  boolean quitada;
  FormaDePagamento forma;

  public Comanda(){
    incializar(ind++);
  } 
  
  public Comanda(int codcomanda){
    incializar(codcomanda);
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
  
  public void quitarComanda(FormaDePagamento pag)throws Exception{
    if(pag.getValorPagamento()==this.valorDaComanda()){
      quitada=true;
      forma=pag;
      
    }else
      throw new Exception("Valor de pagamento não corresponde ao valor da Comanda");
    
}

  public FormaDePagamento getFormaPagaemnto(){
    return forma;
  }
  
  private void incializar(int cod){
    quitada=false;
    pedidos=new ArrayList<Pedido>();
    this.codcomada=cod;
    forma=null;
  }
}