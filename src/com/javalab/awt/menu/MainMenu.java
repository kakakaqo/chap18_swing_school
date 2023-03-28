package com.javalab.awt.menu;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
/**
 * 초기화면 - 메인 메뉴
 *  - 프로그램 구동후 가장 먼저 보여지는 화면
 *  - 여기에서 다른 화면으로 이동함.
 */
public class MainMenu extends JFrame implements ActionListener {
	public DatabaseClass db;	// = DatabaseClass.getInstance();	// new DatabaseClass();	// = new DatabaseClass();
	
    // GUI components
    private JLabel titleLabel;
    private JButton studentButton;
    private JButton professorButton;
    private JButton departmentButton;
    private JButton takesButton;
    private JButton studentListButton;
    private JButton professorListButton;
    private JButton departmentListButton;
    private JButton takesListButton;
    private JButton exitButton;
    
    // 기본 생성자
//    public MainMenu() {   
//    	db = new DatabaseClass();
//    	System.out.println("여기는 기본 생성자");
//    }
    
    // 생성자
    public MainMenu(DatabaseClass db) {
    	this.db = db;
    			
        // Set up the GUI components
        setTitle("Registration Form");
        setLayout(new GridLayout(10, 2));
        setSize(300, 400);
        
        // Title label
        titleLabel = new JLabel("Select an option:");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
        
        // Student Register button
        studentButton = new JButton("Student Register");
        studentButton.addActionListener(this);
        add(studentButton);
        
        // Professor Register button
        professorButton = new JButton("Professor Register");
        professorButton.addActionListener(this);
        add(professorButton);
        
        // Department Register button
        departmentButton = new JButton("Department Register");
        departmentButton.addActionListener(this);
        add(departmentButton);
        
        // Takes Register button
        takesButton = new JButton("Takes Register");
        takesButton.addActionListener(this);
        add(takesButton);
        
        // Student List button
        studentListButton = new JButton("Student List");
        studentListButton.addActionListener(this);
        add(studentListButton);
        
        // Professor List button
        professorListButton = new JButton("Professor List");
        professorListButton.addActionListener(this);
        add(professorListButton);
        
        // Department List button
        departmentListButton = new JButton("Department List");
        departmentListButton.addActionListener(this);
        add(departmentListButton);
        
        // Takes List button
        takesListButton = new JButton("Takes List");
        takesListButton.addActionListener(this);
        add(takesListButton);
        
        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == studentButton) {
            System.out.println("Student Register");
            
            // 현재 화면 닫기                
            this.dispose();
            
            // 이동해갈 화면 객체 생성
            StudentForm studentForm = new StudentForm(db);
            
            // 이동해갈 화면 보이기
            studentForm.setVisible(true);
            
        } else if (e.getSource() == professorButton) {
            System.out.println("Professor Register");
            
            this.dispose();
            
            ProfessorForm professorForm = new ProfessorForm(db);
            
            professorForm.setVisible(true);            
        } else if (e.getSource() == departmentButton) {
            System.out.println("Department Register");
            
            this.dispose();
            
            DepartmentForm departmentForm = new DepartmentForm(db);
            
            departmentForm.setVisible(true);              
        } else if (e.getSource() == takesButton) {
            System.out.println("Takes Register");
            
            this.dispose();
            
            TakesForm takesForm = new TakesForm();
            	
            takesForm.setVisible(true);             
        } else if (e.getSource() == studentListButton) {
            System.out.println("Student List");            
            // 현재 화면 닫기                
            this.dispose();            
            // 이동해갈 화면 객체 생성
            StudentList studentList = new StudentList(db);
            // 이동해갈 화면 보이기
            studentList.setVisible(true);            
        } else if (e.getSource() == professorListButton) {
            System.out.println("Professor List");
        	// 현재 화면 닫기                
            this.dispose(); 
           // 이동해갈 화면 객체 생성
          ProfessorList professorList = new ProfessorList(db);
           // 이동해갈 화면 보이기
          professorList.setVisible(true);
        } else if (e.getSource() == departmentListButton) {
            System.out.println("Department List");
            
            this.dispose();
            
            DepartmentList departmentList = new DepartmentList(db);
            
            departmentList.setVisible(true);
        } else if (e.getSource() == takesListButton) {
            System.out.println("Takes List");
            this.dispose();
            
            TakesList takesList = new TakesList(db);
            
            takesList.setVisible(true);
 } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new MainMenu(new DatabaseClass());
    }
}