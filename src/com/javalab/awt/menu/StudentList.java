package com.javalab.awt.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentList extends JFrame implements ActionListener{
	public DatabaseClass db;

    private JTable table;
    private DefaultTableModel tableModel;

    public StudentList() {    	
    }
    
    // 생성자
    public StudentList(DatabaseClass db) {
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"ID", "주민등록번호", "이름", "학년", "주소", "학과"};
        List<Student> studentList = db.getStudentList(); // ArrayList<Student>의 갯수 만큼 행을 생성
        Object[][] data = new Object[studentList.size()][6];
        
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            data[i][0] = student.getId();
            data[i][1] = student.getJumin();
            data[i][2] = student.getName();
            data[i][3] = student.getYear();
            data[i][4] = student.getAddress();
            data[i][5] = student.getDepartment();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        
        // Set up the button to add a new student
       JButton closeButton = new JButton("닫기");
       
        // 액션 리스너 부착
        closeButton.addActionListener(this);	// 액션 리스터 부착

        // Set up the main panel with the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


	public void actionPerformed(ActionEvent e) {
        // Close the current screen                
        this.dispose();
        
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
}