package br.edu.infnet.appvenda.model.domain;

public class Console extends Produto {

	private String descricaoConsole;
	private String modelo;
	private int garantiaMeses;

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %d", super.toString(), descricaoConsole, modelo, garantiaMeses);
	}
	
    public String getDescricaoConsole() {
        return descricaoConsole;
    }

    public void setDescricaoConsole(String descricao) {
        this.descricaoConsole = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
}