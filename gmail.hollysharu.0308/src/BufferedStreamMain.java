import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JOptionPane;

public class BufferedStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
/*		
		try {
			//파일 출력 스트림을 생성 
			fos = new FileOutputStream("/Users/mac/eclipse-workspace/gmail.hollysharu.0308/sample.txt");
			//다른 출력 스트림을 이용해서 버퍼 스트림을 생성 
			ps = new PrintStream(fos);
			
			ps.println("안녕하세요");
			ps.println("우리집 고양이는 하루버지");
			ps.printf("안뇽");
			
			JOptionPane.showMessageDialog(null, "텍스트 저장 성공");
			
				}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			//사용한 스트림 정리 
			try {
				ps.close();
			}
			catch(Exception e){
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			}
				}
*/
		
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		
		//예외처리구문 
		try {
			//파일 입력 스트림을 생성 
			fis = new FileInputStream("/Users/mac/eclipse-workspace/gmail.hollysharu.0308/sample.txt");
			//다른 출력 스트림을 이용해서 버퍼 스트림을 생성 
			bis = new BufferedInputStream(fis);
			byte [] b = new byte[bis.available()];
			
			bis.read(b);
			String str = new String(b);
			
			JOptionPane.showMessageDialog(null, str);
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			//사용한 스트림 정리 
			try {
				ps.close();
			}
			catch(Exception e){
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
