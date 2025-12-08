package entidades;

import java.util.ArrayList;

public class Passageiro extends Usuario {
  private ArrayList<MetodoPagamento> metodosPagamento;
  private boolean estaDevendo;
  private double valorQueDeve;

  public Passageiro(String nome, String cpf, String email, String senha, String telefone) {
    super(nome, cpf, email, senha, telefone);
    this.metodosPagamento = new ArrayList<MetodoPagamento>();
    this.estaDevendo = false;
  }
  public void setValorDevendo(double valor){
    valorQueDeve = valor;
  }
  public void setEstaDevendo(){
    this.estaDevendo = !estaDevendo;
  }
  public boolean getEstaDevendo(){
    return estaDevendo;
  }
  public void regularizar(MetodoPagamento metodoPagamento){
    try {
      metodoPagamento.processarPagamento(valorQueDeve);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    setEstaDevendo();
    setValorDevendo(0.00);
  }
  public void adicionarMetodoPagamento(MetodoPagamento m) {
    metodosPagamento.add(m);
  }
  public ArrayList<MetodoPagamento> getMetodoPagamentos(){
    return metodosPagamento;
  }
}
