package org.example;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main extends JFrame {
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillRect(75, 75, 1,1);
        g.setColor(Color.blue);
        g.drawLine(0, 0, 599,599);
        g.drawLine(0, 599, 599,0);
        g.setColor(Color.magenta);
        g.fillOval(200, 200, 200,200);
        g.setColor(Color.black);
        g.fillOval(250, 250, 100,100);
        int x[]= {0,150,300} ;
        int y[]={599,450,599};
        g.fillPolygon(x,y,3);

//A partir de aqui vamos a leer archivo byte por byte

       try {
            File archivo = new File("/home/misael-villa/Descargas/imagenesTib/ojos.tib");
            FileInputStream flujo= new FileInputStream(archivo);
            BufferedInputStream buffer = new BufferedInputStream(flujo);
            System.out.println("Archivo tibu abierto exitosamente!!");
            int byte1= buffer.read();
            System.out.println(String.format("%c",byte1));
            int byte2=buffer.read();
            System.out.println(String.format("%c",byte2));
            int byte3=buffer.read();
           System.out.println(String.format("%c",byte3));
           int byte4=buffer.read();
           System.out.println(String.format("%c",byte4));
            int byte5=buffer.read();
            System.out.println(String.format("%c",byte5));
            int byte6=buffer.read();
            System.out.println(String.format("%c",byte6));
           int byte7=buffer.read();
           System.out.println(String.format("%c",byte7));
           int byte8=buffer.read();
           System.out.println(String.format("%c",byte8));

           int byteanchoH=buffer.read();
           int byteanchoL=buffer.read();
           int ancho= byteanchoH*256 + byteanchoL;
           System.out.println("ancho es igual: "+ancho);

           int altoH=buffer.read();
           int altoL=buffer.read();
           int alto= altoH*256 + altoL;
           System.out.println("alto es igual: "+alto);
            buffer.close();
            flujo.close();
            for(int Y=0; Y < alto; Y++ ){
                for(int X=0; X < ancho; X++){

                    int rojo= buffer.read();
                    int verde= buffer.read();
                    int azul= buffer.read();
                    g.setColor(new Color(rojo,verde,azul));
                    g.fillRect(X,Y,1,1);

                }
                buffer.close();
                flujo.close();
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public Main(){
        setTitle("Ejemplo de un Jframe");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//    getContentPane().setBackground(Color.yellow);
    }
    public static void main(String[] args) {
         new Main();    }
}