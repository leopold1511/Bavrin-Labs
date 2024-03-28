
import SubPackage.Generator;
import SubPackage.CustomerInfo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class GUI extends JFrame {

    public GUI() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Профессоры");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");

        CustomerInfo[] info = Generator.makeCustomersInfo(20);
        DefaultMutableTreeNode[] customerNodes = new DefaultMutableTreeNode[info.length];
        for (int i = 0; i < info.length; i++) {
            customerNodes[i] = new DefaultMutableTreeNode(info[i].customer);
            for (int j = 0; j < info[i].books.length; j++) {
                customerNodes[i].add(new DefaultMutableTreeNode(info[i].books[j]));
            }
            if (info[i].isProfessor) {
                professorNode.add(customerNodes[i]);
            } else studentNode.add(customerNodes[i]);
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