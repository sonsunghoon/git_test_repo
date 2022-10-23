import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame() {

		
		this.setSize(400,600);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);


		
		SugangsincheongPanel sugangsincheongPanel = new SugangsincheongPanel();
		this.add(sugangsincheongPanel, BorderLayout.CENTER);
		

		
		LoginDialog loginDialog = new LoginDialog(this);
		loginDialog.setVisible(true);
		//부모를 붙여 주어야함 
	}
}
