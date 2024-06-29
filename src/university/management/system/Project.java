
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    Project() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1260, 578, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.addActionListener(this);
        facultydetails.setBackground(Color.WHITE);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.addActionListener(this);
        studentdetails.setBackground(Color.WHITE);
        details.add(studentdetails);
        
        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this);
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.addActionListener(this);
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);
        
        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.addActionListener(this);
        facultyleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyleaveDetails);
        
        JMenuItem studentleaveDetails = new JMenuItem("Student Leave Details");
        studentleaveDetails.addActionListener(this);
        studentleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentleaveDetails);
        
        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.addActionListener(this);
        examinationDetails.setBackground(Color.WHITE);
        exam.add(examinationDetails);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        enterMarks.setBackground(Color.WHITE);
        exam.add(enterMarks);
        
        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.addActionListener(this);
        updateFacultyInfo.setBackground(Color.WHITE);
        updateInfo.add(updateFacultyInfo);
        
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.addActionListener(this);
        updateStudentInfo.setBackground(Color.WHITE);
        updateInfo.add(updateStudentInfo);
        
        // Fees Details
        JMenu fee = new JMenu("Fee Details");
        fee.addActionListener(this);
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        feeStructure.setBackground(Color.WHITE);
        fee.add(feeStructure);
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.addActionListener(this);
        feeForm.setBackground(Color.WHITE);
        fee.add(feeForm);
        
        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.addActionListener(this);
        ab.setBackground(Color.WHITE);
        about.add(ab);
            
        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setLocation(-10, 0);
        setSize(1300, 678);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")){
            System.exit(0);
        }else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){}
        }else if(msg.equals("Notepad")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){}
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculty Details")){
            new FacultyDetails();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateFaculty();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
        else if(msg.equals("Examination Results")){
            new ExaminationResults();
        }
        else if(msg.equals("About")){
            new About();
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else{
            new FeeDetails();
        }
    }
    
    public static void main(String[] args){
        new Project();
    }
}
