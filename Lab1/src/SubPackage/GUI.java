package SubPackage;

import Customer.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.util.List;

public class GUI extends JFrame {

    public GUI() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Профессоры");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");

        List<Customer> listOfCustomers = Generator.generateCustomers(20);
        for (Customer customer : listOfCustomers) {
            if (customer.isProfessor()) {
                professorNode.add(customer.createNode());
            } else {
                studentNode.add(customer.createNode());
            }
        }
        root.add(professorNode);
        root.add(studentNode);

        JTree tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library");
        this.setSize(200, 200);
        this.setVisible(true);
    }
}