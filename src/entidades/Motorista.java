package entidades;

import entidades.enums.StatusMotorista;

public class Motorista extends Usuario {
  private String cnh;
  private StatusMotorista statusDisponibilidade;
  private Veiculo veiculoAtivo;

  public Motorista(String nome, String cpf, String email, String senha, String telefone, String cnh, Veiculo veiculoAtivo) {
    super(nome, cpf, email, senha, telefone);
    this.cnh = cnh;
    this.statusDisponibilidade = StatusMotorista.ONLINE;
    this.veiculoAtivo = veiculoAtivo;
  }

  public void alterarStatus(StatusMotorista novoStatus) {
    statusDisponibilidade = novoStatus;
  } 
  public String getVeiculo(){
    return veiculoAtivo.getDescricao();
  }
  public String getCnh(){
    return this.cnh;  
  }
  public StatusMotorista getStatusMotorista(){
    return statusDisponibilidade;
  }
}
