# 메모장 프로젝트
<details>
<summary> 1. 요구사항 분석 및 설계 </summary>

## 메모장 API 요구사항
 1. 통신 데이터 형태는 JSON이다.
 2. 각각의 메모는 식별자(id), 제목(title), 내용(contents)으로 구성되어 있다.
3. 응답을 각각의 API에 알맞게 해야 한다.
4. 메모를 생성할 수 있다. (CREATE)
    - 메모 생성 시 제목, 내용이 필요하다.
    - 생성된 데이터(식별자, 제목, 내용)가 응답된다.
5. 메모 전체 목록을 조회할 수 있다. (READ)
    - 여러 개의 데이터를 배열 형태로 한번에 응답한다.
    - 데이터가 없는 경우 비어있는 배열 형태로 응답한다.
 6. 메모 하나를 조회할 수 있다. (READ)
    - 조회할 memo에 대한 식별자 id값이 필요하다.
    - 조회된 데이터가 응답된다.
    - 조회될 데이터가 없는 경우 Exception이 발생한다.
 7. 메모 하나를 전체 수정(덮어쓰기)할 수 있다. (UPDATE)
    - 수정할 memo에 대한 식별자 id값이 필요하다.
    - 수정할 요청 데이터(제목, 내용)가 꼭 필요하다.
    - 수정된 데이터가 응답된다.
    - 수정될 데이터가 없는 경우 Exception이 발생한다.
 8. 메모 하나의 제목을 수정(일부 수정)할 수 있다. (UPDATE)
    - 수정할 memo에 대한 식별자 id값이 필요하다.
    - 수정할 요청 데이터(제목)가 꼭 필요하다.
    - 수정된 데이터가 응답된다.
    - 수정될 데이터가 없는 경우 Exception이 발생한다.
 9. 메모를 삭제할 수 있다. (DELETE)
    - 삭제할 memo에 대한 식별자 id값이 필요하다.
    - 삭제될 데이터가 없는 경우 Exception이 발생한다.

#### HTTP API 설계
  - 노션 페이지나 다른 페이지 통해서 API 설계를 추가하기

</details>

<details>
<summary> 2. 메모 생성 기능 </summary>

## 메모 생성
  - 먼저 메모 요청 dto와 메모 응답 dto를 만들고, 메모컨트롤러 클래스와 entity에 담을 메모 클래스를 만들었다.
  - 메모 컨트롤러 클래스에 Map List 형식으로 memoList를 선언
  - 메모 생성을 위해 @PostMapping 어노테이션을 사용하였고 매개변수로 @RequestBody 어노테이션을 사용한 요청 Dto값을 설정하였다.
  - 메서드는 ResponseEntity<MemoResponseDto> 형식을 사용하여 전체와 단건을 모두 다룰 수 있게 하였다.
  - memoList 값이 없으면 1이 되고 있다면 최댓값보다 1 큰 숫자를 담아서 id를 1씩 증가시키도록 하고, memo 생성자로 요청dto에 저장된 id, title, contents를 저장시켰다.
  - Memo 클래스에 필드로 id, title, contents가 선언되어 있고, 요청 dto 클래스에는 title과 contents만 필드로 선언되어 있다. 
  
</details>

<details>
<summary> 3. 메모 목록 조회 기능 </summary>

## 메모 목록 조회
  - GetMapping 어노테이션을 사용하고, 메서드는 위와 동일한 응답dto 형태로 만들었는데 조회를 해야하기 때문에 responseList를 만들어 초기화시켰다.
  - 전체를 조회하기 위해 향상된 for문으로 memoList의 values를 가져와서 응답Dto 객체를 만들어서 생성자로 해당 값을 넣고, 그 객체를 resonseList에 삽입하여 값 전부를 조회할 수 있게 하였다.
  - 왜 그냥 넣으면 될텐데 이렇게 먼저 응답dto 객체로 만들어서 값을 넣는 이유는 memoList와 responseList가 서로 다른 형식을 가졌기 때문이기도 하지만, 결정적인 이유는 나중에 값이 교체되거나 문제가 생겼을 때에도 유지보수가 용이하기 위함인 것으로 생각된다. 

</details>

<details>
<summary> 4. 메모 단건 조회 기능 </summary>

## 메모 단건 조회
  - 메모 단건을 조회할 때는 get(index) 형식으로 Memo 객체를 선언하여 return 받게하였는데 이 때 경로변수용 어노테이션 @PathVariable을 사용하여 id 값을 기준으로 조회할 수 있게 하였다.
  - 조회하는 값이 null일 경우 예외처리 상태코드가 나오게 하였으며, null이 아닐 경우에는 변경된 값과 함께 OK 상태코드가 뜨게 하였다.

</details>

<details>
<summary> 5. 메모 단건 전체 수정 기능 </summary>

## 메모 전체 수정
  - @PutMapping 어노테이션을 사용하여 id 값을 기준으로 수정을 진행할 수 있게 하였다.
  - 메모 전체 수정을 위하여 경로변수용 어노테이션과 생성에 사용했던 @RequestBody 어노테이션을 사용하여 id와 요청Dto 객체를 사용하였다.
  - 위와 동일한 방법으로 get(id)를 객체로 선언하고 null에 대한 값들을 예외처리하였고, 값이 아예 없을 때랑 일부만 있을 때의 처리 결과코드를 다르게 했다.
  - 이상이 없으면 memo.update 메서드로 응답객체를 값에 할당하게 하였고, 업데이트된 값이 제대로 들어가면 Ok 상태코드와 함께 해당 값이 return 되게 하였다.
  - update 메서드는 Memo 클래스에 있는데 Memo 클래스의 title 필드와 contents 필드의 값을 새로 할당할 수 있게 되어 있다.
    
</details>

<details>
<summary> 6. 메모 단건 제목 수정 기능 </summary>

## 메모 제목 수정
  - 전체 수정과 동일한 로직인데 여기서는 단건 전체 수정과 달리 제목만 수정할 것이므로 Memo 클래스에 있는 updateTitle을 사용하였다.
  - update 메서드와 달리 title에 대한 값만 새로 할당하는 메서드이므로 그 외의 값이 입력 되는 등 문제가 생겼을 때 예외처리 상태코드를 작성하였다. 

</details>

<details>
<summary> 7. 메모 삭제 기능 </summary>

## 메모 삭제
  - 삭제 기능은 DeleteMapping 어노테이션을 사용하여 id를 기준으로 값을 조회할 수 있게 하였고 위와 마찬가지로 경로변수용 어노테이션을 사용하였다.
  - memoList의 key 중에 id(경로변수)에 해당하는 것이 있다면 값을 삭제하고, OK 상태코드를 반환하게 하였다.
  - if문이 동작하지 않을 경우에는 예외처리에 대한 상태코드가 뜨게하였다.

</details>

전체 코드에 대한 해설은 [[TIL] Spring Boot 5주차 (2)](https://velog.io/@wndid2008/TIL-Spring-Boot-5%EC%A3%BC%EC%B0%A8-2#4-2-%EB%A9%94%EB%AA%A8%EC%9E%A5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8)에서도 확인 할 수 있습니다.

