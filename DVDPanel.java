import javax.swing.*;
import java.awt.*;
// import java.util.Random;

public class DVDPanel extends JPanel implements Runnable {

    //*----------- Atributes -------------------

    private Color color;
    private final Image DVD;

    private int posX, posY; // Vaiables that will be randomly selected to chose the first position of the
                                  // figure
    private int xM, yM; // variables that will move the figure
    private int dirX, dirY;
    private int fW, fH; // height and width of the figure

    public final int WIDTH = 800, HEIGHT = 600; // width and height of the panel

    // *----------- Constructor -------------------
    DVDPanel() {
        super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(color.BLACK);
        this.DVD = new ImageIcon("dvd_logo.png").getImage();
        this.xM = 0;
        this.yM = 0;
        this.dirX = 1;
        this.dirY = 1;
        this.fW = 100;
        this.fH = 50;
        
        final Thread hilo = new Thread(this); // will help us do multiple process and move our logo in run();
        hilo.start();
    }

    // *----------- Methods for painting -------------------

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        this.paintLogo(g);
    }

    public void paintLogo(final Graphics g) {
        g.setColor(color.GREEN); 
        g.fillRect(this.posX, this.posY, this.fW, this.fH);

        //dont multiply by contants, code for a variable middle point
        g.drawImage(this.DVD, (int)(this.posX + fW * .25), (int)(this.posY + fH * .3), this.fW / 2, this.fH / 2, this);
    }

    // *----------- Methods generated from implementations -------------------

    @Override
    public void run() {
        while (true) { //?make a clamp like method
            try {
                this.xM += 8 * this.dirX;
                this.yM += 6 * this.dirY;
                this.posX = 500 + this.xM;
                this.posY = 300 + this.yM;

                //?Review code for optimization
                if (this.posX <= 0){
                    this.dirX *= -1;
                    this.posX = 1;
                }else if (this.posX + fW >= WIDTH){
                    this.dirX *= -1;
                    this.posX = WIDTH - fW - 1;
                }
                //?Review code for optimization
                if (this.posY <= 0){
                    this.dirY *= -1;
                    this.posY = 1;
                }else if (this.posY + fH >= HEIGHT){
                    this.dirY *= -1;
                    this.posY = HEIGHT - fH - 1;
                }
                this.repaint();
                Thread.sleep(20);
            } catch (final InterruptedException ex) {
                System.out.println("Program cant run correctly");
            }
        }
    }

}