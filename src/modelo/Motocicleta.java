package modelo;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo); // Llama al constructor de Vehiculo
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public String toString() {
        return "[Motocicleta] " + super.toString() + " | Cilindraje: " + cilindraje + " cc";
    }
}

