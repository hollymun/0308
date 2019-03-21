import java.io.FileInputStream;
import java.io.PrintStream;

public class FileStreamMain {

	public static void main(String[] args) {
/*
		//파일에 기록을 하기 위한 변수 
		FileOutputStream fos = null;
		try {
			//파일 경로를 가지고 파일 출력 스트림을 만들기 
			//출력 스트림에서 뒤에 true를 대입하면 추가모드가 됨
			fos = new FileOutputStream("./sample.txt", true);
			//파일에 바이트 단위로 기록 
			fos.write('H');
			fos.write("겸디쓰".getBytes());
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			}
			catch(Exception e) {
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();				
			}
		}
*/
		
		FileInputStream fis = null;

		try {			
			//sample.txt의 내용을 읽을 수 있는 스트림 생성 
			fis = new FileInputStream("./sample.txt");
/*			while(true) {
				int result = fis.read();
				if(result == -1) {
					break;
				}
				//바이트 단위가 아닌 한글을 읽어오는 경우 깨질 수 있음 
				System.out.printf("%c", (char)result);
			}
*/				
			//한글을 읽을 때는 모아서 한꺼번에 읽어야 읽을 수 있음
			//읽은 데이터를 전부 저장할 수 있는 바이트 배열을 생성 
			byte [] b = new byte[fis.available()];
			//전체를 읽어서 b에 저장 
			fis.read(b);
			//전체를 문자로 변환해서 출력
			String hangul = new String(b);
			System.out.printf("%s\n", hangul);
			
				
				
			
		} 
		catch (Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				fis.close();
			} 
			catch (Exception e) {
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			} 
		}		
		
		
		
		
	}

}
