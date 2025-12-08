package entidades;

import entidades.enums.CategoriaServico;
import entidades.enums.StatusCorrida;
import entidades.enums.StatusMotorista;
import excecoes.StatusDaCorridaInvalidoException;
import servico.ServicoCorrida;

public class Corrida {
  private String origem, destino;
  private CategoriaServico categoria;
  private double distanciaKm;
  private Motorista motorista;
  private Passageiro passageiro;
  private double precoEstimado;
  private StatusCorrida status;
  private MetodoPagamento metodoPagamento;

  public Corrida(String origem, String destino, CategoriaServico categoria, double distanciaKm, Passageiro passageiro, Motorista motorista, MetodoPagamento metodoPagamento) {
    this.origem = origem;
    this.destino = destino;
    this.categoria = categoria;
    this.distanciaKm = distanciaKm;
    this.passageiro = passageiro;
    this.motorista = motorista;
    this.precoEstimado = calcularPrecoEstimado();
    this.status = StatusCorrida.SOLICITADA;
    this.metodoPagamento = metodoPagamento;
  }

  public double calcularPrecoEstimado() {
    if (categoria == CategoriaServico.COMUM) {
      return distanciaKm * 1.50 + 5.00;
    } else {
      return distanciaKm * 2.20 + 9.00;
    }
  }

  public StatusCorrida getStatus() {
    return status;
  }

  public String aceitar() throws StatusDaCorridaInvalidoException {
    if(this.status != StatusCorrida.SOLICITADA) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    motorista.alterarStatus(StatusMotorista.EM_CORRIDA);
    this.status = StatusCorrida.ACEITA;
    return "O motorista " + motorista.getNome() + " está indo até " + passageiro.getNome() + " em um " + motorista.getVeiculo();
  }
  public void recusar(ServicoCorrida gerenciador) throws StatusDaCorridaInvalidoException{
    if(this.status != StatusCorrida.SOLICITADA) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    try {
      this.motorista = gerenciador.procurarMotorista();  
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
  }
  public String iniciarViagem() throws StatusDaCorridaInvalidoException {
    if(this.status != StatusCorrida.ACEITA) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    this.status = StatusCorrida.EM_ANDAMENTO;
    return "Viagem iniciada saindo de " + this.origem + " com destino a " + this.destino;
  }
  public String cancelar() throws StatusDaCorridaInvalidoException {
    if(this.status == StatusCorrida.FINALIZADA || this.status == StatusCorrida.PENDENTE_PAGAMENTO) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    this.status = StatusCorrida.CANCELADA;
    return "Viagem cancelada";
  }
  public String finalizarViagem() throws StatusDaCorridaInvalidoException {
    if(this.status != StatusCorrida.EM_ANDAMENTO) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    this.status = StatusCorrida.PENDENTE_PAGAMENTO;
    return "Viagem finalizada. Pague o valor de R$" + this.precoEstimado;
  }
  public String processarPagamento() throws StatusDaCorridaInvalidoException {
    if(this.status != StatusCorrida.PENDENTE_PAGAMENTO) throw new StatusDaCorridaInvalidoException("Status da corrida inválido");
    try {
      metodoPagamento.processarPagamento(precoEstimado);
    } catch (Exception e) {
      passageiro.setEstaDevendo();
      passageiro.setValorDevendo(precoEstimado);
      this.status = StatusCorrida.FINALIZADA;
      motorista.alterarStatus(StatusMotorista.ONLINE);
      return e.getMessage();
    }
       
    this.status = StatusCorrida.FINALIZADA;
    motorista.alterarStatus(StatusMotorista.ONLINE);
    return "Pagamento finalizado";
  }
}
