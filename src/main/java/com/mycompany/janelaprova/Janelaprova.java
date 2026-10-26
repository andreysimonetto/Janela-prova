package com.mycompany.janelaprova;

import javax.swing.*;
import java.awt.*;

public class Janelaprova extends JFrame {

    private JTextField campoLado1;
    private JTextField campoLado2;
    private JTextField campoLado3;

    public Janelaprova() {
        setTitle("Verificar Triângulo");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Lado 1:"));
        campoLado1 = new JTextField("6");
        painel.add(campoLado1);

        painel.add(new JLabel("Lado 2:"));
        campoLado2 = new JTextField("6");
        painel.add(campoLado2);

        painel.add(new JLabel("Lado 3:"));
        campoLado3 = new JTextField("6");
        painel.add(campoLado3);

        JButton botaoVerificar = new JButton("Verificar Tipo");
        painel.add(new JLabel());
        painel.add(botaoVerificar);

        botaoVerificar.addActionListener(e -> verificarTriangulo());

        add(painel);
    }

    private void verificarTriangulo() {
        try {
            double lado1 = Double.parseDouble(campoLado1.getText().replace(",", "."));
            double lado2 = Double.parseDouble(campoLado2.getText().replace(",", "."));
            double lado3 = Double.parseDouble(campoLado3.getText().replace(",", "."));

            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                JOptionPane.showMessageDialog(this, "Os lados devem ser maiores que zero.");
                return;
            }

            if (lado1 + lado2 <= lado3 ||
                lado1 + lado3 <= lado2 ||
                lado2 + lado3 <= lado1) {
                JOptionPane.showMessageDialog(this, "Os valores não formam um triângulo.");
                return;
            }

            String tipo;

            if (lado1 == lado2 && lado2 == lado3) {
                tipo = "Triângulo Equilátero";
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                tipo = "Triângulo Isósceles";
            } else {
                tipo = "Triângulo Escaleno";
            }

            JOptionPane.showMessageDialog(this, tipo);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Janelaprova().setVisible(true));
    }
}