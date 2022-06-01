

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
    
    FazerCadastro();
  }
  
  public void Descrisao(){
    System.out.println("Nome do cliente: "+nome+" cpf: "+cpf);
  }

  public void FazerPedido(Pedido pedido){
    if(estado instanceof ComCadastro){
      ObtemComandaAberta().AdicionarPedido(pedido);
      estado.FazerPedido();
    }
      
  }
  
  public void FazerCadastro(){
    if(estado instanceof SemCadastro){
      estado.FazerCadastro();
      estado=new ComCadastro();
    }
  }
  
  public void Quitardividas(FormaDePagamento pag){
   if(estado instanceof ComPendencia){
     ObtemComandaAberta().QuitarComanda(pag);
     estado.Quitardividas();
     estado=new ComCadastro();
   } 
  }

  public void FecharComanda(){
    if(PossuiComandaDivida()){
      estado=new ComPendencia();
    }
  }
  
  public Comanda ObtemComandaAberta(){
    Comanda comanda;
    if(PossuiComandaDivida()){
      comanda=comandas.get(comandas.size()-1);
    }
    else{
      comandas.add(new Comanda());
      comanda=comandas.get(comandas.size()-1);
    }
    return comanda;
  }

  public boolean PossuiComandaDivida(){
    if(comandas.size()>0)
      return !comandas.get(comandas.size()-1).GetQuitada();
    else
      return false;
  }
}