package servicio;

import modelo.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // Tarifas por hora
    private final int TARIFA_AUTO = 5000;
    private final int TARIFA_MOTO = 3000;
    private final int TARIFA_CAMION = 10000;

    // Registrar la entrada de un vehículo
    public void registrarEntrada(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehículo registrado: " + v);
    }

    // Registrar la salida y calcular el total a pagar
    public void registrarSalida(String placa) {
        Vehiculo v = buscarVehiculo(placa);
        if (v != null) {
            vehiculos.remove(v);
            long horas = calcularHoras(v.getHoraEntrada(), LocalDateTime.now());
            int tarifa = calcularTarifa(v);
            long total = horas * tarifa;
            System.out.println("Vehículo " + v.getPlaca() + " salió.");
            System.out.println("Tiempo: " + horas + " hora(s)");
            System.out.println("Total a pagar: $" + total);
        } else {
            System.out.println("No se encontró el vehículo con placa: " + placa);
        }
    }

    // Mostrar vehículos que están en el parqueadero
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el parqueadero.");
        } else {
            vehiculos.forEach(System.out::println);
        }
    }

    // Buscar un vehículo por placa
    private Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    // Calcular horas redondeando hacia arriba
    private long calcularHoras(LocalDateTime entrada, LocalDateTime salida) {
        long minutos = Duration.between(entrada, salida).toMinutes();
        return (minutos + 59) / 60; // Redondea cualquier fracción de hora
    }

    // Calcular tarifa según tipo de vehículo
    private int calcularTarifa(Vehiculo v) {
        if (v instanceof Automovil) return TARIFA_AUTO;
        if (v instanceof Motocicleta) return TARIFA_MOTO;
        if (v instanceof Camion) return TARIFA_CAMION;
        return 0;
    }
}

