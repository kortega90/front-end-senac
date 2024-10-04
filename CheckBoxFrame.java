import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame 
{
   public static void main(String[] args)
   { 
      new CheckBoxFrame(); 

   } 
   private final JTextPane textField = new JTextPane();
   private final JCheckBox boldJCheckBox = new JCheckBox("Bold");
   private final JCheckBox italicJCheckBox = new JCheckBox("Italic"); 
   private final JCheckBox underlineJCheckBox = new JCheckBox("Underline");


   // CheckBoxFrame constructor adds JCheckBoxes to JFrame
   public CheckBoxFrame()
   {
      super("JCheckBox Test");
      setLayout(new FlowLayout());

      // set up JTextField and set its font
      textField.setFont(new Font("Serif", Font.PLAIN, 14));
      add(textField); 
      
      add(boldJCheckBox); // add bold checkbox to JFrame
      add(italicJCheckBox); // add italic checkbox to JFrame
      add(underlineJCheckBox);

      // register listeners for JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler(textField, boldJCheckBox,italicJCheckBox, underlineJCheckBox);
      boldJCheckBox.addItemListener(handler);
      italicJCheckBox.addItemListener(handler);
      underlineJCheckBox.addItemListener(handler);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(275, 100); 
      setVisible(true); 
   } 
} 

