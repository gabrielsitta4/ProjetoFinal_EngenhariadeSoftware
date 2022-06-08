package FormasDePagamentos;

public class Pix implements FormaDePagamento{
  double valor;

  public Pix(){
    valor=0;
  }
  public Pix(double valor){
    this.valor=valor;
  }
  
  public void pagar(double valor){
    this.valor=valor;
  }
  
  public String descrisao (){
    return "Foi pago com PIX com o valor de "+valor;
  }

  public double getValorPagamento(){
    return valor;
  }
}