package com.board.web.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.board.web.domain.Board;

@Repository
public interface BoardMapper {
	
	/*CREATE*/
	public int write(Map<?,?> map) throws Exception;
	
	/*READ*/
	public List<Board> getArticleList(Map<?,?> map) throws Exception;
	public int count(Map<?,?> map) throws Exception;
	public int exist(Map<?,?> map) throws Exception;
	
	/*UPDATE*/
	
	/*DELETE*/
}
