package Dominio;

public class Temporizador extends Thread {

    public static int contarSegundos(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int minutos = 0, segundos = 0;
    private boolean detenido = false;

    @Override
    public void run() {
        ejecutar();
    }

    public void ejecutar() {
        try {
            while (!detenido) {
                if (segundos == 59) {
                    segundos = 0;
                    minutos++;
                }
                segundos++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
        
    }

    public void detener() {
        detenido = true;
        System.out.println("Tiempo final: " + minutos + " minutos " + segundos + " segundos");
    }

    public static void main(String[] args) {
        Temporizador ti = new Temporizador();
        ti.start();
        
        // Detener el temporizador después de un tiempo (por ejemplo, después de 5 minutos)
        try {
            Thread.sleep(5 * 60 * 1000); // 5 minutos en milisegundos
        } catch (InterruptedException e) {
        }
        ti.detener();
    }
}