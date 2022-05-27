package FormasDePagamentos;

public class Pix implements FormaDePagamento{
  double valor;

  public Pix(){
    valor=0;
  }
  
  public void Pagar(double valor){
    this.valor=valor;
  }
  
  public String Descrisao (){
    return "Foi pago com PIX com o valor de "+valor;
  }

  public double GetValorPagamento(){
    return valor;
  }
}