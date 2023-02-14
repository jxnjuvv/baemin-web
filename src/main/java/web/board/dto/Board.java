package web.baemin.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {

    private Long id;

    private String reg_date;

    private String title;

    private String content;
}
