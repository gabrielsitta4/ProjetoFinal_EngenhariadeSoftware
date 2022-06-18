import Cargos.Caixa;
import EstadosDeClientes.*;
import Pessoas.*;
import FormasDePagamentos.*;
import java.util.*;

import Cargos.*;
import Comandas.*;
import EstadosDeClientes.*;
import Pedidos.*;
import Produtos.*;



class Main {
  
  public static void main(String[] args) {
    ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    ArrayList<Funcionario> funcionarios=new ArrayList<Funcionario>();
    ArrayList<Produto> produtos=new ArrayList<Produto>();
    
   
    funcionarios.add(new Funcionario("adm",000,000,0000,"adm","adm"+'@'+"gmail.com",new Gerente(funcionarios,produtos,clientes)));
    
    funcionarios.add(new Funcionario("caixa",1,000,1,"adm","adm"+'@'+"gmail.com",new Caixa(clientes)));
    funcionarios.add(new Funcionario("caixa",2,000,2,"adm","adm"+'@'+"gmail.com",new Garcom(produtos,clientes)));
    funcionarios.add(new Funcionario("caixa",3,000,3,"adm","adm"+'@'+"gmail.com",new Repositor(produtos)));


    
    Funcionario funcionario=funcionarios.get(0);
    int ind=-1;
    Scanner ler = new Scanner(System.in);
    while(ind!=0){
      print(funcionario.descrisao());
      print("selecionae :");
      print("0 para sair");
      print("1 abrirComanda");
      print("2 buscarCliente");
      print("3 buscarComandaPorCliente");
      print("4 fecharComanda");
      print("5 cadastrarCliente");
      print("6 buscarComandaCodigo");
      print("7 fazerPedido");
      print("8 buscarFuncionario");
      print("9 demetirFuncionario");
      print("10 cadastrarFuncionario");
      print("11 repor");
      print("12 Mudar de funcionario");
      print("13 cadastras produto");
      print("14 buscar produto");
      ind=ler.nextInt();
       limpaTela();
      try{
        
        switch(ind){
          
          case 1:
            funcionario.abrirComanda(funcionario.buscarCliente());
            break;
          case 2:
            print(funcionario.buscarCliente().descrisao());
            break;
          case 3:
            print(funcionario.buscarComandaPorCliente().descrisao());
            break;
          case 4:
            funcionario.fecharComanda(funcionario.buscarCliente());
            break;
          case 5:
            funcionario.cadastrarCliente();
            break;
          case 6:
            print("digite o codigo da comanda");
              funcionario.buscarComandaCodigo(ler.nextInt()).descrisao();
            break;
          case 7:
            funcionario.fazerPedido(funcionario.buscarCliente());
           break;
          case 8:
            funcionario.demetirFuncionario(funcionario.buscarFuncionario());
            break;
          case 9:
            funcionario.demetirFuncionario(funcionario.buscarFuncionario());
            break;
          case 10:
            funcionario.cadastrarFuncionario();
            break;
          case 11:
            funcionario.repor(funcionario.buscarProduto());
            break;
          case 12:
            funcionario=mudarDeFuncionario(funcionarios);
           break;
          case 13:
            funcionario.cadastrarProduto();
            break;

          case 14:
            funcionario.buscarProduto();
            break;
       }
       
      
      }catch(Exception ex){
        print(ex.getMessage());
      }
      if(ind==0)
        break;

    }
    
  }
  public static Funcionario mudarDeFuncionario(ArrayList<Funcionario> funcs)throws Exception{
    limpaTela();
    Scanner ler=new Scanner(System.in);
    print("Informe o cpf: ");
      int cpf=ler.nextInt();
    print("Informe o RG: ");
      int rg=ler.nextInt();
    if(funcs.contains(new Funcionario(cpf,rg))){
      print("funcionario achado");
     return funcs.get(funcs.indexOf(new Funcionario(cpf,rg)));
    }
    else
      throw new Exception("não encontrado o funcionario");
    
  }
  
  public static void print(String conteudo){
    System.out.println(conteudo);
  }

  public static void limpaTela(){
    for(int i=0;i<20;i++){
      print("");
    }
  }
}