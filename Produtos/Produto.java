package Produtos;
import java.util.ArrayList;

public class Produto{
  static int ind=0;
  private int codproduto;
  private double valor;
  private String descrisao;
  private String fornecedor;
  private int quantidade;

  public Produto(int codigo,double valor,String descrisao,String fornecedor,int quant){
    inicaliza(codigo,valor,descrisao,fornecedor,quant);
  }
  
  public Produto(double valor,String descrisao,String fornecedor,int quant){
    inicaliza(ind++,valor,descrisao,fornecedor,quant);
  }

  public double getValor(){
    return this.valor;
  }
  
  public void descrisaoCompleta(){
    System.out.println("codigo: "+codproduto
                       +"valor:"+valor
                       +" descrisao: "+descrisao
                       +" Fornecedor:"+fornecedor+
                       " quantidade no estoque:"+quantidade 
                      );
  }
  
  public void reporProduto(int quantidade){
    this.quantidade+=quantidade;
  }

  public ArrayList<Produto> venderProdutos(int quat){
    ArrayList<Produto> lista=new ArrayList<Produto>();

    if(quat<=quantidade)
      for(int i=0;i<quat;i++){
        lista.add(this);
        quantidade--;
      }
    
    return lista;
  }
  
  private void inicaliza(int codigo,double valor,String descrisao,String fornecedor,int quant){
    this.valor=valor;
    this.codproduto=codigo;
    this.descrisao=descrisao;
    this.fornecedor=fornecedor;
    this.quantidade=quant;
  }
  
}