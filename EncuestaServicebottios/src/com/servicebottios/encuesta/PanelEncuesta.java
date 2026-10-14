package com.servicebottios.encuesta;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Panel (JPanel) que contiene todos los componentes de la encuesta:
 * comentario, calificacion del servicio, recomendacion y dia de uso.
 *
 * @author Desarrollador Servicebottios
 * @version 1.0
 */
public class PanelEncuesta extends JPanel {

    private static final long serialVersionUID = 1L;

    // 1. Comentario (JTextArea)
    private final JTextArea txtComentario = new JTextArea(5, 20);

    // 2. Calificacion del servicio (JCheckBox)
    private final JCheckBox chkExcelente = new JCheckBox("Excelente");
    private final JCheckBox chkBueno = new JCheckBox("Bueno");
    private final JCheckBox chkRegular = new JCheckBox("Regular");
    private final JCheckBox chkMalo = new JCheckBox("Malo");

    // 3. Recomendacion (JRadioButton)
    private final JRadioButton rdbSi = new JRadioButton("Sí");
    private final JRadioButton rdbNo = new JRadioButton("No");

    // 4. Dia de uso (JComboBox)
    private final JComboBox<String> cmbDia = new JComboBox<>(
            new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"});

    // Boton que dispara el evento
    private final JButton btnEnviar = new JButton("Enviar Encuesta");

    public PanelEncuesta() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel centro = new JPanel(new GridLayout(0, 1, 5, 5));

        centro.add(new JLabel("Comentario:"));
        centro.add(new JScrollPane(txtComentario));

        centro.add(new JLabel("Calificación del servicio:"));
        JPanel panelCalificacion = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCalificacion.add(chkExcelente);
        panelCalificacion.add(chkBueno);
        panelCalificacion.add(chkRegular);
        panelCalificacion.add(chkMalo);
        centro.add(panelCalificacion);

        centro.add(new JLabel("¿Recomendaría nuestro producto?"));
        JPanel panelRecomendacion = new JPanel(new GridLayout(1, 2, 5, 5));
        ButtonGroup grupoRecomendacion = new ButtonGroup();
        grupoRecomendacion.add(rdbSi);
        grupoRecomendacion.add(rdbNo);
        panelRecomendacion.add(rdbSi);
        panelRecomendacion.add(rdbNo);
        centro.add(panelRecomendacion);

        centro.add(new JLabel("¿Qué día utilizó el producto?"));
        centro.add(cmbDia);

        add(centro, BorderLayout.CENTER);
        add(btnEnviar, BorderLayout.SOUTH);

        // Se registra el manejador de eventos sobre el boton
        btnEnviar.addActionListener(new GestorEventos(this));
    }

    public JTextArea getTxtComentario() {
        return txtComentario;
    }

    public JCheckBox getChkExcelente() {
        return chkExcelente;
    }

    public JCheckBox getChkBueno() {
        return chkBueno;
    }

    public JCheckBox getChkRegular() {
        return chkRegular;
    }

    public JCheckBox getChkMalo() {
        return chkMalo;
    }

    public JRadioButton getRdbSi() {
        return rdbSi;
    }

    public JRadioButton getRdbNo() {
        return rdbNo;
    }

    public JComboBox<String> getCmbDia() {
        return cmbDia;
    }
}
