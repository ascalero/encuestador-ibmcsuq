/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Ascalero
 */
import org.jdesktop.swingx.*;
import javax.swing.*;
import java.awt.*;

public class TaskPaneExample{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TaskPaneExample();
            }});
        }

        public TaskPaneExample() {
            JFrame frame = new JFrame("TaskPane Example 1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(doInit(), BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }

        private Component doInit() {
            JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();
            taskpanecontainer.setLayout(new VerticalLayout(2));

            final JXTaskPane taskpane1 = new JXTaskPane(){
                public void setCollapsed(boolean w){
                    super.setCollapsed(w);
                }};
            taskpane1.setTitle("First TaskPane");
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.red);
            panel1.setSize(100,100);
            taskpane1.add(panel1);
            taskpanecontainer.add(taskpane1);

            JXTaskPane taskpane2 = new JXTaskPane(){
                public void setCollapsed(boolean w){
                    super.setCollapsed(w);
                }};
            taskpane2.setTitle("My Tasks");
            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.blue); 
            panel2.setSize(100,100);
            taskpane2.add(panel2);
            
            taskpanecontainer.add(taskpane2);
            taskpanecontainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

            return taskpanecontainer;
        }
    }

