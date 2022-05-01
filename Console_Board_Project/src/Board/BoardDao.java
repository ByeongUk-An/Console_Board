package Board;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
			System.out.println("                게시글이 없습니다.");
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String registDate = sdf.format(new Date());
		vo.setRegistDate(registDate);
		
		boardList.add(vo);
		System.out.println("글이 추가되었습니다.n");
		
	}
	
	public void boardDetail(int select) {
		if(boardList.isEmpty()) {
			System.out.println("게시글이 존재하지 않습니다.");
			return;
		}
		BoardVo vo = new BoardVo();
		vo = boardList.get(select - 1);
		System.out.println("No." + select);
		System.out.println("제목    :" + vo.getTitle());
		System.out.println("작성자    :" + vo.getWriter());
		System.out.println("----------------------------------------------");
		System.out.println(vo.getContent());
		System.out.println("----------------------------------------------");
		System.out.println("1. 수정 2. 삭제 3. 목록");
		select = Integer.parseInt(scanner.nextLine());
		if(select == 1) {
			boardUpdate(boardList.indexOf(vo)+ 1);
		}else if(select == 2) {
			boardDelete(boardList.indexOf(vo) + 1);
		}else if(select == 3) {
			return;
		}
	}
	public void boardUpdate(int select) {
		if(boardList.isEmpty()) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		
		BoardVo vo = new BoardVo();
		vo = boardList.get(select - 1);
		
		System.out.println("글제목(취소 : quit): ");
		String title = scanner.nextLine();
		if(title.equals("quit")) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}
		System.out.println("작성자(취소 : quit):");
		String writer = scanner.nextLine();
		if(writer.equals("quit")) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}
		
		System.out.println("글내용(취소 : quit):");
		String content = scanner.nextLine();
		if(content.equals("quit")) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(수정됨)");
		String registDate = sdf.format(new Date());
		vo.setRegistDate(registDate);
		
		boardList.set(boardList.indexOf(vo), vo);
		System.out.println("글이 수정되었습니다.\n");
	}
	public void boardDelete(int select) {
		if(boardList.isEmpty()) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		
		BoardVo vo = new BoardVo();
		vo = boardList.get(select - 1);
		boardList.remove(boardList.indexOf(vo));
	}
	
	public void txtRead() throws Exception {
		Reader reader = new FileReader("C:/Temp/BoardDB.txt");
		while(true) {
			int data = reader.read();
			if(data == -1) {
				break;
			}
			System.out.println((char)data);
		}
		reader.close();
		System.out.println("데이터 로드 완료");
	}
	
	public void txtWrite() throws Exception {
		Writer writer = new FileWriter("C:/Temp/BoardDB.txt");
		String[] data = new String[100000];
		for(int i = 0; i < boardList.size(); i++) {
			BoardVo vo = boardList.get(i);
			data[i] = boardList.indexOf(vo) + "|\t" + vo.getTitle() + "|\t" + vo.getContent() + "|\t" + vo.getWriter() + "|\t" + vo.getRegistDate()
			+ "|\t\n";
			writer.write(data[i]);
		}
		writer.flush();
		
		writer.close();
		System.out.println("현재 데이터 저장완료");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}