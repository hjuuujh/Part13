# 가독성 높이는 습관
## 이름 짓기
- 의도를 분명히 밝혀라
- 그릇된 정보를 피하라
- 의미 있게 구분하라
- 발음/검색 하기 쉬운 이름을 사용하라
- 자신의 기억력을 자랑하지 마라
- 기발한 이름을 피하라
- 한 개념에 한 단어를 사용하라
- 말장난을 하지 마라
- 해법/문제 영역에서 가져온 이름을 사용하라
- 의미있는 맥락을 추가하라
- 불필요한 맥락을 없애라
### 이름을 지어야하는 것들
- 모듈 / 프로젝트 : 정해져있는 경우가 많음
- 상수 / 변수: 자체에 의미 담기
- 메서드 / 클래스 : 기대하는 동작 (X : 메서드 명과 다른일을 하는 메서드, 뭘하는지 알수 없는 메서드)
### 일정한 규칙
- prefix vs postfix
- response vs result
- DTO vs Dto vs VO
- get vs find vs search
- delete ve remove
- users vs userList
- params vs parameter
- optional vs maybe
### 풀어서 쓰기 -> 축약어 사용 비추천
- nm : name
- cd : code
- st : status
### 정리
- 이름을 지을땐 의미 붑여
- 메서드의 이름은 기대하는 동작을 명확히 서술
- 메서드는 이름과 다른 일을 하면 안됨
- 이름을 지을땐 일정한 규칙을 갖고 일관성 유지
- 축약어 보다는 풀어쓰기
## 캡슐화
- 은닉
- 데이터와 처리방법을 숨길 수 있다
- 주의 : 너무 깊어지면 도메인 성향에 맞게 캡슐화 포기하고 끊어서 가져올 수 있도록 생산성 지켜야함
## enum
- 상수 대비 가독성이 뛰어남
- enum 기본함수 제공
- IDE의 도움이 뛰어남
- 인스턴스 변수가 1개 있음을 보장
- 상수 확장성
- 주의 사항 : 배포시 문제될수 있음, 다른 시스템과 연계시 문제발생 가능
## null
- null : 아무런 값도 존재하지 않는 상태
- NullPointException 발생시킴
- 매번 회피 로직을 넣어야 안전
- 가끔 전혀 의도하지 않는 방법으로 동작
## null 핸들링
### 단정문 Assertion : 느림 -> 비추천
### Objects하위 옵션
- Boolean Check
- boolean isNull(Object obj);
- boolean nonNull(Object obj);
### Fail Fast
- T requireNonNull(T obj) : null이 아닌것을 명시적으로 알려주기위해 존재
### null 표현하기 : 타입
- Primitive type : stack 영역
- Reference type : 기본 타입의 Wrapper class , heap 영역
```java
public class GiftPointRequest{
	private long userId;
	private long point;  // 두개는 null 안됨
	
	private String memo;
	private Object type; // class type이니 null 가능
}
```
### 정리
- 선언과 동시에 초기화가 최고
- Assertion 문 사용하지 않기
- Null직접적 핸들링 X
- Objects같은 유틸 적극 활용
- Primitive type, Reference type으로 nullable 여부 나타내기
- List는 null 대신 emptyList()
- null 을 대체할 static 객체 리턴(null object pattern) 

## Optional 살펴보기
### 장점
- Null 직접 핸들링 X
- Null 여부를 타입만으로 나타낼 수 있음
- 체이닝을 통한 중간 및 종단 처리
### Oracle Docs
- "결과 없음" 가능, null 반환시 에러가 발생할 수 있는 곳의 메서드 리턴 값
- null 대신 Optional.empty()

## Optional 제대로 사용하기
### 값이 없을 수도 있으면 Optional 사용하기
- Optional 대신 null 리턴 절대 금지
- 기존 시스템의 리턴값이 null을 리턴 하면 > Optional.ofNullable()
### 필드에 Optional 은 지양하기
- Optianl은 함수의 반환 목적으로 만들어짐
- Serializable 구현하지 않았으므로 직렬화 되지 않음
- Optioanl.empty() 빠뜨릴 확률이 높음
### Optional 과 Collection
- 비어있을 컬렉션을 표현할때는 Collections.emptyList()사용하기
-> Optional<List<User>> : 절대 X -> Collections.emptyList()를 리턴 
- 컬렉션의 요소에 Optional을 절대 X : List<Optional<User>> X
- Optional을 파라미터로 넘기지 않기
- Optional을 가져올때 .get()은 되도록 지양 -> 중간/종단 메서드 사용
- 중간 메소드 : filter / map / flatMap / stream으로 변환
- 종단 메소드 : orElse() / orElseGet() / orElseThrow() / ifPresent() / ifPresentorElse() / isPresent() / isEmpty()
### 정리
- 결과가 없을때는 null 대신 Optional.empty()
- 어떠한 일이 있어도 Optional.empty()는 null로 리턴하면 안됨
- 중간/종단 메서드로 안전하게 처리 가능
- 기존시스템이 null을 리턴하면 Optional.ofNullable로 감싸서 사용 -> 많이 쓰면 가독성 떨어질수 있으니 주의
- Optional은 함수의 반환 타입을 위해 만들어짐 -> 필드에 써야할때는 고민 필요
- 컬렉션은 Optional대신 비어있는 컬렉션 사용

