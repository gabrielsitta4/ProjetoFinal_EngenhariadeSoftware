package FormasDePagamentos;

public class Cartao implements FormaDePagamento{
  double valor;

  public Cartao(){
    valor=0;
  }
  
  public void Pagar(double valor){
    this.valor=valor;
  }

  public double GetValorPagamento(){
    return valor;
  }
  
  public String Descrisao (){
    return "Foi pago com Cartão com o valor de "+valor;
  }
}