import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {

        JFrame filmFan = new FilmFanGUI();
        filmFan.setPreferredSize(new Dimension(1200, 800));
        filmFan.pack();
        filmFan.setVisible(true);
    }
}
