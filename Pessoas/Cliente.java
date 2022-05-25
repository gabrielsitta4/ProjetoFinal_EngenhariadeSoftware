

package Pessoas;
import EstadosDeClientes.*;

public class Cliente extends Pessoa{
  private Estado estado;

  public Cliente(String nome,int cpf,Estado estado){
    this.nome=nome;
    this.cpf=cpf;
    this.estado=estado;
  }
  
  public void Descrisao(){
    System.out.println("Nome do cliente: "+nome+" cpf: "+cpf);
  }

  public void FazerPedido(){
    if(estado.getClass()==new ComCadastro().getClass()){
      System.out.println("pode fazer pedido");
    }
      
  }
  public void FazerCadastro(){
    
  }
  public void Quitardividas(){
    
  }

}