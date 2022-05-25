import Cargos.Caixa;
import EstadosDeClientes.*;
import Pessoas.*;


class Main {
  public static void main(String[] args) {
    Cliente p=new Cliente("paula",10202010,new SemCadastro());
    p.Descrisao();
    p.FazerPedido();
  }
}