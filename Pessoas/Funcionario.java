package Pessoas;
//import Pessoas.Pessoa;
import Cargos.*;

public class Funcionario extends Pessoa{
  private int rg;
  private String endereco;
  private String email;
  private Cargo cargo;
  
  public Funcionario(String nome,int cpf,int telefone,int rg,String endereco,String email,Cargo cargo){
  this.cpf=cpf;
  this.nome=nome;
  this.telefone=telefone;
  this.rg=rg;
  this.endereco=endereco;
  this.email=email;
  this.cargo=cargo;
 }
  
  public String descrisao(){
    return "Nome: "+nome+" cpf: "+cpf+" Cargo: "+cargo.descrisao();
  }

  public int getCPF(){
    return cpf;
  }
  public void abrirComanda(Cliente cliente){
    
  }
  public void fecharComanda(){
    
  }
}