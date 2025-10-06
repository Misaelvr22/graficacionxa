package org.example;
import javax.swing.*;
import java.awt.*;

public class TransformacionCoordenadas extends JFrame {
    double XMmin, YMmin, XMmax, YMmax;
    double XNmin, YNmin, XNmax, YNmax;
    int Resx = 600, Resy = 600;

    public TransformacionCoordenadas() {
        setTitle("Transformando Coordenadas");
        setSize(Resx, Resy);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void VENTANA(double a, double b, double c, double d) {
        XMmin = a;
        YMmin = b;
        XMmax = c;
        YMmax = d;

    }

    public void MIRILLA(double a, double b, double c, double d) {
        XNmin = a;
        YNmin = b;
        XNmax = c;
        YNmax = d;
    }

    public double coorNX(double xm) {
        return XNmin + (XNmax - XNmin) * (xm - XMmin) / (XMmax - XMmin);
    }

    public double coorNY(double ym) {
        return YNmin + (YNmax - YNmin) * (YMmax - ym) / (YMmax - YMmin);
    }

    public int coorDX(double xm) {
        return (int) ((Resx - 1) * coorNX(xm));
    }

    public int coorDY(double ym) {
        return (int) ((Resy - 1) * coorNY(ym));
    }

    /*
    public void procesar() {
        Resx = 800;
        Resy = 600;
        VENTANA(-10, -20, 10, 100);
        MIRILLA(0, 0, 1, 1);
        System.out.println(coorNX(5));
        System.out.println(coorNY(50));
        System.out.println(coorDX(5));
        System.out.println(coorDY(50));

    }*/

    public void marco(Graphics g) {
        int Xi = (int) ((Resx - 1) * (XNmin));
        int Xf = (int) ((Resx - 1) * (XNmax));

        int Yi = (int) ((Resy - 1) * (YNmin));
        int Yf = (int) ((Resy - 1) * (YNmax));

        g.drawRect(Xi, Yi, Xf - Xi, Yf - Yi);

    }

    public void ejes(Graphics g) {
        //dibujar eje x
        if (YMmin * YMmax < 0) {
            int XD1 = coorDX(XMmin);
            int XD2 = coorDX(XMmax);
            int YD = coorDY(0);

            g.drawLine(XD1, YD, XD2, YD);
        }

        //dibujar eje Y
        if (XMmin * XNmax < 0) {
            int YD1 = coorDY(YMmin);
            int YD2 = coorDY(YMmax);
            int XD = coorDX(0);

            g.drawLine(XD, YD1, XD, YD2);

        }

    }

    public boolean END_VENTANA(double x, double y) {
        return XMmin <= x && x <= XMmax && YMmin <= y && y <= YMmax;
    }

    public void paint(Graphics g) {
        //MIRILLA(1.0/3.0, 0.5, 2.0/3.0, 1);
        //MIRILLA(0.1, 0.1, 0.9, 0.9);
        //MIRILLA(0.1, 0.1, 0.9, 0.9);
        //MIRILLA(0,0,1,1);
       // MIRILLA(0.33333, 0.33333, 0.66666, 0.66666);
        //VENTANA(-2 * Math.PI, -3, 2 * Math.PI, 3);

        g.setColor(Color.GREEN);
        marco(g);
        ejes(g);

        g.setColor(Color.RED);

        //seno

//        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.00001) {
//            double y = 1 / Math.cos(x);
//
//            if (END_VENTANA(x, y)) {
//                int xd = coorDX(x);
//                int yd = coorDY(y);
//                g.drawRect(xd, yd, 1, 1);
//            }
//        }


        //VENTANA(-6, -6, 6, 6);
        /*
        double r = 6.2;
        for (double ang = 0; ang <= 2 * Math.PI; ang += 0.01) {
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);

            if (END_VENTANA(x, y)) {
                int xd = coorDX(x);
                int yd = coorDY(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        r = 2.5;
        for (double ang = 0; ang <= 2 * Math.PI; ang += 0.01) {
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);

            if (END_VENTANA(x, y)) {
                int xd = coorDX(x);
                int yd = coorDY(y);
                g.drawRect(xd, yd, 1, 1);
                g.setColor(Color.MAGENTA);
            }
        }*/
        MIRILLA(0.33333, 0.33333, 0.66666, 0.66666);
        VENTANA(-6, -6, 6, 6);

        //Espiral
        /*double r = 0;
        for (double ang = 0; ang <= 2 * Math.PI * 20; ang += 0.01) {
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);

            if (END_VENTANA(x, y)) {
                int xd = coorDX(x);
                int yd = coorDY(y);
                g.drawRect(xd, yd, 1, 1);
                g.setColor(Color.MAGENTA);

            }
            r+=0.0015;
        }*/

        //Rosa
        for (double ang = 0; ang <= 2 * Math.PI * 20; ang += 0.001) {
            double r=5 * Math.cos(ang*10);
            double x = r * Math.cos(ang);
            double y = r * Math.sin(ang);

            if (END_VENTANA(x, y)) {
                int xd = coorDX(x);
                int yd = coorDY(y);
                g.drawRect(xd, yd, 1, 1);
                g.setColor(Color.RED);

            }
            r+=0.0015;
        }

        // parabola, funcion seno, rosa de petalos, funcio de parabolaf(x2), grafica cicloide, dibujar un espiral

    }

    public static void main(String[] args) {
        TransformacionCoordenadas t = new TransformacionCoordenadas();
    }
}