package Ejercicio4;

import javax.swing.JOptionPane;

public class DescuentoMatricula {
    public static void main(String[] args) {
        // variables para almacenar los datos del estudiante
        String nombre = "";
        String apellido = "";
        String tipoIngreso = "";
        int edad = 0;
        double costoMatricula = 0;
        double descuento = 0;
        double valorFinal = 0;

        try {
            // solicitaremos y validaremos el nombre del estudiante
            do {
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante:", "Datos del Estudiante", JOptionPane.QUESTION_MESSAGE);
                if (nombre == null) { // El usuario presionó Cancelar
                    JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                    return; // Finaliza el programa
                } else if (nombre.trim().isEmpty()) { // valida que el campo no esté vacio
                    JOptionPane.showMessageDialog(null, "Error: El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) { // Válida solo letras y espacios
                    JOptionPane.showMessageDialog(null, "Error: El nombre solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (nombre.trim().isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+"));

            // solicitaremos y validaremos el apellido del estudiante
            do {
                apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del estudiante:", "Datos del Estudiante", JOptionPane.QUESTION_MESSAGE);
                if (apellido == null) { // El usuario presionó Cancelar
                    JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                    return; // Finaliza el programa
                } else if (apellido.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: El apellido no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) { // Válida solo letras y espacios
                    JOptionPane.showMessageDialog(null, "Error: El apellido solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (apellido.trim().isEmpty() || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+"));

            // solicitaremos y validaremos el tipo de ingreso
            do {
                tipoIngreso = JOptionPane.showInputDialog(null, "Ingrese el tipo de ingreso (Antiguo Ingreso / Nuevo Ingreso):", "Datos del Estudiante", JOptionPane.QUESTION_MESSAGE);
                if (tipoIngreso == null) { // El usuario presionó Cancelar
                    JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                    return; // Finaliza el programa
                } else if (!tipoIngreso.equalsIgnoreCase("Antiguo Ingreso") && !tipoIngreso.equalsIgnoreCase("Nuevo Ingreso")) {
                    JOptionPane.showMessageDialog(null, "Error: El tipo de ingreso debe ser 'Antiguo Ingreso' o 'Nuevo Ingreso'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (!tipoIngreso.equalsIgnoreCase("Antiguo Ingreso") && !tipoIngreso.equalsIgnoreCase("Nuevo Ingreso"));

            // solicitaremos y validaremos la edad del estudiante
            do {
                try {
                    String inputEdad = JOptionPane.showInputDialog(null, "Ingrese la edad del estudiante:", "Datos del Estudiante", JOptionPane.QUESTION_MESSAGE);
                    if (inputEdad == null) { // El usuario presionó Cancelar
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        return; // Finaliza el programa
                    }
                    edad = Integer.parseInt(inputEdad.trim());
                    if (edad <= 0) {
                        JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número positivo mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (edad <= 0);

            // Calculo del costo de la matrícula según la edad
            if (edad > 15) {
                costoMatricula = 100;
            } else if (edad > 10) {
                costoMatricula = 125;
            } else if (edad > 5) {
                costoMatricula = 150;
            } else {
                JOptionPane.showMessageDialog(null, "Error: La edad mínima para matricularse es de 6 años.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculo del descuento según el tipo de ingreso
            if (tipoIngreso.equalsIgnoreCase("Antiguo Ingreso")) {
                descuento = costoMatricula * 0.25; // 25% de descuento
            } else {
                descuento = 0; // Sin descuento para nuevo ingreso
            }

            // Calculo del valor final de la matrícula
            valorFinal = costoMatricula - descuento;

            // Resultados Mostrados
            String mensaje = "--- Resumen de la Matrícula ---\n"
                    + "1) Nombre del estudiante: " + nombre + "\n"
                    + "2) Apellido del estudiante: " + apellido + "\n"
                    + "3) Valor de la matrícula: $" + costoMatricula + "\n"
                    + "4) Descuento obtenido: $" + descuento + "\n"
                    + "5) Valor final de la matrícula: $" + valorFinal;

            JOptionPane.showMessageDialog(null, mensaje, "Resumen de la Matrícula", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}