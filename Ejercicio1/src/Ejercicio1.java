import java.util.HashMap;
import java.util.Map;

class Vehiculo {
    String tipo, marca, origen;
    int anioFabricacion;
    double precioBase;

    public Vehiculo(String tipo, String marca, String origen, int anioFabricacion, double precioBase) {
        this.tipo = tipo;
        this.marca = marca;
        this.origen = origen;
        this.anioFabricacion = anioFabricacion;
        this.precioBase = precioBase;
    }

    public double calcularImpuesto() {
        int edad = 2025 - anioFabricacion;
        if (edad > 15) {
            return -1; // No se aceptan vehículos mayores a 15 años
        } else if (edad >= 10) {
            return precioBase * 0.16;
        } else if (edad >= 5) {
            return precioBase * 0.13;
        } else {
            return precioBase * 0.11;
        }
    }

    public double obtenerFlete() {
        Map<String, Map<String, Double>> fleteMap = new HashMap<>();
        fleteMap.put("China", Map.of("Sedán", 1700.0, "Pickups", 1900.0, "Microbuses", 2400.0, "Motos", 1300.0));
        fleteMap.put("Estados Unidos", Map.of("Sedán", 1200.0, "Pickups", 1500.0, "Microbuses", 1700.0, "Motos", 900.0));
        return fleteMap.get(origen).getOrDefault(tipo, 0.0);
    }

    public double obtenerMatricula() {
        if (anioFabricacion >= 2020) return 11.99;
        if (anioFabricacion >= 2016) return 13.99;
        return 15.99;
    }

    public void mostrarResultados() {
        double impuesto = calcularImpuesto();
        if (impuesto == -1) {
            System.out.println("Vehículo demasiado antiguo para importación.");
            return;
        }
        double flete = obtenerFlete();
        double matricula = obtenerMatricula();
        double total = precioBase + impuesto + flete + matricula;

        System.out.println("\n===== Datos del Vehículo =====");
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
        System.out.println("Año de Fabricación: " + anioFabricacion);
        System.out.println("Origen: " + origen);
        System.out.println("Precio Base: $" + precioBase);

        System.out.println("\n===== Datos de Importación =====");
        System.out.println("Impuesto (" + (impuesto / precioBase * 100) + "%): $" + impuesto);
        System.out.println("Costo de Flete: $" + flete);
        System.out.println("Matrícula Inicial: $" + matricula);
        System.out.println("Total a Pagar: $" + total);
    }
}

