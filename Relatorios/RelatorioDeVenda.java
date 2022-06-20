package Relatorios;
import Produtos.*;
import java.util.*;

public class RelatorioDeVenda{
  private ArrayList<Produto> produtosvendidos;
  public RelatorioDeVenda(){
    produtosvendidos=new ArrayList<Produto>();
  }

  public void adicionar(ArrayList<Produto> produtos){
    for(Produto p:produtos)
      this.produtosvendidos.add(p.copia());
  }

  public double gerarRelatorio(){
    ArrayList<Produto> pr=new ArrayList<Produto>();
    for(Produto p:produtosvendidos){
      if(!pr.contains(p)){
        pr.add(p);
      }
    }
    double valortotal=0;
    for(Produto p:pr){
      double quant=0;
      for(Produto plista:produtosvendidos){
        if(p.equals(plista))
          quant++;
      }
      print("Codigo do produto: "+p.getCodigo()+" descrisão: "+p.getDescrisao()+" preço praticado: "+p.getValor()+" quantidade de produtos vendidos: "+quant+" valor total: "+p.getValor()*quant);
    valortotal+=p.getValor()*quant;
    }
    print("Total ganhado : "+valortotal);
    return valortotal;
  }
  
  public void limparLista(){
    produtosvendidos.clear();
  }



  private void print(String Conteudo){
    System.out.println(Conteudo);
  }
}
