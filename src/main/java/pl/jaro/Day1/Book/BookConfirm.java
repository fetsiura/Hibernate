package pl.jaro.Day1.Book;

import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;
@Repository
public class BookConfirm {
    public int check (){
        Boolean check = true;
        ImageIcon icon = new ImageIcon("E −\\new.PNG");
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Czy na pewno chcesz usunąć książkę?");
        label1.setVerticalAlignment(SwingConstants.BOTTOM);
        label1.setBounds(2, 2, 250, 150);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label1);
        UIManager.put("OptionPane.minimumSize", new Dimension(150, 150));
        int res = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon);
        return res;
    }
}