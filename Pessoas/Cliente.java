

package Pessoas;
import EstadosDeClientes.*;
import java.util.ArrayList;
import Comandas.Comanda;
import Pedidos.Pedido;
import FormasDePagamentos.*;

public class Cliente extends Pessoa{
  private Estado estado=new SemCadastro();
  ArrayList<Comanda> comandas=new ArrayList<Comanda>();

  public Cliente(String nome,int cpf,Estado estado){
    this.nome=nome;
    this.cpf=cpf;
    this.estado=estado;
  }
  
  public Cliente(String nome ,int cpf){
    this.nome=nome;
    this.cpf=cpf;
    
    fazerCadastro();
  }
  
  public void descrisao(){
    System.out.println("Nome do cliente: "+nome+" cpf: "+cpf);
  }

  public Estado getEstado(){
    return estado;
  }
  
  public void fazerPedido(Pedido pedido){
    if(estado instanceof ComCadastro){
      obtemComandaAberta().adicionarPedido(pedido);
      estado.fazerPedido();
    }
      
  }
  
  public void fazerCadastro(){
    if(estado instanceof SemCadastro){
      estado.fazerCadastro();
      estado=new ComCadastro();
    }
  }
  
  public void quitardividas(FormaDePagamento pag){
   if(estado instanceof ComPendencia){
     obtemComandaAberta().quitarComanda(pag);
     estado.quitardividas();
     estado=new ComCadastro();
   } 
  }

  public void fecharComanda(){
    if(possuiComandaDivida()){
      estado=new ComPendencia();
    }
  }
  
  public Comanda obtemComandaAberta(){
    Comanda comanda;
    if(possuiComandaDivida()){
      comanda=comandas.get(comandas.size()-1);
    }
    else{
      comandas.add(new Comanda());
      comanda=comandas.get(comandas.size()-1);
    }
    return comanda;
  }

  public boolean possuiComandaDivida(){
    if(comandas.size()>0)
      return !comandas.get(comandas.size()-1).GetQuitada();
    else
      return false;
  }
}