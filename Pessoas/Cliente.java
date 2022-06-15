

package Pessoas;
import EstadosDeClientes.*;
import java.util.*;
import java.lang.*;
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
  
  public Cliente(String nome ,int cpf,int telefone){
    this.nome=nome;
    this.cpf=cpf;
    this.telefone=telefone;
    
    fazerCadastro();
  }

  public int getCPF(){
    return cpf;
  }
  
  public String descrisao(){
   return ("Nome do cliente: "+nome+" cpf: "+cpf);
  }

  public Estado getEstado(){
    return estado;
  }

  public void abrirComanda()throws Exception{
    if(estado instanceof ComCadastro){
      comandas.add(new Comanda());
    }else
      throw new Exception(estado.descrisao());
  }
  
  public void fazerPedido(Pedido pedido)throws Exception{
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
  
  public void quitardividas(FormaDePagamento pag)throws Exception{
   try{
    if(estado instanceof ComPendencia){
     obtemComandaAberta().quitarComanda(pag);
     estado.quitardividas();
     estado=new ComCadastro();
   } 
   }catch(Exception ex){
     throw ex;
   }
  }

  public int getQuantidadeComandas(){
    return comandas.size();
  }

  public Comanda getComanda(int ind){
    return comandas.get(ind);
  }

  

  public void fecharComanda(){
    if(possuiComandaDivida()){
      estado=new ComPendencia();
      
    }
  }
  
  public Comanda obtemComandaAberta()throws Exception{
    
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