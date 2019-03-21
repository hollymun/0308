import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayStreamMain {

	public static void main(String[] args) {

		String str = "HelloWorld";
		
		//스트림 변수는 try 바깥 쪽에 생성
		ByteArrayInputStream bais = null;
		
		try {
			//바이트 배열에서 읽을 수 있는 스트림 생성 
			bais = new ByteArrayInputStream(str.getBytes());
/*			
			//바이트 단위로 읽기 
			while(true) {
				//한 바이트를 읽어서 result에 저장, 데이터가 없으면 -1 리턴 
				int result = bais.read();
				//읽은 데이터가 없으면 중단 
				if(result == -1) {
					break;
				}
			//읽은 데이터가 있으면 출력 
			//System.out.printf("%s", result);		//문자열 변환 안 하면 해시코드 값으로 출력 
			System.out.printf("%s", (char)result);	
			}
*/			
			//바이트 배열 단위로 읽기 
			while(true) {
				byte [] b = new byte[4];
				int len = bais.read(b);
				if(len <= 0) {
					break;
				}
				//읽은 개수만큼까지 읽어내야 함 
				//배열의 크기로 하면 안 됨 
//				for(int i=0; i<b.length; i=i+1) {
				for(int i=0; i<len; i=i+1) {
					System.out.printf("%c", (char)b[i]);
				System.out.println(i);
				}
			}
		
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}
		finally {
			//사용한 스트림 정리 
			try {
				bais.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
