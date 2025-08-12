package modelo;

public class Camion extends Vehiculo {
    private double capacidadCarga; // en toneladas

    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super(placa, marca, modelo); // Llama al constructor de Vehiculo
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public String toString() {
        return "[Camión] " + super.toString() + " | Capacidad: " + capacidadCarga + " ton";
    }
}

