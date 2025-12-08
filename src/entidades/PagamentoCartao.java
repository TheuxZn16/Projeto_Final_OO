package entidades;

import java.util.ArrayList;

import entidades.enums.TipoPagamento;
import excecoes.SaldoInsuficienteException;

public class PagamentoCartao implements MetodoPagamento {
  private double limiteFatura;
  private ArrayList<Double> faturas;

  public PagamentoCartao(double limite){
    this.limiteFatura = limite;
    this.faturas = new ArrayList<Double>();
  }

  @Override
  public void processarPagamento(double valor) throws SaldoInsuficienteException {
    double totalFatura = faturas.stream().reduce(0.00, (total, numero) -> total + numero);
    if(totalFatura + valor > limiteFatura) throw new SaldoInsuficienteException("O limite do cartão não suporta o pagamento");
    faturas.add(valor);
  }

  @Override
  public TipoPagamento getTipo() {
    return TipoPagamento.CARTAO;
  }
}
