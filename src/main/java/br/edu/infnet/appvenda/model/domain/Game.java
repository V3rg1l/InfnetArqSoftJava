package br.edu.infnet.appvenda.model.domain;

public class Game extends Produto {


	private int codigoConsole;
	private String descricaoGame;
	private int garantiaMeses;

	@Override
	public String toString() {
		return String.format("%s - %d - %s - %d", super.toString(), codigoConsole, descricaoGame, garantiaMeses);
	}
	
    public int getCodigoConsole() {
        return codigoConsole;
    }

    public void setCodigoConsole(int codigoConsole) {
        this.codigoConsole = codigoConsole;
    }

    public String getDescricaoGame() {
        return descricaoGame;
    }

    public void setDescricaoGame(String descricao) {
        this.descricaoGame = descricao;
    }
    
    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
}