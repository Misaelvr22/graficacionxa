package org.example;
import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {

    public Main() {
        setTitle("Ejemplo de un JFrame");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel();
        add(panel);

        setVisible(true);

    }

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Fondo
            g.setColor(Color.cyan);
            g.fillRect(0, 0, getWidth(), getHeight());

            // Triángulo
            g.setColor(Color.white);
            int x[] = {413, 519, 570};
            int y[] = {80, 190, 10};
            g.fillPolygon(x, y, 3);

            //circulo
            g.setColor(Color.black);
            g.fillOval(475, 70, 50,50);

            // rectangulo
            g.setColor(Color.black);
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(45), 240, 240);
            g2d.fillRect(250, 2, 150, 320);


            //poligono propulsor2
            g.setColor(Color.gray);
            int xc[] = {400, 420, 450, 400};
            int yc[] = {300, 320, 400, 400};
            g.fillPolygon(xc, yc, 4);

            //poligono propulsor1
            g.setColor(Color.gray);
            int xx[] = {220, 250, 250, 200};
            int yx[] = {320, 300, 400, 400};
            g.fillPolygon(xx, yx, 4);

            //linea
            Graphics2D l2d = (Graphics2D) g;
            g2d.setColor(Color.gray);
            l2d.setStroke(new BasicStroke(25));
            l2d.drawLine(325, 420, 330, 330);

            //circulo
            g.setColor(Color.WHITE);
            g.fillOval(290, 90, 80,80);

            //fuego
            g.setColor(Color.red);
            g.fillArc(200,420,100,300,70,33);
            g.fillArc(350,420,100,220,70,33);
            g.fillArc(280,450,100,220,70,33);

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
