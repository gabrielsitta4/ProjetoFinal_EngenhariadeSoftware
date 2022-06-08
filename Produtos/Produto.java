package Produtos;
import java.util.ArrayList;

import com.sun.source.doctree.SystemPropertyTree;

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

  public int getCodigo(){
    return codproduto;
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

  public void descrisaoVenda(){
    System.out.println("codigo: "+codproduto
                       +"valor:"+valor
                       +" descrisao: "+descrisao);
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
  
  private void inicaliza(int codigo,double valor,String descrisao,String fornecedor,int quant){
    this.valor=valor;
    this.codproduto=codigo;
    this.descrisao=descrisao;
    this.fornecedor=fornecedor;
    this.quantidade=quant;
  }
  
}