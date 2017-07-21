package com.board.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.board.web.domain.Board;
import com.board.web.service.BoardService;
import com.board.web.util.Util;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	Board board;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list/{pageNo}")
	public String board(
			@PathVariable String pageNo, 
			Model model) throws Exception {
		logger.info("BoardController - board() {}", "ENTERED");
		Map<String, Object> map = new HashMap<>();
		map.put("group", "Board");
		int pageNumber = Integer.parseInt(pageNo);
		int theNumberOfRows = boardService.count(map);
		System.out.println("theNumberOfRows:    " + theNumberOfRows);
		int pagesPerOneBlock = 5,
			rowsPerOnePage = 5,
			theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
						: theNumberOfRows / rowsPerOnePage + 1,
			startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
			endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
						: theNumberOfPages,
			startRow = (pageNumber - 1) * rowsPerOnePage + 1,
			endRow = pageNumber * rowsPerOnePage,
			prevBlock = startPage - pagesPerOneBlock,
			nextBlock = startPage + pagesPerOneBlock;
		List<Board> list = new ArrayList<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		list = boardService.getArticleList(map);
		model.addAttribute("list", list);
		model.addAttribute("theNumberOfRows", theNumberOfRows);
		model.addAttribute("nextBlock", nextBlock);
		model.addAttribute("prevBlock", prevBlock);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("theNumberOfPages", theNumberOfPages);
		return "board:list";
	}
	
	@RequestMapping(value="/search/{pageNo}")
	public String search(Model model,@PathVariable String pageNo,
			@RequestParam("selectVal") String selectVal,@RequestParam("searchText") String searchText) throws Exception{
		System.out.println("넘어온 검색정보 : " + selectVal + "," + searchText);
		model.addAttribute("selectVal", selectVal);
		model.addAttribute("searchText", searchText);
		Map<String, Object> map = new HashMap<>();
		if(selectVal.equals("all")){
			System.out.println("검색정보 if all 문 들어옴: " + selectVal + "," + searchText);
			map.put("group", "Board");
			int pageNumber = Integer.parseInt(pageNo);
			int theNumberOfRows = boardService.count(map);
			System.out.println("theNumberOfRows:    " + theNumberOfRows);
			int pagesPerOneBlock = 5,
				rowsPerOnePage = 5,
				theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
							: theNumberOfRows / rowsPerOnePage + 1,
				startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
				endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
							: theNumberOfPages,
				startRow = (pageNumber - 1) * rowsPerOnePage + 1,
				endRow = pageNumber * rowsPerOnePage,
				prevBlock = startPage - pagesPerOneBlock,
				nextBlock = startPage + pagesPerOneBlock;
			List<Board> list = new ArrayList<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			list = boardService.getArticleList(map);
			model.addAttribute("list", list);
			model.addAttribute("theNumberOfRows", theNumberOfRows);
			model.addAttribute("nextBlock", nextBlock);
			model.addAttribute("prevBlock", prevBlock);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("theNumberOfPages", theNumberOfPages);
		}if(selectVal.equals("writer")){
			System.out.println("검색정보 if writer 문 들어옴: " + selectVal + "," + searchText);
			/*작성자 아이디로 찾기 구현해야함*/
		}if(selectVal.equals("title")){
			System.out.println("검색정보 if title 문 들어옴: " + selectVal + "," + searchText);
			map.put("group", "Board");
			map.put("title", searchText);
			int pageNumber = Integer.parseInt(pageNo);
			int theNumberOfRows = boardService.searchCountByTitle(map);
			System.out.println("theNumberOfRows:    " + theNumberOfRows);
			int pagesPerOneBlock = 5,
				rowsPerOnePage = 5,
				theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
							: theNumberOfRows / rowsPerOnePage + 1,
				startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
				endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
							: theNumberOfPages,
				startRow = (pageNumber - 1) * rowsPerOnePage + 1,
				endRow = pageNumber * rowsPerOnePage,
				prevBlock = startPage - pagesPerOneBlock,
				nextBlock = startPage + pagesPerOneBlock;
			List<Board> list = new ArrayList<>();
			map.clear();
			map.put("title", searchText);
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			list = boardService.searchByTitle(map);
			model.addAttribute("list", list);
			model.addAttribute("theNumberOfRows", theNumberOfRows);
			model.addAttribute("nextBlock", nextBlock);
			model.addAttribute("prevBlock", prevBlock);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("theNumberOfPages", theNumberOfPages);
		}
		return "board:searchlist";
	}
	
	@RequestMapping(value="/detail/{seq}")
	public String goDetailPage(@PathVariable int seq,Model model) throws Exception{
		logger.info("BoardController - goDetailPage() {}", "ENTERED");
		System.out.println("넘어온 seq : " + seq);
		Map<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		int check = boardService.updateHitCount(map);
		System.out.println("mapper 를 거치고온 updateHitCount int no : "  + check);
		board = boardService.selectArticle(map);
		model.addAttribute("seq", seq);
		model.addAttribute("id", board.getId());
		model.addAttribute("title", board.getTitle());
		model.addAttribute("content", board.getContent());
		return "board:detail";
	}
	
	@RequestMapping(value="/goWritePage")
	public String goWritePage(){
		logger.info("BoardController - goWritePage() {}", "ENTERED");
		return "board:write";
	}
	
	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(Model model,@RequestParam("title") String title,@RequestParam("id") String id, @RequestParam("content") String content) throws Exception{
		logger.info("BoardController - write() {}", "ENTERED");
		System.out.println("넘어온 정보값들 : " + title + "," + id + "," + content);
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("title", title);
		map.put("content", content);
		map.put("regdate", Util.nowDate());
		map.put("hit_cnt", 0);
		boardService.insertArticle(map);
		map.clear();
		map.put("group", "Board");
		int pageNumber = 1;
		int theNumberOfRows = boardService.count(map);
		System.out.println("theNumberOfRows:    " + theNumberOfRows);
		int pagesPerOneBlock = 5, 
			rowsPerOnePage = 5,
			theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
						: theNumberOfRows / rowsPerOnePage + 1,
			startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
			endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
						: theNumberOfPages,
			startRow = (pageNumber - 1) * rowsPerOnePage + 1,
			endRow = pageNumber * rowsPerOnePage,
			prevBlock = startPage - pagesPerOneBlock,
			nextBlock = startPage + pagesPerOneBlock;
		List<Board> list = new ArrayList<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		list = boardService.getArticleList(map);
		model.addAttribute("list", list);
		model.addAttribute("theNumberOfRows", theNumberOfRows);
		model.addAttribute("nextBlock", nextBlock);
		model.addAttribute("prevBlock", prevBlock);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("theNumberOfPages", theNumberOfPages);
		return "board:list";
	}
	
	@RequestMapping(value="/updateArticle",method=RequestMethod.POST)
	public String updateArticle(Model model,@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("seq") int seq) throws Exception{
		logger.info("BoardController - update() {}", "ENTERED");
		System.out.println("넘어온 데이터 값:    " + title + "," + content + "," + seq);
		Map<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		map.put("title", title);
		map.put("content",content);
		int check = boardService.updateArticle(map);
		System.out.println("mapper 를 거치고온 updateArticle int no : " + check);
		map.clear();
		map.put("group", "Board");
		int pageNumber = 1;
		int theNumberOfRows = boardService.count(map);
		System.out.println("theNumberOfRows:    " + theNumberOfRows);
		int pagesPerOneBlock = 5, 
			rowsPerOnePage = 5,
			theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
						: theNumberOfRows / rowsPerOnePage + 1,
			startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
			endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
						: theNumberOfPages,
			startRow = (pageNumber - 1) * rowsPerOnePage + 1,
			endRow = pageNumber * rowsPerOnePage,
			prevBlock = startPage - pagesPerOneBlock,
			nextBlock = startPage + pagesPerOneBlock;
		List<Board> list = new ArrayList<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		list = boardService.getArticleList(map);
		model.addAttribute("list", list);
		model.addAttribute("theNumberOfRows", theNumberOfRows);
		model.addAttribute("nextBlock", nextBlock);
		model.addAttribute("prevBlock", prevBlock);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("theNumberOfPages", theNumberOfPages);
		return "board:list";
	}
	
	@RequestMapping(value="/deleteArticle",method=RequestMethod.POST)
	public String deleteArticle(Model model, @RequestParam("seq")int seq) throws Exception{
		System.out.println("넘어온 데이터 값 : " + seq);
		Map<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		int check = boardService.deleteArticle(map);
		System.out.println("mapper 를 거치고온 deleteArticle int no : " + check);
		map.clear();
		map.put("group", "Board");
		int pageNumber = 1;
		int theNumberOfRows = boardService.count(map);
		System.out.println("theNumberOfRows:    " + theNumberOfRows);
		int pagesPerOneBlock = 5, 
			rowsPerOnePage = 5,
			theNumberOfPages = (theNumberOfRows % rowsPerOnePage == 0) ? theNumberOfRows / rowsPerOnePage
						: theNumberOfRows / rowsPerOnePage + 1,
			startPage = pageNumber - ((pageNumber - 1) % pagesPerOneBlock),
			endPage = ((startPage + rowsPerOnePage - 1) < theNumberOfPages) ? startPage + pagesPerOneBlock - 1
						: theNumberOfPages,
			startRow = (pageNumber - 1) * rowsPerOnePage + 1,
			endRow = pageNumber * rowsPerOnePage,
			prevBlock = startPage - pagesPerOneBlock,
			nextBlock = startPage + pagesPerOneBlock;
		List<Board> list = new ArrayList<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		list = boardService.getArticleList(map);
		model.addAttribute("list", list);
		model.addAttribute("theNumberOfRows", theNumberOfRows);
		model.addAttribute("nextBlock", nextBlock);
		model.addAttribute("prevBlock", prevBlock);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("theNumberOfPages", theNumberOfPages);
		return "board:list";
	}
}
