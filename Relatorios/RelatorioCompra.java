package Relatorios;
import Produtos.*;
import java.util.*;

public class RelatorioCompra{
  ArrayList<Produto> compras;
  public RelatorioCompra(){
    compras=new ArrayList<Produto>();
  }

  public void adicionar(Produto produtos){
      compras.add(produtos.copia());
  }

  public double gerarRelatorio(){
    ArrayList<Produto> pr=new ArrayList<Produto>();
    for(Produto p:compras){
      if(!pr.contains(p)){
        pr.add(p);
      }
    }
    double valortotal=0;
    for(Produto p:pr){
      double quant=0;
      for(Produto plista:compras){
        if(p.equals(plista))
          quant+=plista.getQuantidade();
      }
      print("Codigo do produto: "+p.getCodigo()+" descrisão: "+p.getDescrisao()+" quantidade de produtos comprados: "+quant+" preço da compra: "+p.getValorPagado()+" total: "+quant*p.getValorPagado());
    valortotal+=quant*p.getValorPagado();
    }
    print("preço total gasto: "+valortotal);
    return valortotal;
  }

  public void limparLista(){
    compras.clear();
  }

  private void print(String conteudo){
    System.out.println(conteudo);
  }
}