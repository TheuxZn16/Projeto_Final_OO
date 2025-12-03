package servico;

import java.util.ArrayList;

public class ServicoCorrida { 

    private ArrayList<Motorista> motoristasDisponiveis;

    public ServicoCorrida(){
        motoristasDisponiveis = new ArrayList<Motorista>();

    }

    public void adicionarMotorista (Motorista motorista){ 
        if(motorista != null && motorista.getStatus == Status.ONLINE)
            motoristasDisponiveis.add(motorista);
    }

    public void removerMotorista(Motorista motorista) {
        motoristasDisponiveis.remove(motorista);
    }

    private Motorista procurarMotorista() throws NenhumMotoristaDisponivelException{
        for(Motorista motorista: motoristasDisponiveis){
            if (motorista.getStatus() == Status.ONLINE){
                return(motorista);
            }
        }
        throw new NenhumMotoristaDisponivelException();
        
    }


    public Corrida solicitarCorrida(Passageiro passageiro, String origem, Sring destino, double distanciaKm, CategriaServico categoria, MetodoPagamento metodoPagamento) throws Exception{
        Corrida solicitarCorrida = new Corrida();

        if (passageiro.estaDevendo())
            throw new PassageiroDevendoException();

        if (metodoPagamento == null)
            throw new PagamentoRecusadoException();

        Motorista motorista = procurarMotorista();

        motorista.setStatus(StatusMotorista.EM_CORRIDA);

        Corrida corrida = new Corrida(
                origem,
                destino,
                distanciaKm,
                categoria,
                passageiro,
                motorista,
                metodoPagamento
        );

        return corrida;
    }

    public void finalizarCorrida(Corrida corrida) {
        corrida.finalizar();
        corrida.getMotorista().setStatus(StatusMotorista.ONLINE);
    }
    
}