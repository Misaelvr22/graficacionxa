package org.example;
import javax.swing.*;
import java.awt.*;
public class DibujoCir extends JFrame {
    public DibujoCir() {
        setTitle("Circulo de Dibujo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setVisible(true);

    }

    private void CircleBres(int centerX, int centerY, int radius, Graphics g) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;
        while (x <= y) {
            // Dibujar los octantes
            g.drawRect(centerX + x, centerY + y, 1, 1);
            g.drawRect(centerX - x, centerY + y, 1, 1);
            g.drawRect(centerX + x, centerY - y, 1, 1);
            g.drawRect(centerX - x, centerY - y, 1, 1);
            g.drawRect(centerX + y, centerY + x, 1, 1);
            g.drawRect(centerX - y, centerY + x, 1, 1);
            g.drawRect(centerX + y, centerY - x, 1, 1);
            g.drawRect(centerX - y, centerY - x, 1, 1);
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        CircleBres(160, 100, 60, g);
        CircleBres(180, 90, 10, g);
        CircleBres(150, 90, 10, g);
        CircleBres(110, 50, 10, g);
        CircleBres(210, 50, 10, g);
        CircleBres(150, 190, 30, g);
        CircleBres(150, 230, 30, g);
        CircleBres(150, 260, 30, g);
        CircleBres(150, 310, 30, g);
        CircleBres(180, 330, 30, g);

        g.setColor(Color.BLACK);
        CircleBres(390, 290, 10, g);
        CircleBres(400, 270, 10, g);

        g.setColor(Color.red);
        CircleBres(150, 120, 15, g);

        g.setColor(Color.BLACK);
        CircleBres(305, 360, 100, g);


        g.setColor(Color.red);
        CircleBres(250, 490, 40, g);
        CircleBres(360, 490, 40, g);
        CircleBres(250, 550, 40, g);
        CircleBres(360, 550, 40, g);
    }

    public static void main(String[] args) {

        DibujoCir g = new DibujoCir();
    }
}