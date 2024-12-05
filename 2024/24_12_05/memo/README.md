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

