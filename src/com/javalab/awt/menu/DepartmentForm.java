package com.javalab.awt.menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentForm extends JFrame implements ActionListener{

	public DatabaseClass db;

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField;
    private JTextField nameField;
    private JTextField officeField;


    public DepartmentForm() {    	
    }
    
    // 생성자
    public DepartmentForm(DatabaseClass db) {
    	this.db = db;

        // Set up the input fields and labels
        idField = new JTextField(10);
        nameField = new JTextField(10);
        officeField = new JTextField(10);


        JLabel idLabel = new JLabel("학과코드:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel officeLabel = new JLabel("교실");

        // Set up the button to add a new student
        JButton addButton = new JButton("추가");
        
        // 액션 리스너 부착
        addButton.addActionListener(this);	// 액션 리스터 부착
 

        // Set up the main panel with the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(officeLabel);
        inputPanel.add(officeField);
        

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new StudentForm();
    }

	public void actionPerformed(ActionEvent e) {
		
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String office = officeField.getText();

        // 화면에서 입력받은 데이터로 학생 객체 생성
        Department department = new Department(id, name, office);
        // 생성한 학생 객체를 ArrayList<Student> studentList에 저장
        this.db.addDepartment(department);
        
		// 학생 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "등록완료");
		
		// 현재까지 등록된 학생수 확인
        System.out.println("학생 객체 등록 완료 학생수 : " + db.getDepartmentCount());
		
        // 학생 등록 끝나서 현재의 화면 닫기                
        this.dispose();
        
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
}