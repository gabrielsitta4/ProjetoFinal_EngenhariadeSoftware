package Cargos;
import Pessoas.*;
import java.util.*;
import Comandas.*;
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
    try{
      limpaTela();
      print("Deseja demetir o funcionário "+funcionario.descrisao()+" aperte 0");
      if(ler.nextInt()==0){
        funcionarios.remove(funcionario);
      }
    }catch(Exception ex){
      print("funcionário não achado");
    }
   
  }
  
  public void cadastrarFuncionario(){
    limpaTela();
    Scanner lerString =new Scanner(System.in);
    print("nome do funcionário");
    String nome=lerString.nextLine();
    print("CPF do funcionário");
    int cpf=ler.nextInt();
    print("telefone do funcionário");
    int telefone=ler.nextInt();
    print("RG do funcionário");
    int rg=ler.nextInt();
    print("Endereço do funcionário");
    String end=lerString.nextLine();
    print("Email do funcionário");
    String email=lerString.nextLine();
    print("Digite a senha do usuário");
    String senha=lerString.nextLine();

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

    Funcionario func= new Funcionario(nome,cpf, telefone, rg, end, email, cargo,senha); 

    if(funcionarios.contains(func)){
      print("Já existe um funcionário");
    }
    else{
      print("confirmar aperte 0");
      if(ler.nextInt()==0){
        funcionarios.add(func);
        print("funcionário  cadastrado com sucesso");
      }else
        print("Ok patrão, funcionário não cadastrado");
    }
  }

   public void abrirComanda(Cliente cliente){
     print("Chame um caixa");
   }
  public Cliente buscarCliente()throws Exception{
    throw new Exception("Gerente se não se precisa fazer isso");
  }
  public Comanda buscarComandaPorCliente()throws Exception{
    throw new Exception("Gerente se não se precisa fazer isso");
  }
  public void fecharComanda(Cliente cliente){
    print("Gerente se não se precisa fazer isso");
  }
  public Cliente cadastrarCliente()throws Exception{
    throw new Exception("Chama um caixa para executar essa funçao");
  }
  public Comanda buscarComandaCodigo(int codigo)throws Exception{
    throw new Exception("Cargo de gerente não tem permissão pra fazer isso");
  }

  public void fazerPedido(Comanda comanda)throws Exception{
    print("Cargo de gerente não tem permissão pra fazer isso");
  }


  public void repor(Produto produto){
    print("Cargo de gerente não tem permissão pra fazer isso");
  }
  public Produto buscarProduto()throws Exception{
    throw new Exception("Cargo de gerente não tem permissão pra fazer isso");
  }
  public void cadastrarProduto(){
    print("caixa não cadastra produto");
  }
  
  private void limpaTela(){
    for(int i=0;i<20;i++)
      print("");
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
  
}