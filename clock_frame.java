package elements;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Calendar;
 
/**
 * Afficher une horloge
 */
public class ClockFrame extends JFrame {
 
    private JTextField jtextTime;
 
    /**
     * Initialisation JFrame + lancement du Timer
     */
    public ClockFrame() {
        jtextTime = new JTextField("Horloge", 5);
        jtextTime.setEditable(false);
        jtextTime.setFont(new Font("sansserif", Font.PLAIN, 48));
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(jtextTime);
        this.setContentPane(content);
        this.setTitle("Horloge Frame");
        this.pack();
        this.setLocationRelativeTo(null);
        javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
    } 
    /**
     * Evenement Timer, afficher l'heure
     */
    class ClockListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            jtextTime.setText(df.format(Calendar.getInstance().getTime()));
        }
    }
    /**
     * Exemple créer le JFrame
     * @param args
     */
    public static void main(String[] args) {
        JFrame clock = new ClockFrame();
        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clock.setVisible(true);
    }
}
