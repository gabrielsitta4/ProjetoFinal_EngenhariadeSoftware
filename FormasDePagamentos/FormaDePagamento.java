package FormasDePagamentos;

public interface FormaDePagamento{
  public void Pagar(double valor);
  public double GetValorPagamento();
  public String Descrisao ();
}