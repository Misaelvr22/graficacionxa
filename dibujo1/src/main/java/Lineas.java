import javax.swing.*;
import java.awt.*;

public class Lineas extends JFrame {
    public Lineas() {
        setTitle("Lineas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);


    }

    public void lineaBres(int x0,int y0, int x1, int y1, Graphics g){


        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawRect(x0,y0,1,1);
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    public void lineaDDA(int x0, int y0, int x1, int y1, Graphics g){
        int dx = x1 - x0;
        int dy = y1 - y0;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = dx / (float) steps;
        float yIncrement = dy / (float) steps;

        float x = x0;
        float y = y0;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x),Math.round(y),1,1);
            x += xIncrement;
            y += yIncrement;
        }
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
//
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

    public void paint(Graphics g){
        /*long tiempoinicial = System.currentTimeMillis();
        g.setColor(Color.BLUE);
        for (int i = 0; i <= 10000; i++) {
            lineaDDA(0,0,300,599,g);
            lineaDDA(0,599,300,0,g);
        }

        long tiempofinal = System.currentTimeMillis();
        long tiempoTotal = tiempofinal - tiempoinicial;
        System.out.println("Tiempo total DDA: " + tiempoTotal);

        tiempoinicial = System.currentTimeMillis();
        g.setColor(Color.BLUE);
        for (int i = 0; i <= 10000; i++) {
            lineaBres(0,0,300,599,g);
            lineaBres(0,599,300,0,g);
        }

        tiempofinal = System.currentTimeMillis();
        tiempoTotal = tiempofinal - tiempoinicial;
        System.out.println("Tiempo total Bres: " + tiempoTotal);
    */
        g.setColor(Color.RED);
        CircleBres(300, 300, 100, g);
        g.setColor(Color.MAGENTA);
//        for (float theta = 0; theta <= 2 * Math.PI; theta+=0.01) {
//            double x = 300+90 * Math.cos(theta);
//            double y = 300-90 * Math.sin(theta);
//
//            g.drawLine((int) x, (int) y, 1, 1);
//        }

        for (double angulo = 0; angulo <= 360; angulo+=72) {
            double x= 300+100 * Math.cos(angulo*Math.PI/180);
            double y= 300-100 * Math.sin(angulo+Math.PI/180);
            System.out.println("x"+ x);
            System.out.println("x"+ y);

        }

        int x[]=  {400, 330, 219, 219, 331};
        int y[]=  {300, 205, 241, 359, 395};
        g.setColor(Color.MAGENTA);
        g.drawPolygon(x, y,5);
    }

    public static void main(String[] args) {
        Lineas g = new Lineas();
    }
}