package ivanestech.com;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

   private JFrame ventana;
   private JLabel fondo;
   private JLabel titleM;
   private JLabel titleV;
   private JLabel titleMO;
   private JButton  inicio;
   private JButton salir;


   public Main() {

    ventana = new JFrame("MAN VS MONSTER");

    ventana.setSize(500,800);
    ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);

       fondo = new JLabel( );
       fondo.setBounds(0,0,500,800);


       ImageIcon imgIcon = new ImageIcon("src/images/mavsmo4.gif");
       Image imgEscalada = imgIcon.getImage().getScaledInstance(fondo.getWidth(),
               fondo.getHeight(), Image.SCALE_SMOOTH);
       Icon iconoEscalado = new ImageIcon(imgEscalada);
       fondo.setIcon(imgIcon);


       titleM = new JLabel("MAN");
       titleM.setFont(new Font("Serif",Font.PLAIN, 50));
       titleM.setForeground(new Color(107,34,48));
       titleM.setBounds(20,40,300,50);

      titleV = new JLabel("VS");
       titleV.setBounds(90,80,200,50);
       titleV.setFont(new Font("Serif",Font.PLAIN,50));

      titleMO = new JLabel("MONSTER");
       titleMO.setForeground(new Color(65,119,199));
      titleMO.setBounds(120,120,300,50);
      titleMO.setFont(new Font("Serif",Font.PLAIN,50));


        inicio = new JButton("NEW GAME");
        inicio.setBounds(150,500,
                200,40);
        inicio.setBackground(new Color(0, 0, 0, 99));
        inicio.setForeground(Color.WHITE);
        inicio.setOpaque(true);

       salir = new JButton("EXIT");
       salir.setBounds(180,560,
               140,40);
       salir.setBackground(new Color(0, 0, 0, 99));
       salir.setForeground(Color.WHITE);
       salir.setOpaque(true);




       ventana.add(titleM);
       ventana.add(titleV);
       ventana.add(titleMO);
       ventana.add(inicio);
       ventana.add(salir);
       ventana.add(fondo);


    ventana.setLayout(null);
    ventana.setVisible(true);

    reproducirSonido();

   }



    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
       new Main();



    }



    public void reproducirSonido(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/sounds/sound1.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(5);
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
}
