import java.util.Scanner;
public class p_111_2_6 {

	public static void main(String[] args) {
		
		System.out.print("나이를 입력하세요>>"); // 나이 입력 메세지 출력
		Scanner scanner = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성

			int age = scanner.nextInt();
			int cho = age;
			
			int red = cho/ 10;
			cho %= 10;
			
			int blue = cho / 5;
			cho %= 5;
			
			int yellow = cho;
			
			int sum = red + blue + yellow;
			
			System.out.print("빨간 초 " + red + "개, " + "파랑 초 " + blue + "개, " + "노란 초 " + yellow + "개." + "총 " + sum + "개가 필요합니다."); 
		
	}
}
