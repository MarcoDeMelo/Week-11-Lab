package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.DataModel;
import java.awt.*;

public class MainFrame extends JFrame{
   private Container contentPane;
   private JTable table = new JTable();
   private JPanel titlePanel = new JPanel();
   private JPanel mainPanel = new JPanel();
   private JPanel controlPanel = new JPanel();
   private JLabel lblTitle = new JLabel("COMP 305");
   private JButton btnUpdate = new JButton("Update");
   private JScrollPane scrollPane; //Not declared because we want it to be dynamic i guess

//Constructor for the mainframe class


   public MainFrame(String tittle)
   {
     setTitle(tittle);
     setSize(800,600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     initLayout();
   }

   private void initLayout() 
   {
     contentPane = this.getContentPane();
     //TittleBar
     contentPane.add(titlePanel, "North"); //We give it a constraint of North
     titlePanel.add(lblTitle);
     String fontName = lblTitle.getFont().getFontName();
     lblTitle.setFont(new Font(fontName, 0, 24));

     //Main panel
     mainPanel.setBackground(new Color(0xAAFFFF));
     contentPane.add(mainPanel,"Center");
     String [] headers = {"Column 1", "Column 2", "Column 3", "Column 4"};

     table = new JTable(new DefaultTableModel(DataModel.getData(), headers));
     scrollPane = new JScrollPane(table);
     mainPanel.add(scrollPane);

     btnUpdate.addActionListener(
        event -> {
            table.setModel(new DefaultTableModel(DataModel.getData(), headers));
        }
     );

     //Control Panel
     controlPanel.add(btnUpdate);
     contentPane.add(controlPanel, "South");

     pack();

   }
}
