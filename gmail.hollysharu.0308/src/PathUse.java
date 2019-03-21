import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PathUse {

	public static void main(String[] args) {
		//현재 작업 디렉토리에 있는 Donna.mp3 파일을
		//현재 작업 디렉토리에 있는 다이아나.mp3 파일로 복사 
/*		
		//복사할 파일과 복사될 파일의 경로를 생성
		Path from = Paths.get("../temp.txt");
		Path to = Paths.get("../temp222.txt");
		
		try {
			Files.copy(from, to);
			System.out.printf("파일 복사 성공\n");
		} catch (IOException e) {
			System.out.printf("예외 메시지:%s\n", e.getMessage());
		} finally {
			System.out.printf("예외 발생 여부에 상관 없이 수행할 일\n");
		}
*/

/*		
		//복사된 파일을 삭제 - java.nio.file.Files 클래스 참조 
		try {
			Path path = Paths.get("../temp.txt");
			Files.deleteIfExists(path);
			System.out.printf("삭제 성공\n");
		} 
		catch (IOException e) {
			System.out.printf("예외 메시지:%s\n", e.getMessage());
		}
*/
		
		//임시파일 생성
		try {
			//임시파일을 저장할 디렉토리를 설정 
			Path path = Paths.get("./");
			Files.createTempFile(path, "pre", ".tmp");
			System.out.printf("임시파일 만들기 성공\n");
			
			//오늘날짜.dat 파일을 생성  - calendar 클래스 이용 
			//오늘 날짜를 가지는 인스턴스를 생성 
			Calendar cal = new GregorianCalendar();
			//년월일 추출 
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			//추출한 년월일을 가지고 파일이름 만들기 
			//%2d - 2자리, %02d - 2자리인데 1자리 숫자는 앞에 0 추가 
			String today = String.format("%d-%02d-%02d.dat", year, month, day);
			System.out.printf("%s\n", today);
			//위의 파일명을 가지고 파일을 생성 
			Path todayPath = Paths.get(today);
			Files.createFile(todayPath);
			
			
		}
		catch(Exception e) {
			System.out.printf("예외 메시지:%s\n", e.getMessage());
		}
		
	}

}
