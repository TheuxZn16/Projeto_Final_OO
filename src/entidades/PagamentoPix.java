package entidades;

import entidades.enums.TipoPagamento;
import excecoes.SaldoInsuficienteException;

public class PagamentoPix implements MetodoPagamento {
  private double saldo;

  public void adicionarSaldo(double valor){
    saldo += valor;
  }
  @Override
  public void processarPagamento(double valor) throws SaldoInsuficienteException {
    if(valor > saldo) throw new SaldoInsuficienteException("Saldo insuficiente");
    saldo -= valor;  
  }
  @Override
  public TipoPagamento getTipo() {
    return TipoPagamento.PIX;
  }
}
