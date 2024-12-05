package org.example.memo.Controller;

import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResopnseDto;
import org.example.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/memos") //prefix, 공통으로 들어갈 주솟값
public class MemoController {
    private final Map<Long, Memo> memoList = new HashMap<>();

    /*
    postmapping을 사용하면 반환되는 값이 있다는 뜻
    생성을 위한 createMemo 메서드
     */
    @PostMapping
    public MemoResopnseDto createMemo(@RequestBody MemoRequestDto requestDto){
        /*
        식별자가 1씩 증가하도록 만듦
        삼항연산자를 사용하여 memoList값이 존재하지 않는다면 1이 되고
        존재한다면 memoList의 Key값 중 최댓값을 1 증가시킨다.
         */
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) +1;

        /*
        요청받은 데이터로 Memo 객체 생성
        Memo 클래스에 있는 id, title, contents를 생성자로 새로 생성한다.
        이 때 id값은 위에서 증가된 memoId 값이 들어가고 title과 contents는 MemoRequestDto에 저장된 값(요청된 값)이 들어간다.
         */
        Memo memo = new Memo(memoId, requestDto.getTitle(),requestDto.getContents());

        /*
        Inmemory DB에 Memo 저장
        위에서 생성된 memo 값이 memoId와 함께 memoList에 추가로 저장된다.
         */
        memoList.put(memoId, memo);

        /*
        memo를 매개로 하는 MemoResponseDto의 생성자를 return 한다.
         */
        return new MemoResopnseDto(memo);
    }

    /*
    조회를 위한 find 메서드
    memoList의 인덱스 id로 값을 조회하기 위해 해당 값을 return한다.
    @PathVariable는 경로 변수 어노테이션이다.
     */
    @GetMapping("/{id}")
    public MemoResopnseDto findMemoById(@PathVariable Long id){
        Memo memo = memoList.get(id);
        return new MemoResopnseDto(memo);
    }

    /*
    수정을 위한 update메서드
    메모 수정을 위해 경로변수를 써서 해당 인덱스를 찾고,
    @RequestBody를 이용하여 요청 dto의 값을 넣을 수 있게 하였다.(업데이트)
     */
    @PutMapping("/{id}")
    public MemoResopnseDto updateMemoById(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoList.get(id);

        memo.update(requestDto);

        return  new MemoResopnseDto(memo);
    }

    /*
    삭제를 위한 delete 메서드
    경로변수로 인덱스만 찾아서 해당 인덱스의 memoList값을 삭제
     */
    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id){
        memoList.remove(id);
    }

}
