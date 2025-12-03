package entidades;

import entidades.enums.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario {

    private final List<TipoPagamento> tipoPagamentos = new ArrayList<>();
    private boolean estaDevendo;
    private double valorQueDeve;

    public Passageiro(String nome, String cpf, String email, String telefone, String senha) {
        super(nome, cpf, email, telefone, senha);
        this.estaDevendo = false;
        this.valorQueDeve = 0.0;

    }

    public void adicionarTipoPagamento(TipoPagamento tipoPagamento) {
        if (tipoPagamento != null && !tipoPagamentos.contains(tipoPagamento)) {
            tipoPagamentos.add(tipoPagamento);
        }
    }

    public void removerTipoPagamento(TipoPagamento tipoPagamento) {
        tipoPagamentos.remove(tipoPagamento);

    }

    public List<TipoPagamento> getTiposPagamento() {
        return new ArrayList<>(tipoPagamentos);

    }

    public boolean estaDevendo() {
        return estaDevendo;

    }

    public double getValorQueDeve() {
        return valorQueDeve;

    }

    public void adicionarDivida(double valor) {
        if (valor > 0) {
            this.valorQueDeve += valor;
            this.estaDevendo = true;
        }
    }

    public void quitarDivida() {
        this.valorQueDeve = 0.0;
        this.estaDevendo = false;

    }


}
