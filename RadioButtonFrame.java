
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RadioButtonFrame extends JFrame 
{
   private JTextField textField; // used to display font changes
   private Font plainFont; // font for plain text
   private Font boldFont; // font for bold text
   private Font italicFont; // font for italic text
   private Font boldItalicFont; // font for bold and italic text

   private Color blackColor; 
   private Color redColor; 
   private Color blueColor; 
   private Color yellowColor; 

   private JRadioButton plainJRadioButton; // selects plain text
   private JRadioButton boldJRadioButton; // selects bold text
   private JRadioButton italicJRadioButton; // selects italic text
   private JRadioButton boldItalicJRadioButton; // bold and italic
   private ButtonGroup radioGroup; // buttongroup to hold radio buttons

  

   private JRadioButton blackJRadioButton; 
   private JRadioButton redRadioButton; 
   private JRadioButton blueJRadioButton;
   private JRadioButton yellowJRadioButton;
   private ButtonGroup colorGroup;
   public RadioButtonFrame()
   {
      super("RadioButton Test");
      setLayout(new FlowLayout()); 

      textField = new JTextField("Watch the font style change", 25);
      add(textField); // add textField to JFrame

      // create radio buttons
      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); 
      add(boldJRadioButton); 
      add(italicJRadioButton); 
      add(boldItalicJRadioButton); 

      // create logical relationship between JRadioButtons
      radioGroup = new ButtonGroup(); // create ButtonGroup
      radioGroup.add(plainJRadioButton); // add plain to group
      radioGroup.add(boldJRadioButton); // add bold to group
      radioGroup.add(italicJRadioButton); // add italic to group
      radioGroup.add(boldItalicJRadioButton); // add bold and italic

      // create font objects
      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont);

      // register events for JRadioButtons
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont));
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));
/*-------------------------------------------- */


      blackJRadioButton = new JRadioButton("Blac", true);
      redRadioButton = new JRadioButton("Red", false);
      blueJRadioButton = new JRadioButton("Blue", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      add(blackJRadioButton); 
      add(redRadioButton); 
      add(blueJRadioButton); 
      add(yellowJRadioButton); 

      colorGroup = new ButtonGroup();

      colorGroup.add(blackJRadioButton); 
      colorGroup.add(redRadioButton); 
      colorGroup.add(blueJRadioButton); 
      colorGroup.add(yellowJRadioButton); 

      blackColor = Color.BLACK;
      redColor = Color.RED;
      blueColor = Color.BLUE;
      yellowColor = Color.YELLOW;
      textField.setForeground(blackColor);

      blackJRadioButton.addItemListener(
         new ColorButtonHandler(blackColor));
      redRadioButton.addItemListener(
         new ColorButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorButtonHandler(blueColor));
      yellowJRadioButton.addItemListener(
         new ColorButtonHandler(yellowColor));
/*-------------------------------------------- */
   } 

   // private inner class to handle radio button events
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // font associated with this listener

      public RadioButtonHandler(Font f)
      {
         font = f; 
      } 
   
      // handle radio button events
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); 
      } 
   } 

   private class ColorButtonHandler implements ItemListener 
   {
      private Color font; // font associated with this listener

      public ColorButtonHandler(Color f)
      {
         font = f; 
      } 
   
      // handle radio button events
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setForeground(font); 
      } 
   } 
} 