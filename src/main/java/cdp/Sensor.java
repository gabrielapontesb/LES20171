package cdp;
import java.util.Observable;

public class Sensor extends Observable{
	
	private double temperatura;
	private int qtdPessoas;

	public double getTemperatura() {
		return temperatura;
	}

	//cada pessoa faz a temperatura subir 1 grau
	public void setTemperatura(double temperatura) {
		int i = 0;
		double aux = temperatura;
		for (; i < qtdPessoas; i++){
			aux++;
		}
		
		this.temperatura = aux;
		System.out.println("Temperatura do sensor: " + aux);
		setChanged();
		notifyObservers();
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
}
