package web.baemin.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.board.dto.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> boardList();

    Board boardRead(String id);

    void boardInsert(Board board);

    void boardUpdate(Board board);

}
