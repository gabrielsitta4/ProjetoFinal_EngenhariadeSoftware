

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

  public Cliente(int cpf){
    this.cpf=cpf;
  }
  
  @Override
  public boolean equals(Object cliente){
    if(cliente instanceof Cliente)
      return this.getCPF()==((Cliente)cliente).getCPF();
    else
      return false;
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
      estado=new ComPendencia();
    }else
      throw new Exception("cliente inadimplemte");
  }
  
  public void fazerPedido(Pedido pedido)throws Exception{
    try {
     obtemComandaAberta().adicionarPedido(pedido);
    }catch(Exception ex){
      throw new Exception(ex.getMessage());
    }  
      
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

  public Comanda getComandaPorCodigo(int codigo)throws Exception{
    
    if(possuiComanda(codigo)){
      for(Comanda c: comandas){
        if(c.getCodigo()==codigo)
          return c;
      }
    }
    
     throw new Exception("Cliente não possui comanda");
    
  }
  
  public boolean possuiComanda(int cod){
    return comandas.contains(new Comanda(cod));
  }

  
  public void fecharComanda(){
    if(possuiComandaDivida()){
      estado=new ComPendencia();
      
    }
  }
  
  public Comanda obtemComandaAberta()throws Exception{
    
    if(possuiComandaDivida()){
      for(Comanda c: comandas){
        if(!c.getQuitada()){
          return c;
        }    
      }
    }
    throw new Exception("Não possui comandas abertas");
      
  }

  public boolean possuiComandaDivida(){
    boolean verifica=false;
    if(comandas.size()>0)
      for(Comanda c: comandas){
        if(!c.getQuitada()){
          verifica=true;
          break;
        }    
      }
    return verifica;
  }
}