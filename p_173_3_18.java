import java.util.Scanner;
import java.util.InputMismatchException;

public class p_173_3_18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 입력받을 준비하기 - import 문 작성 필요
		
		int studentId[] = new int[10]; // 학생 10명의 학번의 1차원 배열
		int score[] = new int[10]; 	   // 학생 10명의 점수의 1차원 배열
		
		System.out.println("10명 학생의 학번과 점수 입력");
		
		for (int i = 0; i < 10; i++) { //10명 학생의 수만큼 반복문 시작
			System.out.print((i + 1) + ">>"); // 배열의 시작이 0이기 때문에 +1로 1부터 출력되게끔 처리
			studentId[i] = scanner.nextInt(); // 학번 반복 입력
			score[i] =  scanner.nextInt();    // 점수 반복 입력
		}
		
		while (true) { // 반복 횟수를 알 수 없기에 while(true)문 반복으로 작성 
			
			int choice = 0; // 사용자가 입력한 메뉴 번호를 저장하기 위한 변수 (0은 안전하게 초기값)
			int hakBun = 0; // 사용자가 입력할 학번
			int searchScore = 0; // 사용자가 입력할 점수
			
			System.out.print("학번으로검색: 1 , 점수로 검색: 2, 끝내려면 3>>"); 
			choice = scanner.nextInt(); // 입력값을 choice 에 저장
			
			switch(choice) { // switch 문으로 조건 분기 (1번,2번,3번)
			
			case 1:	// 학번으로 검색할 때 1번
				while (true) {
					System.out.print("학번>>");
					
					try { // 예외 대비용
						hakBun = scanner.nextInt(); // 입력값을 hakBun에 저장
						int studentIndex = -1;
						for (int i = 0; i < studentId.length; i++) {
							if (studentId[i] == hakBun) {
								studentIndex = i;
								break;
							}
						}
						if (studentIndex == -1) {
							System.out.println(hakBun + "의 학생은 없습니다.");
						} else {
							System.out.println(score[studentIndex] + "점");
						}
						break;
					}
					catch(InputMismatchException e) { // try 에서 예외 상황 발생 시, 경고문 출력
						scanner.nextLine(); //잘못 입력한 토큰(문자 등등) 버리기
						System.out.println("경고!! 정수를 입력하세요.");
					}
				}
				break;
				
			case 2: // 점수로 검색할 때 2번
				while (true) {
					System.out.print("점수>>"); 
					
					try {
						searchScore = scanner.nextInt();
						String result = "";
						
						for (int i = 0; i < score.length; i++) {
							if (score[i] == searchScore) {
								if (result.equals("")) {
									result = String.valueOf(studentId[i]);
								} else {
									result = result + " " + studentId[i];
								}
							}
						}
						
						if (result.equals("")) {
							System.out.println("점수가 "+ searchScore + "인 학생은 없습니다.");
						} else {
						System.out.println("점수가 "+ searchScore + "인 학생은 " + result + " 입니다.");
						}
						break;
					}
					catch(InputMismatchException e) {
						scanner.next(); // 잘못 입력한 토큰(문자 등등) 하나 버리기
						System.out.println("경고!! 정수를 입력하세요.");
					}
				}
				break;
				
			case 3: // 프로그램을 종료할 때 3번
				System.out.print("프로그램 종료합니다.");
				return;
			}
		}
	}

}
