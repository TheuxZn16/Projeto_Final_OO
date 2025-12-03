package entidades;
import java.util.ArrayList;
import java.util.List;

import entidades.enums.StatusMotorista;

public class Motorista extends Usuario {

	private StatusMotorista status;
	private Veiculo veiculo;
	private final List<Corrida> historicoCorridas = new ArrayList<>();

	public Motorista(String nome, String cpf, String email, String telefone, String senha, Veiculo veiculo) {
		super(nome, cpf, email, telefone, senha);
		this.status = StatusMotorista.OFFLINE;
		this.veiculo = veiculo;

	}

	public StatusMotorista getStatus() {
		return status;

	}

	public void setStatus(StatusMotorista status) {
		this.status = status;

	}

	public Veiculo getVeiculo() {
		return veiculo;

	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;

	}

	public List<Corrida> getHistoricoCorridas() {
		return new ArrayList<>(historicoCorridas);

	}
 
	public boolean estaDisponivel() {
		return status == StatusMotorista.ONLINE;
	
	}
	
	public void adicionarCorridaAoHistorico(Corrida corrida) {
		historicoCorridas.add(corrida);
	}
}
