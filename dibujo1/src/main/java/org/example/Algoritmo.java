package org.example;
import javax.swing.*;
import java.awt.*;

public class Algoritmo extends JFrame {
    public Algoritmo() {
        setTitle("Circulo de Dibujo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setVisible(true);

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
    public void paint(Graphics g) {
    int x[]= {230, 300, 250, 240, 345, 340};
    int y[]= {450,240, 230, 330, 220, 335};
    Mipoligono(x,y, 6,g);
    }
    public void Mipoligono(int []x,int []y, int puntos , Graphics g){
        for (int i = 0; i < puntos-1; i++) {
            lineaBres(x[i],y[i],x[i+1],y[i+1],g);
        }
        lineaBres(x[0], y[0],x[puntos-1],y[puntos-1],g);
    }

    public static void main(String[] args) {
        Algoritmo  a = new Algoritmo();

    }
}
