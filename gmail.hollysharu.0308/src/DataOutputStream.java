import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataOutputStream {

	public static void main(String[] args) {
//자료형마다 메소드 새로 호출해야 하기 때문에 
//많은 양의 데이터 호출이 여려우므로 잘 사용하지 않음 
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		//예외처리구문 
		try {
			fis = new FileInputStream("./sample.txt");
			dis = new DataInputStream(fis);
			System.out.printf("%d\n", dis.readInt());
			System.out.printf("%d\n", dis.readInt());			
				}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			//사용한 스트림 정리 
			try {
				fis.close();
				dis.close();
			}
			catch(Exception e){
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
