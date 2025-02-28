package Ejercicio2;
//importacion de bibliotecas para poder usar lo que seria un panel visual y no la consola.

import javax.swing.JOptionPane;

public class EncomiendasExpress {
    public static void main(String[] args) {
        //Declaramos la bariable para que puda tener en bucle y le salga un mensaje que si quiere salir.
        boolean continuar = true;
//huso un while para el bucle de salida de la aplicacion.
        while (continuar) {
            //Colocamos lo que seria el try catch para que la aplicacion suelte un mensaje por si susede un error.
            try {
                // Esta es la entrada de los datos.
                double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paquete (kg):"));
                double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia del envío (km):"));
                int express = JOptionPane.showConfirmDialog(null, "¿Desea envío express?", "Envío Express", JOptionPane.YES_NO_OPTION);
                int vip = JOptionPane.showConfirmDialog(null, "¿Posee tarjeta VIP?", "Tarjeta VIP", JOptionPane.YES_NO_OPTION);

                // El calculo  de las tarifas.
                double tarifaPeso;
                if (peso >= 1 && peso <= 4) {
                    tarifaPeso = 1.20;
                } else if (peso >= 5 && peso <= 10) {
                    tarifaPeso = 1.35;
                } else if (peso >= 11 && peso <= 20) {
                    tarifaPeso = 1.60;
                } else {
                    tarifaPeso = 1.75;
                }

                double tarifaDistancia;
                if (distancia >= 1 && distancia <= 20) {
                    tarifaDistancia = 0.20;
                } else if (distancia >= 21 && distancia <= 40) {
                    tarifaDistancia = 0.08;
                } else if (distancia >= 41 && distancia <= 60) {
                    tarifaDistancia = 0.06;
                } else {
                    tarifaDistancia = 0.04;
                }

                // Cálculos sobre lo que seria el peso o traifa o si tiene descuento.
                double subtotalPeso = peso * tarifaPeso;
                double subtotalDistancia = distancia * tarifaDistancia;
                double subtotalGeneral = subtotalPeso + subtotalDistancia;
                double costoExpress = (express == JOptionPane.YES_OPTION) ? subtotalGeneral * 0.13 : 0;
                double descuentoVIP = (vip == JOptionPane.YES_OPTION) ? (subtotalGeneral + costoExpress) * 0.10 : 0;
                double precioTotal = subtotalGeneral + costoExpress - descuentoVIP;

                // Muestra de  resultados
                String mensaje = String.format("Datos del paquete:\n- Peso: %.2f kg\n- Tarifa aplicada: $%.2f por kg\n\n" +
                                "Datos del envío:\n- Distancia: %.2f km\n- Tarifa aplicada: $%.2f por km\n\n" +
                                "Precio de envío:\n- Subtotal de peso: $%.2f\n- Subtotal de distancia: $%.2f\n- Sub total general: $%.2f\n" +
                                "- Costo por envío express: $%.2f\n- Descuento VIP: $%.2f\n\n" +
                                "Precio total a pagar: $%.2f",
                        peso, tarifaPeso, distancia, tarifaDistancia, subtotalPeso, subtotalDistancia, subtotalGeneral,
                        costoExpress, descuentoVIP, precioTotal);

                JOptionPane.showMessageDialog(null, mensaje, "Detalle del Envío", JOptionPane.INFORMATION_MESSAGE);
                //Aqui esta la pasrte del Catch donde esta declarado el mensaje que mostrara si llega a pasar un error.
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Menú para continuar o salir de la aplicacion.
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otro envío?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar Encomiendas Express. ¡Hasta la próxima!", "Salida", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}