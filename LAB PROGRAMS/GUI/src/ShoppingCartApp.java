import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ShoppingCartApp {
    private JFrame frame;
    private DefaultListModel<Item> cartModel;
    private JList<Item> cartList;
    private double totalAmount;

    JLabel totalLabel;

    public ShoppingCartApp() {
        frame = new JFrame("Shopping Cart App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);

        JPanel itemPanel = createItemPanel();
        JPanel cartPanel = createCartPanel();
        JPanel totalPanel = new JPanel(new FlowLayout());

        JLabel totalLabelT = new JLabel("Total Amount: $");
        totalLabel = new JLabel("00");
        totalPanel.add(totalLabelT);
        totalPanel.add(totalLabel);

        frame.setLayout(new BorderLayout());
        frame.add(itemPanel, BorderLayout.WEST);
        frame.add(cartPanel, BorderLayout.CENTER);
        frame.add(totalPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createItemPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Available Items:");
        panel.add(label);

        JComboBox<Item> itemComboBox = new JComboBox<>();
        itemComboBox.addItem(new Item("Samsung S23", 10.0));
        itemComboBox.addItem(new Item("Apple 15 Pro", 15.0));
        itemComboBox.addItem(new Item("Vivo T2 5g", 20.0));
        itemComboBox.addItem(new Item("Nokio 6a", 25.0));
        panel.add(itemComboBox);

        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item selected = (Item) itemComboBox.getSelectedItem();
                cartModel.addElement(selected);
                assert selected != null;
                totalAmount += selected.price;
                totalLabel.setText(String.valueOf(totalAmount));
            }
        });
        panel.add(addButton);

        return panel;
    }

    private JPanel createCartPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Shopping Cart:");
        panel.add(label);

        JScrollPane scrollPane = new JScrollPane(cartList);
        panel.add(scrollPane);

        return panel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShoppingCartApp();
        });
    }
}
