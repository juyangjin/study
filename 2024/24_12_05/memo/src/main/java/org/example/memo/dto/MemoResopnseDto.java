package org.example.memo.dto;

import lombok.Getter;
import org.example.memo.entity.Memo;

@Getter
public class MemoResopnseDto {
    private Long id;
    private String title;
    private String contents;

    /*
    Memo class를 인자로 가지는 생성자
    MemoCotroller에서 이 생성자로 값을 return 해주면
    그 값을 MemoResoponseDto에 있는 필드에 저장하는 역할을 한다.
    this를 사용하면 해당 클래스 내부의 값을 의마한다.
     */
    public MemoResopnseDto(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
    }

}
