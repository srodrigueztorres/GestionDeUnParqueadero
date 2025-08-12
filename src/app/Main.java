package app;

import modelo.*;
import servicio.Parqueadero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PARQUEADERO ===");
            System.out.println("1. Registrar entrada");
            System.out.println("2. Registrar salida");
            System.out.println("3. Mostrar vehículos presentes");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Tipo de vehículo: 1) Automóvil  2) Motocicleta  3) Camión");
                    int tipo = Integer.parseInt(sc.nextLine());
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    switch (tipo) {
                        case 1 -> {
                            System.out.print("Tipo de combustible: ");
                            String combustible = sc.nextLine();
                            parqueadero.registrarEntrada(new Automovil(placa, marca, modelo, combustible));
                        }
                        case 2 -> {
                            System.out.print("Cilindraje (cc): ");
                            int cilindraje = Integer.parseInt(sc.nextLine());
                            parqueadero.registrarEntrada(new Motocicleta(placa, marca, modelo, cilindraje));
                        }
                        case 3 -> {
                            System.out.print("Capacidad de carga (ton): ");
                            double carga = Double.parseDouble(sc.nextLine());
                            parqueadero.registrarEntrada(new Camion(placa, marca, modelo, carga));
                        }
                        default -> System.out.println("Tipo inválido.");
                    }
                }
                case 2 -> {
                    System.out.print("Placa del vehículo: ");
                    String placaSalida = sc.nextLine();
                    parqueadero.registrarSalida(placaSalida);
                }
                case 3 -> parqueadero.mostrarVehiculos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

