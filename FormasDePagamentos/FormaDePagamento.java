package FormasDePagamentos;

public interface FormaDePagamento{
  public void pagar(double valor);
  public double getValorPagamento();
  public String descrisao ();
}