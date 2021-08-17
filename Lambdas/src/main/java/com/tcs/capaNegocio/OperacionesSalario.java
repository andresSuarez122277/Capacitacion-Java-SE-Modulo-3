package main.java.com.tcs.capaNegocio;

import java.util.List;

@FunctionalInterface
public interface OperacionesSalario {
   List<Double> calcularDeducciones();
}
