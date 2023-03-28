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

public class DepartmentList extends JFrame implements ActionListener{
	
	public DatabaseClass db;

    private JTable table;
    private DefaultTableModel tableModel;

    public  DepartmentList() {    	
    }
    
    // 생성자
    public DepartmentList(DatabaseClass db) {
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"학과코드", "이름", "교실"};
        List<Department> departmentList = db.getDepartmentList(); // ArrayList<Professor>의 갯수 만큼 행을 생성
        Object[][] data = new Object[departmentList.size()][3];
        
        for (int i = 0; i < departmentList.size(); i++) {
            Department department = departmentList.get(i);
            data[i][0] = department.getId();
            data[i][1] = department.getName();
            data[i][2] = department.getOffice();
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
        setTitle("학과 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new ProfessorList();
    }

	public void actionPerformed(ActionEvent e) {
        // Close the current screen                
        this.dispose();
        
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
}