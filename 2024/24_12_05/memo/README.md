# 메모장 프로젝트
<details>
<summary> 1. 요구사항 분석 및 설계 </summary>

## 메모장 API 요구사항
### 1. 통신 데이터 형태는 JSON이다.
### 2. 각각의 메모는 식별자(id), 제목(title), 내용(contents)으로 구성되어 있다.
### 3. 응답을 각각의 API에 알맞게 해야 한다.
### 4. 메모를 생성할 수 있다. (CREATE)
  - 메모 생성 시 제목, 내용이 필요하다.
  - 생성된 데이터(식별자, 제목, 내용)가 응답된다.
### 5. 메모 전체 목록을 조회할 수 있다. (READ)
  - 여러 개의 데이터를 배열 형태로 한번에 응답한다.
  - 데이터가 없는 경우 비어있는 배열 형태로 응답한다.
### 6. 메모 하나를 조회할 수 있다. (READ)
  - 조회할 memo에 대한 식별자 id값이 필요하다.
  - 조회된 데이터가 응답된다.
  - 조회될 데이터가 없는 경우 Exception이 발생한다.
### 7. 메모 하나를 전체 수정(덮어쓰기)할 수 있다. (UPDATE)
  - 수정할 memo에 대한 식별자 id값이 필요하다.
  - 수정할 요청 데이터(제목, 내용)가 꼭 필요하다.
  - 수정된 데이터가 응답된다.
  - 수정될 데이터가 없는 경우 Exception이 발생한다.
### 8. 메모 하나의 제목을 수정(일부 수정)할 수 있다. (UPDATE)
  - 수정할 memo에 대한 식별자 id값이 필요하다.
  - 수정할 요청 데이터(제목)가 꼭 필요하다.
  - 수정된 데이터가 응답된다.
  - 수정될 데이터가 없는 경우 Exception이 발생한다.
### 9. 메모를 삭제할 수 있다. (DELETE)
  - 삭제할 memo에 대한 식별자 id값이 필요하다.
  - 삭제될 데이터가 없는 경우 Exception이 발생한다.

## HTTP API 설계
  - 노션 페이지나 다른 페이지 통해서 API 설계를 추가하기

</details>

<details>
<summary> 2. 메모 생성 기능 </summary>
  
  - 먼저 메모 요청 dto와 메모 응답 dto를 만들고, 메모컨트롤러 클래스와 entity에 담을 메모 클래스를 만들었다.
  - 메모 컨트롤러 클래스에 Map List 형식으로 memoList를 선언
  - 메모 생성을 위해 @PostMapping 어노테이션을 사용하였고 매개변수로 @RequestBody 어노테이션을 사용한 요청 Dto값을 설정하였다.
  - memoList 값이 없으면 1이 되고 있다면 최댓값보다 1 큰 숫자를 담아서 id를 1씩 증가시키도록 하고, memo 생성자로 요청dto에 저장된 id, title, contents를 저장시켰다.
  - Memo 클래스에 필드로 id, title, contents가 선언되어 있고, 요청 dto 클래스에는 title과 contents만 필드로 선언되어 있다. 
  
</details>

<details>
<summary> 3. 메모 목록 조회 기능 </summary>

</details>

<details>
<summary> 4. 메모 단건 조회 기능 </summary>

</details>

<details>
<summary> 5. 메모 단건 전체 수정 기능 </summary>

</details>

<details>
<summary> 6. 메모 단건 제목 수정 기능 </summary>

</details>

<details>
<summary> 7. 메모 삭제 기능 </summary>

</details>

<details>
<summary> 메모장 API 요구사항 </summary>

</details>

