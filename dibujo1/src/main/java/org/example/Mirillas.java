package org.example;
import javax.swing.*;
import java.awt.*;

public class Mirillas extends JFrame {
    double XMmin, YMmin, XMmax, YMmax;
    double XNmin, YNmin, XNmax, YNmax;
    int resX = 800, resY = 800;

    public void Ventana(double a, double b, double c, double d) {
        XMmin = a;
        YMmin = b;
        XMmax = c;
        YMmax = d;
    }

    public void Mirilla(double a, double b, double c, double d) {
        XNmin = a;
        YNmin = b;
        XNmax = c;
        YNmax = d;
    }

    public double CoorNX(double xm) {
        return XNmin + (XNmax - XNmin) * (xm - XMmin) / (XMmax - XMmin);
    }

    public double CoorNY(double ym) {
        return YNmin + (YNmax - YNmin) * (YMmax - ym) / (YMmax - YMmin);
    }

    public int CoorDX(double xm) {
        return (int) ((resX - 1) * CoorNX(xm));
    }

    public int CoorDY(double ym) {
        return (int) ((resY - 1) * CoorNY(ym));
    }

    public void marco(Graphics g) {
        int x_inicial = (int) ((resX - 1) * (XNmin));
        int x_final = (int) ((resX - 1) * (XNmax));
        int y_inicial = (int) ((resY - 1) * (YNmin));
        int y_final = (int) ((resY - 1) * (YNmax));

        g.drawRect(x_inicial, y_inicial, x_final - x_inicial, y_final - y_inicial);
    }
    public void ejes(Graphics g) {
        //dibujar eje x
        if (YMmin * YMmax < 0) {
            int XD1 = CoorDX(XMmin);
            int XD2 = CoorDX(XMmax);
            int YD = CoorDY(0);

            g.drawLine(XD1, YD, XD2, YD);
        }
        //dibujar eje Y
        if (XMmin * XNmax < 0) {
            int YD1 = CoorDY(YMmin);
            int YD2 = CoorDY(YMmax);
            int XD = CoorDX(0);

            g.drawLine(XD, YD1, XD, YD2);

        }
    }

    public boolean EN_VENTANA(double x, double y) {
        return XMmin <= x && x <= XMmax && YMmin <= y && y <= YMmax;
    }


    public void paint(Graphics g) {
        // Parabola X^2
        Mirilla(0, 0, 0.33, 0.50);
        Ventana(-2 * Math.PI, -3, 2 * Math.PI, 3);
        marco(g);
        ejes(g);
        g.setColor(Color.cyan);
        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.0001) {
            double y = x * x;
            if (EN_VENTANA(x, y)) {
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        // Seno
        Mirilla(0.33, 0, 0.66, 0.50);
        Ventana(-2 * Math.PI, -3, 2 * Math.PI, 3);
        g.setColor(Color.black);
        marco(g);
        ejes(g);
        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.0001) {
            double y = Math.sin(x);
            if (EN_VENTANA(x, y)) {
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        // Rosa con pétalos
        Mirilla(0.66, 0, 1, 0.50);
        Ventana(-1.5, -1.5, 1.5, 1.5);
        marco(g);
        ejes(g);
        g.setColor(Color.PINK);

        int k_petalos = 15;
        for (double angulo = 0; angulo <= 2 * Math.PI; angulo += 0.001) {
            double r = Math.sin(k_petalos * angulo);
            double x = r * Math.cos(angulo);
            double y = r * Math.sin(angulo);
            if (EN_VENTANA(x, y)) {
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        // Hipotrocicloide
        Mirilla(0.33, 0.5, 0, 1);
        Ventana(-10, -15, 10, 15);
        g.setColor(Color.RED);
        marco(g);
        ejes(g);

        double r_h = 1; // radio del círculo más pequeño
        double k_h = 7.2; // relación R/r


        for (double theta = 0; theta <= 2 * Math.PI * k_h; theta += 0.01) {
            double x = r_h * (k_h - 1) * Math.cos(theta) + r_h * Math.cos((k_h - 1) * theta);
            double y = r_h * (k_h - 1) * Math.sin(theta) - r_h * Math.sin((k_h - 1) * theta);

            if (EN_VENTANA(x, y)) {
                int xd = CoorDX(x);
                int yd = CoorDY(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }
        // Asintotas
        Mirilla(0.33, 0.5, 0.66, 1);
        Ventana(-5, -5, 5, 5);
        g.setColor(Color.BLUE);
        marco(g);
        ejes(g);

        for (double x = -6.0; x <= 10.0; x += 0.0001) {
           // f(x) = (x^3 - 3x + 1) / (2x^2 + 1)
            double numerator = Math.pow(x, 3) - 3 * x + 1;
            double denominator = 2 * Math.pow(x, 2) + 1;
            double y = numerator / denominator;


            if (EN_VENTANA(x, y)) {
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);

            }
        }

        // Espiral
        Mirilla(0.66, 0.5, 1, 1);
        Ventana(-2 * Math.PI, -2 * Math.PI, 2 * Math.PI, 2 * Math.PI);
        g.setColor(Color.yellow);
        marco(g);
        ejes(g);

        double r_2 = 2;
        for (double angulo = 0; angulo <= 2 * Math.PI * 30; angulo += 0.01) {
            double x = r_2 * Math.cos(angulo);
            double y = r_2 * Math.sin(angulo);
            if (EN_VENTANA(x, y)) {
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
            r_2 += 0.001;
        }

    }

    public Mirillas() {
        setSize(resX, resY);
        setTitle("GRAFICAS");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Mirillas();
    }
}
