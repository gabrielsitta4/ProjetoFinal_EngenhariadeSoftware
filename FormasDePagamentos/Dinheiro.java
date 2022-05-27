package FormasDePagamentos;

public class Dinheiro implements FormaDePagamento{
  double valor;

  public Dinheiro(){
    valor=0;
  }
  
  public void Pagar(double valor){
    this.valor=valor;
  }

  public double GetValorPagamento(){
    return valor;
  }
  
  public String Descrisao (){
    return "Foi pago com Dinheiro com o valor de "+valor;
  }
}