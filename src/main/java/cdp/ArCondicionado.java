package cdp;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

public class ArCondicionado implements Observer{

	private final int QTD_SENSORES = 3;
	private int qtdMedidos = 0;
	private double temperaturaSensor;
	private double temperaturaFinal;
	private double desvio;

	public void update(Observable observable, Object object) {
		
		temperaturaFinal = atualizaTemperatura(observable);
		
		if (qtdMedidos == QTD_SENSORES){
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println("Temperatura média final: " + df.format(temperaturaFinal));
			System.out.println("Equilibrando " + df.format(Math.abs((25.0 - temperaturaFinal))) + " graus para manter 25ºC");
		}
	}

	//tira a media das temperaturas dos 3 sensores
	public double atualizaTemperatura(Observable observable){
		
		Sensor sensor = (Sensor) observable;
		qtdMedidos++;
		temperaturaSensor += sensor.getTemperatura();
		
		if (qtdMedidos == QTD_SENSORES){
			
			double media = temperaturaSensor/qtdMedidos;
			desvio = calculaDesvio(media);
			return media;
		}
		
		return temperaturaSensor;
	}
	
	public double calculaDesvio(double media){ return 25.0 - media; }
	
	public double getTemperaturaFinal() { return temperaturaFinal; }
}
