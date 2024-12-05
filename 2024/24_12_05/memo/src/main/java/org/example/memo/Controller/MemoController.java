package org.example.memo.Controller;

import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Memo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/memos") //prefix, 공통으로 들어갈 주솟값
public class MemoController {
    private final Map<Long, Memo> memoList = new HashMap<>();

    /*
    postmapping을 사용하면 반환되는 값이 있다는 뜻
    생성을 위한 createMemo 메서드
     */
    @PostMapping
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto){
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
        return new MemoResponseDto(memo);
    }

    /*
    전체 조회를 위한 find 메서드
     resoponseDto 객체를 생성하면서 memo에 저장된 momoList값을 저장한다.
     */
    @GetMapping
    public List<MemoResponseDto> findAllMemos() {
        //init List
        List<MemoResponseDto> resopnseList = new ArrayList<>();

        //HashMap<Memo>를 List<<MemoResponseDto>로 조회
        for(Memo memo : memoList.values()){
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            resopnseList.add(responseDto);
        }
        return resopnseList;
    }

    /*
    단건 조회를 위한 find 메서드
    return으로 인덱스에 맞는 값을 조회하고 성공 시 OK 상태코드를 나타내게 한다.
    null값에 대한 예외처리를 NOT_FOUND enum을 사용하여 설정
     */
    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id){
        Memo memo = memoList.get(id);

        if(memo == null){ //예외처리
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
    }

    /*
    메모 단건 전체 수정을 위한 update메서드
    메모 수정을 위해 경로변수를 써서 해당 인덱스를 찾고,
    @RequestBody를 이용하여 요청 dto의 값을 넣을 수 있게 하였다.(업데이트)
    중간에 값이 없을 때 발생하는 예외처리 삽입, 응답값에는 성공하면 OK 상태코드 반환되게 함
     */
    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoList.get(id);

        //npe 방지
        if(memo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //필수값 검증
        if(requestDto.getTitle() == null || requestDto.getContents() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //memo 수정
        memo.update(requestDto);

        //응답
        return new ResponseEntity<>(new MemoResponseDto(memo),HttpStatus.OK);
    }

    /*
    메모 단건 제목 수정을 위한 updatTitle메서드
     */
    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Memo memo = memoList.get(id);

        // NPE 방지
        if (memo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // 필수값 검증
        if (requestDto.getTitle() == null || requestDto.getContents() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.updateTitle(requestDto);

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
    }

    /*
    삭제를 위한 delete 메서드
    경로변수로 인덱스만 찾아서 해당 인덱스의 memoList값을 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id){
        /*
        memoList Key값에 id에 해당하는 값이 있다면 해당 값 삭제
         */
        if(memoList.containsKey(id)){
            memoList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
