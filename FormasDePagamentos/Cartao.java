package FormasDePagamentos;

public class Cartao implements FormaDePagamento{
  double valor;

  public Cartao(){
    valor=0;
  }
  
  public void pagar(double valor){
    this.valor=valor;
  }

  public double getValorPagamento(){
    return valor;
  }
  
  public String descrisao (){
    return "Foi pago com Cartão com o valor de "+valor;
  }
}