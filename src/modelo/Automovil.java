package modelo;

public class Automovil extends Vehiculo {
    private String tipoCombustible;

    public Automovil(String placa, String marca, String modelo, String tipoCombustible) {
        super(placa, marca, modelo); // Llama al constructor de Vehiculo
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public String toString() {
        return "[Automóvil] " + super.toString() + " | Combustible: " + tipoCombustible;
    }
}

