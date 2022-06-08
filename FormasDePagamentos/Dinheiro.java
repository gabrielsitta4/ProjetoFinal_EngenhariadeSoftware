package FormasDePagamentos;

public class Dinheiro implements FormaDePagamento{
  double valor;

  public Dinheiro(){
    valor=0;
  }

  public Dinheiro(double valor){
    this.valor=valor;
  }
  
  public void pagar(double valor){
    this.valor=valor;
  }

  public double getValorPagamento(){
    return valor;
  }
  
  public String descrisao (){
    return "Foi pago com Dinheiro com o valor de "+valor;
  }
}