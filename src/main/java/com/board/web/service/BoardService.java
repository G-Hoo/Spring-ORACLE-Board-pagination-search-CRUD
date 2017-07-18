package com.board.web.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.board.web.domain.Board;
import com.board.web.mapper.BoardMapper;

@Service
public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	BoardMapper mapper;
	@Autowired
	Board board;
	
	@SuppressWarnings("unchecked")
	public int insertArticle(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - insertArticle (){}", "ENTERED");
		IPostService service = (map) -> mapper.insertArticle(map);
		return (int) service.execute((Map<String, Object>) paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public int updateArticle(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - updateArticle (){}", "ENTERED");
		IPutService service = (map) -> mapper.updateArticle(map);
		return (int) service.execute((Map<String, Object>) paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public int deleteArticle(Map<?,?> paramMap) throws Exception{
		logger.info("BoardService - deleteArticle (){}", "ENTERED");
		IDeleteService service = (map) -> mapper.deleteArticle(map);
		return (int) service.execute((Map<String, Object>) paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getArticleList(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - getArticleList (){}", "ENTERED");
		IGetService service = (map) -> mapper.getArticleList(map);
		return (List<Board>) service.execute((Map<String, Object>) paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public Board selectArticle(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - selectArticle (){}", "ENTERED");
		IGetService service = (map) -> mapper.selectArticle(map);
		return (Board) service.execute((Map<String, Object>) paramMap);
	} 
	
	@SuppressWarnings("unchecked")
	public int count(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - count (){}", "ENTERED");
		IGetService service = (map) -> mapper.count(map);
		return (int) service.execute((Map<String, Object>) paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public int updateHitCount(Map<?,?> paramMap) throws Exception {
		logger.info("BoardService - updateHitCount (){}", "ENTERED");
		IPutService service = (map) -> mapper.updateHitCount(map);
		return (int) service.execute((Map<String, Object>) paramMap);
	}
}
