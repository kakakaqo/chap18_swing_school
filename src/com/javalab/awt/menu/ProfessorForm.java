package com.javalab.awt.menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorForm extends JFrame implements ActionListener{

	public DatabaseClass db;

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField;
    private JTextField juminField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField gradeField;
    private JTextField hiredateField;

    public ProfessorForm() {    	
    }
    
    // 생성자
    public ProfessorForm(DatabaseClass db) {
    	this.db = db;

        // Set up the input fields and labels
        idField = new JTextField(10);
        juminField = new JTextField(10);
        nameField = new JTextField(10);
        departmentField = new JTextField(10);
        gradeField = new JTextField(10);
        hiredateField = new JTextField(10);

        JLabel idLabel = new JLabel("학번:");
        JLabel juminLabel = new JLabel("주민등록번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel departmentLabel = new JLabel("학과:");
        JLabel gradeLabel = new JLabel("그레이드:");
        JLabel hiredateLabel = new JLabel("입사년도:");

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
        inputPanel.add(juminLabel);
        inputPanel.add(juminField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);
        inputPanel.add(hiredateLabel);
        inputPanel.add(hiredateField);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("교수 정보 입력");
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
		
        String id = idField.getText();
        String jumin = juminField.getText();
        String name = nameField.getText();
        int department = Integer.parseInt(departmentField.getText());
        String grade = gradeField.getText();
        String hiredate = hiredateField.getText();

        // 화면에서 입력받은 데이터로 학생 객체 생성
        Professor professor = new Professor(id, jumin, name, department, grade, hiredate );
        // 생성한 학생 객체를 ArrayList<Student> studentList에 저장
        this.db.addProfessor(professor);
        
		// 학생 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "등록완료");
		
		// 현재까지 등록된 학생수 확인
        System.out.println("교수 객체 등록 완료 수 : " + db.getProfessorCount());
		
        // 교수 등록 끝나서 현재의 화면 닫기                
        this.dispose();
        
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
}