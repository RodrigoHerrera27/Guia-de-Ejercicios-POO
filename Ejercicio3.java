import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {

        //Captura de datos del cliente
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido");
        String [] opciones = {"Light Jet ($3,000/h)", "Super Jet ($4,500/h)"};
        int tipoJetIndex = JOptionPane.showOptionDialog(null, "Seleccione el tipo de Jet:",
                "Tipo de Jet", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        int precioHora = (tipoJetIndex == 0) ? 3000 : 4500;
        String tipoJet = (tipoJetIndex == 0) ? "Light Jet" : "Super Jet";

        //Cantidad de horas del servicio
        double horas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cactidad de horas que se alquiló:"));

        //Cálculo de descuento
        double descuento = 0;
        if (horas >= 4 && horas < 9) {
            descuento = 0.15;
        } else if (horas >= 9 && horas < 13) {
            descuento = 0.2;
        } else if (horas >= 13 && horas < 17) {
            descuento = 0.25;
        } else if (horas >= 17) {
            descuento = 0.3;
        }

        //Cálculo del precio total
        double precioTotal = precioHora * horas;
        double montoDescuento = precioTotal * descuento;
        double precioFinal = precioTotal - montoDescuento;

        //Resultados
        String mensaje = "Resumen del Alquiler\n"+
                         "Cliente: "+nombre+" "+apellido+"\n"+
                         "Tipo de Jet: "+ tipoJet+"\n"+
                         "Horas de Alquiler: "+horas+"\n"+
                         "Precio por Hora: $"+precioHora+"\n"+
                         "Descuento Aplicado: "+(descuento*100)+"%\n"+
                         "Total a Pagar: $"+String.format("%.2f", precioFinal);

        JOptionPane.showMessageDialog(null, mensaje, "Resumen del Alquiler", JOptionPane.INFORMATION_MESSAGE);
    }
}
