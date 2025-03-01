package Ejercicio5;

import javax.swing.JOptionPane;

public class PagoHorasExtras {
    public static void main(String[] args) {
        // Variables para almacenar datos del empleado
        String nombre;
        double salario;
        String departamento;
        int horasRealizadas;
        double bonoPorDepartamento = 0;
        double pagoHorasExtras;

        // Variable para controlar si se desea continuar agregando empleados
        String continuar;

        do {
            try {
                // Solicitar y validar el nombre del empleado
                do {
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado:", "Datos del Empleado", JOptionPane.QUESTION_MESSAGE);
                    if (nombre == null) { // El usuario presionó Cancelar
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        return; // Terminar el programa
                    } else if (nombre.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error: El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (nombre.trim().isEmpty());

                // Solicitar y validar el salario del empleado
                do {
                    String inputSalario = JOptionPane.showInputDialog(null, "Ingrese el salario del empleado:", "Datos del Empleado", JOptionPane.QUESTION_MESSAGE);
                    if (inputSalario == null) { // El usuario presionó Cancelar
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        return; // Terminar el programa
                    }
                    try {
                        salario = Double.parseDouble(inputSalario.trim());
                        if (salario <= 0) {
                            JOptionPane.showMessageDialog(null, "Error: El salario debe ser un número positivo mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: El salario debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        salario = -1; // Forzar repetición del bucle
                    }
                } while (salario <= 0);

                // Solicitar y validar el departamento del empleado
                do {
                    departamento = JOptionPane.showInputDialog(null, "Ingrese el departamento del empleado (Gerencia, Auditoria, Tecnología, Contabilidad):", "Datos del Empleado", JOptionPane.QUESTION_MESSAGE);
                    if (departamento == null) { // El usuario presionó Cancelar
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        return; // Terminar el programa
                    } else if (!departamento.equalsIgnoreCase("Gerencia") &&
                            !departamento.equalsIgnoreCase("Auditoria") &&
                            !departamento.equalsIgnoreCase("Tecnología") &&
                            !departamento.equalsIgnoreCase("Contabilidad")) {
                        JOptionPane.showMessageDialog(null, "Error: El departamento debe ser 'Gerencia', 'Auditoria', 'Tecnología' o 'Contabilidad'.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (!departamento.equalsIgnoreCase("Gerencia") &&
                        !departamento.equalsIgnoreCase("Auditoria") &&
                        !departamento.equalsIgnoreCase("Tecnología") &&
                        !departamento.equalsIgnoreCase("Contabilidad"));

                // Asignar el bono por hora según el departamento
                switch (departamento.toLowerCase()) {
                    case "gerencia":
                        bonoPorDepartamento = 3.50;
                        break;
                    case "auditoria":
                        bonoPorDepartamento = 1.75;
                        break;
                    case "tecnología":
                        bonoPorDepartamento = 2.25;
                        break;
                    case "contabilidad":
                        bonoPorDepartamento = 2.00;
                        break;
                }

                // Solicitar y validar las horas realizadas en el mes
                do {
                    String inputHoras = JOptionPane.showInputDialog(null, "Ingrese las horas realizadas en el mes (máximo 20 horas):", "Datos del Empleado", JOptionPane.QUESTION_MESSAGE);
                    if (inputHoras == null) { // El usuario presionó Cancelar
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        return; // Terminar el programa
                    }
                    try {
                        horasRealizadas = Integer.parseInt(inputHoras.trim());
                        if (horasRealizadas < 0 || horasRealizadas > 20) {
                            JOptionPane.showMessageDialog(null, "Error: Las horas realizadas deben estar entre 0 y 20.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Las horas realizadas deben ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        horasRealizadas = -1; // Forzar repetición del bucle
                    }
                } while (horasRealizadas < 0 || horasRealizadas > 20);

                // Calcular el pago de horas extras
                pagoHorasExtras = ((salario / 30) * horasRealizadas) + (bonoPorDepartamento);

                // Mostrar los resultados
                String mensaje = "--- Resumen del Empleado ---\n"
                        + "1) Nombre: " + nombre + "\n"
                        + "2) Salario: $" + salario + "\n"
                        + "3) Departamento: " + departamento + "\n"
                        + "4) Horas realizadas en el mes: " + horasRealizadas + "\n"
                        + "5) Pago total de horas extras: $" + String.format("%.2f", pagoHorasExtras);

                JOptionPane.showMessageDialog(null, mensaje, "Resumen del Empleado", JOptionPane.INFORMATION_MESSAGE);

                // Preguntar si desea agregar otro empleado
                continuar = JOptionPane.showInputDialog(null, "¿Desea registrar otro empleado? (Sí/No):", "Continuar", JOptionPane.QUESTION_MESSAGE);
                if (continuar == null || continuar.trim().equalsIgnoreCase("No")) {
                    break; // Salir del bucle
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (true); // Repetir hasta que el usuario decida salir

        JOptionPane.showMessageDialog(null, "Programa finalizado. ¡Gracias por usar el sistema!", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
    }
}