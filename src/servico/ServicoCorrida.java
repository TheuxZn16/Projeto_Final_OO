package servico;
import java.util.ArrayList;

import entidades.Corrida;
import entidades.MetodoPagamento;
import entidades.Motorista;
import entidades.Passageiro;
import entidades.enums.CategoriaServico;
import entidades.enums.StatusMotorista;
import excecoes.NenhumMotoristaDisponivelException;
import excecoes.PagamentoRecusadoException;
import excecoes.PassageiroDevendoException;

public class ServicoCorrida {
  private ArrayList<Motorista> motoristasDisponiveis;

  public ServicoCorrida(){
    this.motoristasDisponiveis = new ArrayList<Motorista>();
  }

  public void adicionarMotorista(Motorista motorista){
    motoristasDisponiveis.add(motorista);
  }

  public Motorista procurarMotorista() throws NenhumMotoristaDisponivelException{
    return motoristasDisponiveis.stream().filter(m -> m.getStatusMotorista() == StatusMotorista.ONLINE).findFirst().orElseThrow(() -> new NenhumMotoristaDisponivelException("Nenhum motorista disponível."));
  }

  public Corrida solicitarCorrida(Passageiro passageiro, String origem, String destino, double distanciaKm,
  CategoriaServico categoria, MetodoPagamento metodoPagamento) throws PassageiroDevendoException, PagamentoRecusadoException{
    if(passageiro.getEstaDevendo()) throw new PassageiroDevendoException("O passageiro está devendo, primeiro regularize para solicitar uma viagem");
    
    if (!passageiro.getMetodoPagamentos().stream()
    .filter(m -> m.equals(metodoPagamento))
    .findFirst()
    .isPresent()) {
    throw new PagamentoRecusadoException("Método de pagamento não está associado ao passageiro");
}
    Motorista motorista;

    try {
    motorista = procurarMotorista();     
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
    Corrida corrida = new Corrida(origem, destino, categoria, distanciaKm, passageiro, motorista, metodoPagamento);
    return corrida;
  }
}
