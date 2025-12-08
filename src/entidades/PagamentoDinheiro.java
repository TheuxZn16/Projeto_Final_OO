package entidades;

import java.util.Scanner;

import entidades.enums.TipoPagamento;
import excecoes.SaldoInsuficienteException;

public class PagamentoDinheiro implements MetodoPagamento {
  @Override
  public void processarPagamento(double valor) throws SaldoInsuficienteException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o valor do pagamento: ");
    double valorPagamento = sc.nextDouble();
    if(valorPagamento < valor){
      sc.close();
      throw new SaldoInsuficienteException("Saldo insuficiente");
    };
    System.out.println("Pagamento realizado com sucesso");
    sc.close();
  }
  @Override
  public TipoPagamento getTipo() {
    return TipoPagamento.DINHEIRO;
  }
}
