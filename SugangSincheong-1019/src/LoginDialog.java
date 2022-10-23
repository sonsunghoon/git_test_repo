import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField tfId;
	private JPasswordField tfPassword;
	private SLogin sLogin;
	
	public LoginDialog(Frame parent) {
		
		super(parent);
		// logindialog Jdialog

		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		LayoutManager layoutManger = new BoxLayout(this,BoxLayout.X_AXIS );
		this.setLayout(layoutManger);
		
		
		this.setTitle("로그인");
		this.setSize(200,200);
		
		//LayoutManager은 자식을 위에 만들어 놓고 사용 한다. 
		LayoutManager layoutManager = new GridLayout(3, 2);
		this.setLayout(layoutManager);		
		

   
		JLabel lbId=new JLabel("아이디");    
		this.add(lbId);
		 		
		this.tfId = new JTextField(10);  
		this.tfId.setColumns(10);
		this.add(tfId);
		
		JLabel lbPassword =new JLabel("비밀번호"); 
		this.add(lbPassword);
		
		this.tfPassword = new JPasswordField(10);   
		this.add(tfPassword);
		
		
		JButton btLogin = new JButton("Login");    
		this.add(btLogin,BorderLayout.SOUTH);
		
		ActionHandler actionHandler = new ActionHandler();
		btLogin.addActionListener(actionHandler);
		
		this.sLogin = new SLogin();
	}
	
	public String login() {
		String id = this.tfId.getText();
		VAccount vAccount = this.sLogin.login(id);
		if (id.equals(vAccount.getId())) {
			return vAccount.getId();
		}else
		return null;
		
	}
	
	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			login() ;
			if(login()!=null) {
           	 
                JOptionPane.showMessageDialog( null, login()+"환영합니다." );
                
        } else {

            JOptionPane.showMessageDialog( null , "로그인 실패");

        }
			
			
		}		
	}
}
