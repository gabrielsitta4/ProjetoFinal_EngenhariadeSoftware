package Pessoas;
//import Pessoas.Pessoa;
import Cargos.*;
import Pessoas.*;
import Comandas.*;
import Produtos.*;

public class Funcionario extends Pessoa{
  private int rg;
  private String endereco;
  private String senha;
  private String email;
  private Cargo cargo;
  
 
  public Funcionario(String nome,int cpf,int telefone,int rg,String endereco,String email,Cargo cargo,String senha){
  this.cpf=cpf;
  this.nome=nome;
  this.telefone=telefone;
  this.rg=rg;
  this.endereco=endereco;
  this.email=email;
  this.cargo=cargo;
  this.senha=senha;
 }

  public Funcionario(int cpf,int rg){
    this.cpf=cpf;
    this.rg=rg;
  }

  public Funcionario(int cpf,String senha){
    this.cpf=cpf;
    this.senha=senha;
  }

  public String descrisao(){
    return "Nome: "+nome+" cpf: "+cpf+" Cargo: "+cargo.descrisao();
  }
  public String getNome(){
    return nome;
  }

  public int getCPF(){
    return cpf;
  }

  public int getRG(){
    return rg;
  }

  public boolean verificaSenha(String senha){
    return this.senha.equals(senha);
  }
  @Override
  public boolean equals(Object func){
      if(func instanceof Funcionario){
        return ((Funcionario)func).getCPF()==this.getCPF(); 
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
  public void fazerPedido(Comanda comanda)throws Exception{
    cargo.fazerPedido(comanda);
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
  public void gerarNotificacao(){
    cargo.gerarNotificacao(this);
  }

  public void gerarRelatorio(){
    cargo.gerarRelatorio();
  }
   
}