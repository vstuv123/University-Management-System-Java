
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {
    
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails(){
        
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 500);
        add(jsp);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(20, 70, 80, 20);
        add(search);
        
        print = new JButton("Print");
        print.addActionListener(this);
        print.setBounds(120, 70, 80, 20);
        add(print);
        
        add = new JButton("Add");
        add.addActionListener(this);
        add.setBounds(220, 70, 80, 20);
        add(add);
        
        update = new JButton("Update");
        update.addActionListener(this);
        update.setBounds(320, 70, 80, 20);
        add(update);
       
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(420, 70, 80, 20);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 600);
        setLocation(220, 50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStudent();
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new StudentDetails();
    }
}
