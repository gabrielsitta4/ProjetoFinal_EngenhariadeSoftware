import Cargos.Caixa;
import EstadosDeClientes.*;
import Pessoas.*;
import FormasDePagamentos.*;
import java.util.*;

import Cargos.*;
import Comandas.*;
import EstadosDeClientes.*;
import Pedidos.*;
import Relatorios.*;
import Produtos.*;



class Main {
  
  public static void main(String[] args) {
    ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    ArrayList<Funcionario> funcionarios=new ArrayList<Funcionario>();
    ArrayList<Produto> produtos=new ArrayList<Produto>();
    
   Gerente gerente=new Gerente(funcionarios,produtos,clientes);
    funcionarios.add(new Funcionario("adm",000,000,0000,"adm","adm"+'@'+"gmail.com",gerente,"1"));
    
    funcionarios.add(new Funcionario("caixa",1,000,1,"adm","adm"+'@'+"gmail.com",new Caixa(clientes,gerente,gerente.getVendas()),"10"));
    funcionarios.add(new Funcionario("caixa",2,000,2,"adm","adm"+'@'+"gmail.com",new Garcom(produtos,clientes,gerente),"10"));
    funcionarios.add(new Funcionario("caixa",3,000,3,"adm","adm"+'@'+"gmail.com",new Repositor(produtos,gerente),"10"));

    clientes.add(new Cliente("joão",4,151515,new ComCadastro()));


    
    Funcionario funcionario=funcionarios.get(0);
    
    int ind=-1;
    Scanner ler = new Scanner(System.in);
    while(ind!=0){
      print(funcionario.descrisao());
      print("selecionae :");
      print("0 para sair");
      print("1 abrir Comanda");
      print("2 buscarCliente");
      print("3 buscar Comanda Por Cliente");
      print("4 fechar Comanda");
      print("5 cadastrar Cliente");
      print("6 buscar Comanda por Codigo");
      print("7 fazer Pedido");
      print("8 buscar Funcionario");
      print("9 demetir Funcionario");
      print("10 cadastrar Funcionario");
      print("11 repor");
      print("12 Mudar de funcionario");
      print("13 cadastras produto");
      print("14 buscar produto");
      print("15 notificações");
      print("16 gerar relatorio");
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
           print("Digite o cogiogo da comanda"); funcionario.fazerPedido(funcionario.buscarComandaCodigo(ler.nextInt()));
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
          case 15:
            funcionario.gerarNotificacao();
            break;
          case 16:
              funcionario.gerarRelatorio();
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
    Scanner lerString=new Scanner(System.in);
    print("Informe o cpf: ");
      int cpf=ler.nextInt();
  
    print("Informe a senha: ");
      String senha=lerString.nextLine();
    print(cpf +senha);

    if(funcs.contains(new Funcionario(cpf,senha))){
      print("funcionario achado");
       Funcionario func = funcs.get(funcs.indexOf(new Funcionario(cpf,senha)));
      if(func.verificaSenha(senha))
        return func;
      else
        throw new Exception("Senha incorreta");
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