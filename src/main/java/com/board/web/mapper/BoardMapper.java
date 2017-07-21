package com.board.web.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.board.web.domain.Board;

@Repository
public interface BoardMapper {
	
	/*CREATE start*/
	public int insertArticle(Map<?,?> map) throws Exception;
	/*CREATE end*/
	
	/*READ start*/
	public List<Board> getArticleList(Map<?,?> map) throws Exception;
	public Board selectArticle(Map<?,?> map) throws Exception;
	public List<Board> searchByTitle(Map<?,?> map) throws Exception;
	public List<Board> searchByWriter(Map<?,?> map) throws Exception;
	public int count(Map<?,?> map) throws Exception;
	public int searchCountByTitle(Map<?,?> map) throws Exception;
	public int searchCountByWriter(Map<?,?> map) throws Exception;
	public int exist(Map<?,?> map) throws Exception;
	/*READ end*/
	
	/*UPDATE start*/
	public int updateHitCount(Map<?,?> map) throws Exception;
	public int updateArticle(Map<?,?> map) throws Exception;
	/*UPDATE end*/
	
	/*DELETE start*/
	public int deleteArticle(Map<?,?> map) throws Exception;
	/*DELETE end*/
}
