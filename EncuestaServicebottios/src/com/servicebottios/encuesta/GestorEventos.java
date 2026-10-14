package com.servicebottios.encuesta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el ActionListener para el botón "Enviar Encuesta".
 * Recopila todos los datos ingresados por el usuario y los muestra por consola.
 *
 * @author Desarrollador Servicebottios
 * @version 1.0
 */
public class GestorEventos implements ActionListener {

    private PanelEncuesta panel;

    public GestorEventos(PanelEncuesta panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 1. Comentario (JTextArea)
        String comentario = panel.getTxtComentario().getText().trim();
        if (comentario.isEmpty()) {
            comentario = "(Sin comentario)";
        }

        // 2. Calificación del servicio (JCheckBox)
        StringBuilder calificacion = new StringBuilder();
        if (panel.getChkExcelente().isSelected()) {
            calificacion.append("Excelente ");
        }
        if (panel.getChkBueno().isSelected()) {
            calificacion.append("Bueno ");
        }
        if (panel.getChkRegular().isSelected()) {
            calificacion.append("Regular ");
        }
        if (panel.getChkMalo().isSelected()) {
            calificacion.append("Malo ");
        }
        String resultadoCalificacion = calificacion.toString().trim();
        if (resultadoCalificacion.isEmpty()) {
            resultadoCalificacion = "(Sin calificación)";
        }

        // 3. Recomendación (JRadioButton)
        String recomendacion = "(No seleccionado)";
        if (panel.getRdbSi().isSelected()) {
            recomendacion = "Sí";
        } else if (panel.getRdbNo().isSelected()) {
            recomendacion = "No";
        }

        // 4. Día de uso (JComboBox)
        String dia = (String) panel.getCmbDia().getSelectedItem();

        // --- Salida por consola (formato solicitado en la Figura 1) ---
        System.out.println("---------------------------------------------");
        System.out.println("Comentario: " + comentario);
        System.out.println("Calificación del servicio: " + resultadoCalificacion);
        System.out.println("¿Recomendaría nuestro producto?: " + recomendacion);
        System.out.println("Que día utilizó el producto: " + dia);
        System.out.println("---------------------------------------------");
    }
}
