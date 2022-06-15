package Cargos;
import Pessoas.*;
import java.util.*;

import Cargos.*;
import Produtos.*;


public class Gerente implements Cargo{

  Scanner ler;
  ArrayList<Funcionario> funcionarios;
  ArrayList<Produto> produtos;
  ArrayList<Cliente> clientes;
  public Gerente(ArrayList<Funcionario> funcionarios,ArrayList<Produto> produtos,ArrayList<Cliente> cliente){
    this.funcionarios=funcionarios;
    this.produtos=produtos;
    this.clientes=cliente;
   ler=new Scanner(System.in);
  }
  
  public void menuDeOpcoes(){
    limpaTela();
    print("0 para sair ");
    print("1 para cadastrar funcionário");
    print("2 demitir");
    
    Scanner ler=new Scanner(System.in);
    try{
    switch(ler.nextInt()){
      case 0:
        print("saindo");
        break;
      case 1:
        cadastrarFuncionario();
        break;
      case 2: 
        demetirFuncionario(buscarFuncionario());
        break;
    }}catch(Exception ex){
      print(ex.getMessage());
    }
  }
  
  public String descrisao(){
    return "Gerente";
  }

  public Funcionario buscarFuncionario()throws Exception{
    limpaTela();
    print("informe o cpf: ");
    int cpf=ler.nextInt();
    for(Funcionario t: funcionarios){
      if(t.getCPF()==cpf)
        return t;
    }
    throw new Exception("Funcionário não cadastrado");
  }

  public void demetirFuncionario(Funcionario funcionario){
    limpaTela();
    print("Deseja demetir o funcionário "+funcionario.descrisao()+" aperte 0");
    if(ler.nextInt()==0){
      funcionarios.remove(funcionario);
    }
    
  }
  
  public void cadastrarFuncionario(){
    limpaTela();
    print("nome do funcionário");
    String nome=ler.nextLine();
    print("CPF do funcionário");
    int cpf=ler.nextInt();
    print("telefone do funcionário");
    int telefone=ler.nextInt();
    print("RG do funcionário");
    int rg=ler.nextInt();
    print("Endereço do funcionário");
    String end=ler.nextLine();
    print("Email do funcionário");
    String email=ler.nextLine();


    print("Caixa 0");
    print("Garçom 1");
    print("Repositor 2");
    print("Gerente 3");

    Cargo cargo;
    
    switch(ler.nextInt()){
      case 0:
        cargo=new Caixa(clientes);
        break;
      case 3 :
        cargo=new Gerente(funcionarios,produtos,clientes);
        break;
      case 2 :
        cargo=new Repositor(produtos);
        break ;
      case 1 :
        cargo=new Garcom(produtos,clientes);
        break;
      default:
          cargo =new  Garcom(produtos,clientes);
        break;
    }
    
    if(funcionarios.add( new Funcionario(nome,cpf, telefone, rg, end, email, cargo))){
      print("funcionário  cadastrado com sucesso");
    }
  }
  
  private void limpaTela(){
    for(int i=0;i<20;i++)
      print("");
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
  
}