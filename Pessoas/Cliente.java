

package Pessoas;
import EstadosDeClientes.*;
import java.util.ArrayList;
import Comandas.Comanda;
import Pedidos.Pedido;
import FormasDePagamentos.*;


public class Cliente extends Pessoa{
  private Estado estado=new SemCadastro();
  ArrayList<Comanda> comandas=new ArrayList<Comanda>();

  public Cliente(String nome,int cpf,int telefone,Estado estado){
    this.nome=nome;
    this.cpf=cpf;
    this.telefone=telefone;
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

  public void abrirComanda(){
    if(estado instanceof ComCadastro){
      comandas.add(new Comanda());
      System.out.println("Comanda Aberta com sucesso");
    }else
      throw new Exception(estado.descrisao());
  }
  
  public void fazerPedido(Pedido pedido){
    if(estado instanceof ComCadastro){
      obtemComandaAberta().adicionarPedido(pedido);
      estado.fazerPedido();
    }
    else
      throw new Exception(estado.descrisao());
      
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
    
    if(possuiComandaDivida()){
     return comandas.get(comandas.size()-1);
    }else
      throw new Exception("Não possui comandas abertas");
      
  }

  public boolean possuiComandaDivida(){
    if(comandas.size()>0)
      return !comandas.get(comandas.size()-1).getQuitada();
    else
      return false;
  }
}