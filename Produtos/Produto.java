package Produtos;
import java.util.ArrayList;

public class Produto{
  static int ind=0;
  private int codproduto;
  private double valor;
  private double valorDeCompra;
  private String descrisao;
  private String fornecedor;
  private int quantidade;
  private int quantidademaxima;

  public Produto(int codigo,double valor,String descrisao,String fornecedor,int quant,int quantidademaxima,double valorCompra){
    inicaliza(codigo,valor,descrisao,fornecedor,quant,quantidademaxima);
    this.valorDeCompra=valorCompra;
  }
  
  public Produto(double valor,String descrisao,String fornecedor,int quant,int quantidademaxima,double valorCompra){
    inicaliza(ind++,valor,descrisao,fornecedor,quant,quantidademaxima);
    this.valorDeCompra=valorCompra;
  }

  public Produto(int codigo){
    this.codproduto=codigo;
  }

  public Produto copia(){
    return new Produto(codproduto , valor, descrisao, fornecedor, quantidade, quantidademaxima, valorDeCompra);
  }

public Produto copia(int quant){
    return new Produto(codproduto , valor, descrisao, fornecedor, quant, quantidademaxima, valorDeCompra);
  }
  
  public int getCodigo(){
    return codproduto;
  }

   public int getQuantidade(){
    return quantidade;
  }

   public int getQuantidadeMaxima(){
    return quantidademaxima;
  }

  public double getValorPagado(){
    return valorDeCompra;
  }
  
  public double getValor(){
    return this.valor;
  }
  
  
  public void descrisaoCompleta(){
    System.out.println("codigo: "+codproduto
                       +"valor:"+valor
                       +" descrisao: "+descrisao
                       +" Fornecedor:"+fornecedor+
                       " quantidade no estoque:"+quantidade);
  }

  public String getDescrisao(){
    return descrisao;
  }
  public void descrisaoVenda(){
    System.out.println("codigo: "+codproduto
                       +"valor:"+valor
                       +" descrisao: "+descrisao);
  }
  
  public void reporProduto(int quantidade)throws Exception{
    if(this.quantidade+quantidade<=quantidademaxima)
      this.quantidade+=quantidade;
    else
      throw new Exception("quantidade de prdutos acima do estoque permitido");
  }

  public ArrayList<Produto> venderProdutos(int quat){
    ArrayList<Produto> lista=new ArrayList<Produto>();

    if(quat<=quantidade)
      for(int i=0;i<quat;i++){
        lista.add(this);
        quantidade--;
      }
      else
      System.out.println("não tem produtos suficiente");
    
    return lista;
  }

  public ArrayList<Produto> colocarNoCarinho(int quant){
    ArrayList<Produto> lista=new ArrayList<Produto>();

    if(quant<=quantidade)
      for(int i=0;i<quant;i++){
        lista.add(this);
      }
      else
      System.out.println("não tem produtos suficiente");
    
    return lista;
  }

  @Override
  public boolean equals(Object produto){
    if(produto instanceof Produto ){
      return ((Produto)produto).getCodigo()==this.getCodigo();
    }else
      return false;
  }
  
  private void inicaliza(int codigo,double valor,String descrisao,String fornecedor,int quant,int quantidademaxima){
    this.valor=valor;
    this.codproduto=codigo;
    this.descrisao=descrisao;
    this.fornecedor=fornecedor;
    this.quantidade=quant;
    this.quantidademaxima=quantidademaxima;
  }
  
}