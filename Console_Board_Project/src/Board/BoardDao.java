package Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDao {
	Scanner scanner = new Scanner(System.in);
	List<BoardVo> boardList = new ArrayList<>();

	public void getBoardList() {
		System.out.println("            < < 게시판 > >");
		System.out.println("번호    제목        작성자    작성일  ");
		System.out.println("-------------------------------------");
		if (boardList.isEmpty()) {
			System.out.println("                  게시글 없");
		} else {
			for (BoardVo vo : boardList) {
				System.out.printf("%-3d | %-15s | %3s | %-1s\n", boardList.indexOf(vo) + 1, vo.getTitle(),
						vo.getWriter(), vo.getRegistDate());
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("1. 새로쓰기 2. 상세보기 3. 수정 4. 삭제 5. 파일 6.종료");
		
	}
	
	public void boardInsert() {
		BoardVo vo = new BoardVo();
		
		System.out.println("글제목(취소 : quit): ");
		String title = scanner.nextLine();
		if(title.equals("quit")) {
			System.out.println("작성이 취소되었습니다.");
			return;
		}
		
		System.out.println("작성자(취소 : quit): ");
		String writer = scanner.nextLine();
		if(writer.equals("quit")) {
			System.out.println("작성이 취소되었습니다.");
			return;
		}
		System.out.println("작성자(취소 : quit): ");
		String content = scanner.nextLine();
		if(content.equals("quit")) {
			System.out.println("작성이 취소되었습니다.");
			return;
		}
		
		vo.setNum(boardList.indexOf(vo));
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}