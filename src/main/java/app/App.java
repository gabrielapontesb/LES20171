package app;

import cdp.ArCondicionado;
import cdp.Sensor;

/**
 * @author gabi
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        Sensor sensor1 = new Sensor();
        Sensor sensor2 = new Sensor();
        Sensor sensor3 = new Sensor();
        
        ArCondicionado ar = new ArCondicionado();
        
        sensor1.addObserver(ar);
        sensor2.addObserver(ar);
        sensor3.addObserver(ar);
        
        sensor1.setQtdPessoas(25);
        sensor1.setTemperatura(0);
        
        sensor2.setQtdPessoas(27);
        sensor2.setTemperatura(5);
        
        sensor3.setQtdPessoas(20);
        sensor3.setTemperatura(10);
    }
}

