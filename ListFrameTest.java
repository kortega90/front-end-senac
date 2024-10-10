import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrameTest extends JFrame {

    private final JList<String> colorJList;
    private final JList<String> sizeJList;

    private static final String[] colorNames = {"Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow", "Peru"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW, new Color(205, 133, 63)};

    private static final String[] sizeNames = {"Small", "Medium", "Large"};

    public ListFrameTest() {
        super("List Test");
        setLayout(new FlowLayout());

        // Create JLists
        colorJList = new JList<>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorJList.addListSelectionListener(this::colorListSelectionChanged);

        sizeJList = new JList<>(sizeNames);
        sizeJList.setSelectedIndex(0);
        sizeJList.setVisibleRowCount(2);
        sizeJList.addListSelectionListener(this::sizeListSelectionChanged);

        // Create scroll panes with custom renderer for consistent color highlighting
        JScrollPane colorScrollPane = new JScrollPane(colorJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        colorScrollPane.setViewportView(colorJList);
        colorJList.setCellRenderer(new CustomListCellRenderer(colors));

        JScrollPane sizeScrollPane = new JScrollPane(sizeJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sizeScrollPane.setViewportView(sizeJList);

        // Add components and set initial size
        add(colorScrollPane);
        add(sizeScrollPane);
        setSize(getSizeForSizeSelection(sizeJList.getSelectedValue()));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void colorListSelectionChanged(ListSelectionEvent event) {
        int selectedIndex = colorJList.getSelectedIndex();
        if (selectedIndex != -1) {
            // Update both frame background and selected item background
            getContentPane().setBackground(colors[selectedIndex]);
            colorJList.setSelectedIndex(selectedIndex); // Reset focus (optional)
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

    // Custom renderer to highlight selected item with consistent background color
    private static class CustomListCellRenderer extends DefaultListCellRenderer {
        private final Color[] colors;

        public CustomListCellRenderer(Color[] colors) {
            this.colors = colors;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                setBackground(colors[index]);
            } else {
                setBackground(list.getBackground()); // Use default background for unselected items
            }
            return this;
        }
    }

    public static void main(String[] args) {
        new ListFrameTest();
      }
   }
