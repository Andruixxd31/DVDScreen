import javax.swing.*;

public class Window extends JFrame{

    Window(){
        super("DVD logo Screensaver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        DVDPanel dvdp = new DVDPanel();
        this.add(dvdp); //instancing dvdpanel on the jframe.
        this.setResizable(false);
        this.pack(); //will organize all the elements
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}