
# 계산기 프로그램
## 예외처리 반영 프로젝트

- 과제에서 주어진 기본 소스코드를 토대로 재구성한 프로젝트
- main 클래스에서는 calculateEnded가 false로 지정되었길래 그걸 기준으로 해서 계산의 시작을 start를 입력하는 조건으로 지정
- while 문을 열고 그 안에 try catch 문을 작성했다. calApp.start();로 CalculatorApp 클래스 안의 start를 실행
- 실행이 끝나면 재실행에 대한 질문이 나오게 하고 종료값이 입력 시 종료
- catch문에서 입력 에러 발생에 대한 예외를 처리
- CalculatorApp 클래스에서 첫번째 숫자와 연산자, 다시 두번째 숫자 순으로 값을 받고 parser 클래스에 있는 첫번째 숫자, 연산자, 두번째 숫자에 해당하는 메서드를 호출
- Parser 클래스에서 두 숫자가 NUMBER_REG에 맞는 값인지 Pattern.matches를 이용하여 검사
- 해당 패턴이 아닌 값이 입력된다면 BadInputException 클래스의 메서드가 실행하여 예외처리
- return 형태가 Parser으로 되어있으므로 this를 사용하여 반환
- 연산자를 구분하는 메서드에서는 switch case 문을 사용하여 setOperation 메서드를 부르는데, 여기서는 괄호에 생성자를 적어서 해당 생성자에 맞는 계산을 하게끔 설정
- executeCalculator 메서드로  calculator.calculate()를 리턴받음
- calculate 메서드 안에는 결과값을 실수형으로 저장하는 operate 메서드가 존재하기 때문에 연산자 클래스에서 오버라이딩 한 값들이 실행
- 람다식의 반영은 했다고 하기는 애매한 상태, 화살표는 썼으나 향상된 switch case 문에 사용됨.
