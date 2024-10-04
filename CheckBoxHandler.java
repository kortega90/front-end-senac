// private inner class for ItemListener event handling

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class CheckBoxHandler implements ItemListener {
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;
    private JCheckBox underlineJCheckBox;
    private JTextPane textField;

    CheckBoxHandler(JTextPane textField, JCheckBox boldJCheckBox, JCheckBox italicJCheckBox,
            JCheckBox underlineJCheckBox) {
        this.textField = textField;
        this.boldJCheckBox = boldJCheckBox;
        this.italicJCheckBox = italicJCheckBox;
        this.underlineJCheckBox = underlineJCheckBox;
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        Font font = null; // stores the new Font

        // determine which CheckBoxes are checked and create Font
        if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
        else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);
        else
            font = new Font("Serif", Font.PLAIN, 14);

        textField.setFont(font);


        StyledDocument doc = textField.getStyledDocument();

        if (underlineJCheckBox.isSelected()) {
            MutableAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setUnderline(attributes, true);
            doc.setCharacterAttributes(0, textField.getText().length(), attributes, false);
        } else {
            MutableAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setUnderline(attributes, false);
            doc.setCharacterAttributes(0, textField.getText().length(), attributes, false);
        }



    }
}