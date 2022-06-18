package Pessoas;
//import Pessoas.Pessoa;
import Cargos.*;
import Pessoas.*;
import Comandas.*;
import Produtos.*;

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

  public Funcionario(int cpf,int rg){
    this.cpf=cpf;
    this.rg=rg;
  }
  
  public String descrisao(){
    return "Nome: "+nome+" cpf: "+cpf+" Cargo: "+cargo.descrisao();
  }

  public int getCPF(){
    return cpf;
  }

  public int getRG(){
    return rg;
  }
 
  @Override
  public boolean equals(Object func){
      if(func instanceof Funcionario){
        return ((Funcionario)func).getCPF()==this.getCPF() && ((Funcionario)func).getRG()==this.getRG();
      }
    return false;
  }
  
  public void abrirComanda(Cliente cliente){
    cargo.abrirComanda(cliente);
  }
  public Cliente buscarCliente()throws Exception{
    return cargo.buscarCliente();
  }
  public Comanda buscarComandaPorCliente()throws Exception{
    return cargo.buscarComandaPorCliente(); 
  } 
  public void fecharComanda(Cliente cliente){
    cargo.fecharComanda(cliente);
  }
  public Cliente cadastrarCliente()throws Exception{
    return cargo.cadastrarCliente();
  }
  public Comanda buscarComandaCodigo(int codigo)throws Exception{
    return cargo.buscarComandaCodigo(codigo);
  }
  public void fazerPedido(Cliente cliente)throws Exception{
    cargo.fazerPedido(cliente);
  }
  public Funcionario buscarFuncionario()throws Exception{
    return cargo.buscarFuncionario();
  }
  public void demetirFuncionario(Funcionario funcionario){
    cargo.demetirFuncionario(funcionario);
  }
  public void cadastrarFuncionario(){
    cargo.cadastrarFuncionario();
  }
  public void repor(Produto produto){
    cargo.repor(produto);
  }
  public Produto buscarProduto()throws Exception{
    return cargo.buscarProduto();
  }
  public void cadastrarProduto(){
    cargo.cadastrarProduto();
  }

  
}