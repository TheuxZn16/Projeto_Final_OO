package entidades;

import excecoes.SaldoInsuficienteException;
import entidades.enums.TipoPagamento;

public interface MetodoPagamento {
  public void processarPagamento(double valor) throws SaldoInsuficienteException;
  public TipoPagamento getTipo();
}
