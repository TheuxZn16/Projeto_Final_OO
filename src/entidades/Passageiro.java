package entidades;

import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario {

    private final List<MetodoPagamento> metodosPagamento = new ArrayList<>();
    private boolean estaDevendo;
    private double valorQueDeve;

    public Passageiro(String nome, String cpf, String email, String telefone, String senha) {
        super(nome, cpf, email, telefone, senha);
        this.estaDevendo = false;
        this.valorQueDeve = 0.0;
    }

    public void setValorDevendo(double valor) {
        this.valorQueDeve = valor;
    }

    public void setEstaDevendo(boolean estaDevendo) {
        this.estaDevendo = estaDevendo;
    }

    public boolean estaDevendo() {
        return estaDevendo;
    }

    public void regularizar(MetodoPagamento metodoPagamento) {

    }

    public void adicionarMetodoPagamento(MetodoPagamento metodoPagamento) {
        metodosPagamento.add(metodoPagamento);
    }

    public List<MetodoPagamento> getMetodosPagamento() {
        return new ArrayList<>(metodosPagamento);
    }

}