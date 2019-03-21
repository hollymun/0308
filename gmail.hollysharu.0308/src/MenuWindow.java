import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EtchedBorder;

public class MenuWindow extends JFrame {

	JLabel label;

	
	JMenuBar menuBar;
	

	public MenuWindow() {
		setTitle("메뉴 테스트");
		setSize(300, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//1 패널 생성 2 컴포넌트 생성 3 패널에 컴포넌트 추가 
		JPanel p = new JPanel();
		label = new JLabel();
		p.add(label);
		
		//패널을 현재 윈도우에 추가 
		add(p);
		
		
		
		menuBar = new JMenuBar();
		//p.add(menu);
		
		//메인메뉴 생성
		JMenu menu = new JMenu("색상 변경(M)");
		JMenu menu2 = new JMenu("폰트 변경(F)");
		menu.setMnemonic('M');
		menu2.setMnemonic('F');
		
		//메뉴의 하위항목을 생성
		JMenuItem fore = new JMenuItem("글자색 변경(C)");
		JMenuItem back = new JMenuItem("배경색 변경(B)");
		fore.setMnemonic('C');
		back.setMnemonic('B');
		
		JMenuItem go = new JMenuItem("고딕(K)");
		go.setMnemonic('K');
		
		
		//이벤트 처리를 위한 리스너 인스턴스 생성
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == fore) {

					//JColorChooser color = new JColorChooser();
					//Color col = color.showDialog(null, "글자색 선택", Color.CYAN);
					//static 메소드기 때문에 아래처럼 생성 가능 
					Color col = JColorChooser.showDialog(null, "글자색 선택", Color.CYAN);
					label.setForeground(col);
				}
				else if(e.getSource() == back) {
					//System.out.printf("배경색 변경");
					Color col = JColorChooser.showDialog(null, "배경색 선택", Color.BLUE);
					//레이블은 배경이 없어서 보더를 설정한 후 배경색을 적용 
					EtchedBorder border = new EtchedBorder();
					label.setBorder(border);
				}
				else if(e.getSource() == go) {
					System.out.printf("고딕 변경");
				}			
			}
			
		};
		fore.addActionListener(action);
		back.addActionListener(action);
		go.addActionListener(action);
		
		
		
		//메인메뉴에 하위항목들 추가
		menu.add(fore);
		menu.add(back);
		
		menu2.add(go);
		
		//메뉴바에 메뉴를 추가
		menuBar.add(menu);
		menuBar.add(menu2);

		//팝업 메뉴 인스턴스 생성 
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem item1 = new JMenuItem("첫 번째 팝업 메뉴");
		popupMenu.add(item1);
		JMenuItem item2 = new JMenuItem("두 번째 팝업 메뉴");
		popupMenu.add(item2);
		
		MouseListener mouseListener = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//마우스 오른쪽 버튼을 눌렀는지 감지한 후 
				if(e.isPopupTrigger()) {
					//아래만 쓰면 왼쪽/오른쪽 클릭시 모두 반응함
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//마우스 오른쪽 버튼을 눌렀는지 감지한 후 
				if(e.isPopupTrigger()) {
					//아래만 쓰면 왼쪽/오른쪽 클릭시 모두 반응함
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.printf("mouse Entered\n");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.printf("mouse Exited\n");
			}
			
		};
		//윈도우에 마우스리스너 연결
		addMouseListener(mouseListener);
		
		//메뉴바를 윈도우에 추가 
		this.setJMenuBar(menuBar);

		
		
		setVisible(true);
	}
}