## Side effect 줄이기
### == 한번에 다뤄야할 문제의 크기를 줄인다
- 나누어서 생각하기 -> 로직 분해하기 : 하나의 함수가 하나의 일만 하도록(재사용이 가능한 단위로)
- 가능하면 순수 함수로 만들기
- 순수함수로 만들수 없다면 사이드 이펙트 모아두기
- 전역 변수 제거하기
- 불필요한 변수 제거
- 불변객체 사용

## 심플하게 구성하기
### 코드를 작성하는 것 == 비즈니스 로직을 표현하는 것
### 방법
- 부정문 보다 긍정문 사용하기 : 긍정문을 통해 논리 단순화 시키기 (캡슐화)
- 논리 깊이 줄이기 : Early return 을 통해 단순화 시키기
- 논리 깊이 줄이기 : 분기문의 내용이 길다면, 심플한 것 우선 처리하기
- 비즈니스 로직만 남기기 : 상세 구현은 숨기고 비즈니스 로직만 표현하기

## 심미적 방법들
### 코드 일관성 지키기
- 코드 정렬
- 문단 구분 하기
- 함수나 Dto의 네이밍
- 논리 연산 순서
- 함수내 추상화 수준은 최대한 맞추기

## 주석
### 주석은 유지보수 X -> 변하지않는 것을 남겨야함
### 주석에 담겨야 하는 것
- 당시 정책 결정 사유
- 이상한 로직이 존재해야하는 이유
- 하위 호환성이 문제될 경우
- 서비스 장애 등 사유로 기존과 다른 흐름/룩 등이 추가된 경우

## 익셉션 핸들링
### 잘못된 핸들링
- return 값을 통한 에러 핸들링
### 올바른 핸들링 위해
- throw 활용하기
- catch절에서 잡은 익셉션은 반드시 처리하기
- 익셉션은 정발 예외 상황일때만 쓰기
- 최상위 Exception 하나로 잡고 instanceof로 구분하지 않기
- call statck 잃어버리지 않기
- 너무 많은 CustomException 만들지 않기
- checked Exception

## 테스트 코드 
### 작성해야 하는 이유
- 테스트에 대한 시간 및 비용 감소 
- 테스트 코드를 통한 빠른 피드백, 빠른 검증
- 실제 실행하기 전에 버그 발견 가능
- 안정성 확보 -> 비교적 안전한 리팩토링 가능
- 장기적으로는 더 빠른 코드 작성 가능
### Unit test : 가장 작은 단위의 테스트, FIRST 속성
- Fast : 유닛 테스트는 빨라야함
- Isolated : 다른 테스트에 종속적인 테스트 금지
- Repeatable : 매번 같은 결과를 만들어야함
- Self-validating : 테스트는 스스로 결과를 검증할 수 있어야함
- Timely : 테스트는 적시에 작성해야함
### Integration test: 통합 테스트
### E2E test : 실제 유저 입장에서 테스트
### 정리
- manual test는 안티패턴 -> unit test 많이
- 테스트 코드는 테스트 시간을 줄여줌
- 빠른 피드백으로 인해 조기에 잘못된 것을 발견할 수 있음
- 리팩토링을 위한 최소한의 안전성 확보
- 유닛테스트는 FIRST 원칙을 지켜야함
- 일반적으로 부트 컨테이너가 뜨면 통합테스트로 봐야함
- 전체 프로세스를 테스트 한다면 E2E테스트

### 테스트 대상
- 데이터(상태) 테스트
- 행위 테스트
- 성공하는 테스트
- 실패하는 테스트
### 테스트하기 어려운 요소들
- 시간
- private method
- 확률
- 자동 생성 코드들






























