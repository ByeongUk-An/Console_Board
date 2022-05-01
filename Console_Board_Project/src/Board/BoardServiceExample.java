package Board;

import java.util.Scanner;

public class BoardServiceExample {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BoardDao dao = new BoardDao();

		while (true) {
			dao.getBoardList();
			int answer = Integer.parseInt(scanner.nextLine());

			if (answer == 1) {
				dao.boardInsert();
			} else if (answer == 2) {
				System.out.println("보고 싶은 게시글 번호를 선택하세요.");
				int select = Integer.parseInt(scanner.nextLine());
			} else if (answer == 3) {
				System.out.println("수정할 글 번호를 선택하세요 >>");
				int select = Integer.parseInt(scanner.nextLine());
				dao.boardUpdate(select);
			} else if (answer == 4) {
				System.out.println("삭제할 글 번호를 선택하세요.");
				int select = Integer.parseInt(scanner.nextLine());
				dao.boardDelete(select);
			} else if (answer == 5) {
				System.out.println("1.파일 읽기 2. 파일 쓰기덮어쓰기] :");
				answer = Integer.parseInt(scanner.nextLine());
				if (answer == 1) {
					dao.txtRead();
				} else if (answer == 2) {
					dao.txtWrite();
				} else {
					System.out.println("파일처리 종료 >>");
				}
			} else if (answer == 6) {
				break;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		System.out.println("게시판 프로그램이 종료되었습니다.");
	}

}
