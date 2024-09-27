import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener 
{
    ButtonHandler () {}
   // handle button event
   @Override
   public void actionPerformed(ActionEvent event)
   {
      JOptionPane.showMessageDialog(new ButtonFrame(), String.format(
         "You pressed: %s", event.getActionCommand()));
   }
} 