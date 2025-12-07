package entidades;

public class Corrida {
    
    private String origem;
    private String destino;
    private CategoriaServico categoria;
    private double distanciaKm;
    private Motorista motorista;
    private Passageiro passageiro;
    private double precoEstimado;
    private StatusCorrida status;
    private MetodoPagamento metodoPagamento;
    
    
    public Corrida(String origem, String destino, CategoriaServico categoria, double distanciaKm, Motorista motorista,
            Passageiro passageiro, double precoEstimado, StatusCorrida status, MetodoPagamento metodoPagamento) {
        this.origem = origem;
        this.destino = destino;
        this.categoria = categoria;
        this.distanciaKm = distanciaKm;
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.precoEstimado = precoEstimado;
        this.status = status;
        this.metodoPagamento = metodoPagamento;
    }

    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServico categoria) {
        this.categoria = categoria;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public double getPrecoEstimado() {
        return precoEstimado;
    }

    public void setPrecoEstimado(double precoEstimado) {
        this.precoEstimado = precoEstimado;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }




    public double calcularPreco(){
        double base = categoria.getFatorPreco();
        return this.getDistanciaKm()*base;
    }

    public void iniciar(){
        this.status = StatusCorrida.EM_ANDAMENTO;
    }

    public void finalizar(){
        this.status = StatusCorrida.FINALIZADA;
    }



}
