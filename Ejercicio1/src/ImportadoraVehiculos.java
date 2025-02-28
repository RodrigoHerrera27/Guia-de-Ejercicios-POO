import javax.swing.*;

public class ImportadoraVehiculos {
    public static void main(String[] args) {
        String[] marcas = {"Hyundai", "Toyota", "Honda", "Mazda", "BMW", "Ford", "Chevrolet"};
        String[] tipos = {"Sedán", "Pickup", "Microbus", "Moto"};
        String[] origenes = {"China", "Estados Unidos"};

        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:", "Tipo de Vehículo", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        String marca = (String) JOptionPane.showInputDialog(null, "Seleccione la marca del vehículo:", "Marca", JOptionPane.QUESTION_MESSAGE, null, marcas, marcas[0]);
        String origen = (String) JOptionPane.showInputDialog(null, "Seleccione el país de origen:", "Origen", JOptionPane.QUESTION_MESSAGE, null, origenes, origenes[0]);
        int anioFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación (2010-2025):"));
        double precioBase = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio base del vehículo:"));

        Vehiculo vehiculo = new Vehiculo(tipo, marca, origen, anioFabricacion, precioBase);
        vehiculo.mostrarResultados();
    }
}