package steps;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cdp.ArCondicionado;
import cdp.Sensor;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class ArCondicionadoSteps {
	
	private Sensor sensor1 = new Sensor();
    private Sensor sensor2 = new Sensor();
    private Sensor sensor3 = new Sensor();
	private List<Sensor> sensores = new ArrayList<Sensor>();
    private ArCondicionado ar = new ArCondicionado();
    private double temperaturaFinal;
    
	@Given("^Eu quero controlar a temperatura$")
	public void eu_quero_controlar_a_temperatura() throws Throwable {
		
		sensor1.addObserver(ar);
	    sensor2.addObserver(ar);
	    sensor3.addObserver(ar);
	    
		sensores.add(sensor1);
		sensores.add(sensor2);
		sensores.add(sensor3);  
	}

	@When("^Cada sensor mede sua propria temperatura$")
	public void cada_sensor_mede_sua_propria_temperatura(List<Double> temperaturas) throws Throwable {
		
	    double t1 = temperaturas.get(0);
	    double t2 = temperaturas.get(1);
	    double t3 = temperaturas.get(2);
	    
	    sensor1.setTemperatura(t1);
	    sensor2.setTemperatura(t2);
	    sensor3.setTemperatura(t3);
	}
	
	@When("^calcula a quantidade de pessoas na sala$")
	public void calcula_a_quantidade_de_pessoas_na_sala(List<Integer> pessoas) throws Throwable {
		
		int p1 = pessoas.get(0);
		int p2 = pessoas.get(1);
		int p3 = pessoas.get(2);
	    
	    sensor1.setQtdPessoas(p1);
	    sensor2.setQtdPessoas(p2);
	    sensor3.setQtdPessoas(p3);
	}

	@Then("^O ar deve normalizar a temperatura$")
	public void o_ar_deve_manter_a_sala_em_graus() throws Throwable {
		
		temperaturaFinal = ar.atualizaTemperatura(sensor1);
	    temperaturaFinal = ar.atualizaTemperatura(sensor2);
	    temperaturaFinal = ar.atualizaTemperatura(sensor3);
	    
	    double result = ar.getTemperaturaFinal() + ar.calculaDesvio(ar.getTemperaturaFinal());
		Assert.assertEquals(25.0, result);
	}
}