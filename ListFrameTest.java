import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrameTest extends JFrame {

    private final JList<String> colorJList;
    private final JList<String> sizeJList;

    private static final String[] colorNames = {"Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW};

    private static final String[] sizeNames = {"Small", "Medium", "Large"}; 

    public ListFrameTest() {
        super("List Test");
        setLayout(new FlowLayout());


        colorJList = new JList<>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorJList.addListSelectionListener(this::colorListSelectionChanged); 

   
        sizeJList = new JList<>(sizeNames);
        sizeJList.setSelectedIndex(0); 
        sizeJList.setVisibleRowCount(2);
        sizeJList.addListSelectionListener(this::sizeListSelectionChanged);


        JScrollPane colorScrollPane = new JScrollPane(colorJList);
        JScrollPane sizeScrollPane = new JScrollPane(sizeJList);

  
        add(colorScrollPane);
        add(sizeScrollPane);

        setSize(getSizeForSizeSelection(sizeJList.getSelectedValue()));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void colorListSelectionChanged(ListSelectionEvent event) {
        int selectedIndex = colorJList.getSelectedIndex();
        if (selectedIndex != -1) { 
            getContentPane().setBackground(colors[selectedIndex]);
        }
    }

    private void sizeListSelectionChanged(ListSelectionEvent event) {
        int selectedIndex = sizeJList.getSelectedIndex();
        if (selectedIndex != -1) { 
            String selectedSize = sizeNames[selectedIndex];
            setSize(getSizeForSizeSelection(selectedSize));
        }
    }

    private Dimension getSizeForSizeSelection(String selectedSize) {
        switch (selectedSize) {
            case "Small":
                return new Dimension(350, 150);
            case "Medium":
                return new Dimension(500, 200);
            case "Large":
                return new Dimension(1200, 450);
            default:
                return new Dimension(350, 150);
        }
    }

    public static void main(String[] args) {
       new ListFrameTest();
    }
}
