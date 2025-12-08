import entidades.*;
import servico.*;
import entidades.enums.*;

public class Main {
  public static void main(String args[]){
    Veiculo veiculo1 = new Veiculo("BAG-1955", "Corsa", "Rosa", 2018);
    
    Passageiro passageiro1 = new Passageiro("Ronaldo", "112.691.875-60", "ronaldinho1@gmail.com", "123456", "61998566754");
    PagamentoDinheiro dinheiro = new PagamentoDinheiro();
    passageiro1.adicionarMetodoPagamento(dinheiro);

    Motorista motorista1 = new Motorista("Joao", "112.885.988-44", "joao123@gmail.com", "987654", "34988556644", "845165165", veiculo1);
    
    ServicoCorrida gerenciadorCorrida = new ServicoCorrida();
    gerenciadorCorrida.adicionarMotorista(motorista1);

    try {
      Corrida corrida = gerenciadorCorrida.solicitarCorrida(passageiro1, "goiania", "brasilia", 208.55, CategoriaServico.COMUM, dinheiro);
      System.out.println(corrida.aceitar());
      System.out.println(corrida.iniciarViagem());
      System.out.println(corrida.finalizarViagem());
      System.out.println(corrida.processarPagamento());
    } catch(Exception e){
      System.err.println(e.getMessage());
    }
  }
}
