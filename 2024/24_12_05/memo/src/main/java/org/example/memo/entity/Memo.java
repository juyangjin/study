package org.example.memo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.memo.dto.MemoRequestDto;

@Getter
@AllArgsConstructor
public class Memo {
    private Long id;
    private String title;
    private String contents;

    /*
    코드 수정을 위해 update 메서드로 요청 dto를 매개변수로 받고
    요청 dto 값을 해당 클래스의 title과 contents 필드에 저장한다.
     */
    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}

