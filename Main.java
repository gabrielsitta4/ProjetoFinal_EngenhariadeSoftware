import Cargos.Caixa;
import EstadosDeClientes.*;
import Pessoas.*;
import FormasDePagamentos.*;


class Main {
  public static void main(String[] args) {
    Dinheiro d=new Dinheiro();  
    d.Pagar(10.52);
    d.Descrisao();
  }
}