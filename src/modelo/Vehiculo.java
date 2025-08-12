package modelo;

import java.time.LocalDateTime;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private LocalDateTime horaEntrada;

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = LocalDateTime.now(); // guarda la hora actual como hora de entrada
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }

    @Override
    public String toString() {
        return placa + " - " + marca + " " + modelo + " (Entrada: " + horaEntrada + ")";
    }
}

