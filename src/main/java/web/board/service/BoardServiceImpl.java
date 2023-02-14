package web.baemin.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.baemin.board.dto.Board;
import web.baemin.board.mapper.BoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {


    private final BoardMapper boardMapper; // MyBatis. Mapper

    @Override
    public List<Board> boardList() {

        List<Board> boardList = boardMapper.boardList();
        log.info("boardList : {}", boardList.toString());

        return boardList;
    }

    @Override
    public Board boardRead(String id) {

        Board board = boardMapper.boardRead(id);

        return board;
    }

    @Override
    public void boardInsert(Board board) {
        boardMapper.boardInsert(board);
    }

    @Override
    public void boardUpdate(Board board) {
        boardMapper.boardUpdate(board);
    }


}
