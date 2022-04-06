# [JPA] @DynamicUpdate

### @DynamicUpdate 어노테이션의 장점과 단점

> @org.hibernate.annotation.DynamicUpdate

#### Good

* 상태가 변화된 (Dirty) 필드 만을 대상으로 UPDATE SET QUERY 를 수행한다.

#### Bad

* JPA 구현체인 hibernate는 애플리케이션이 처음 로드 될 때, 엔티티 들을 스캔하여 모든 필드를 업데이트 할 쿼리로 캐싱 해놓고 업데이트 할 때마다 메모리에 캐시된(쓰기 지연 SQL 저장소) 쿼리를 사용하는 것인데

* @DynamicUpdate 를 명시 해주면, 업데이트 할 컬럼만 SET 하기 위해 **캐시된 쿼리를 사용하지 않고 업데이트 할 때마다 동적으로 쿼리를 생성하게 된다.**

* 어노테이션 이름이 Dynamic(동적) Update 인 이유

  

따라서 @DynamicUpdate 는 업데이트 시 무의미한 필드 들이 많이 존재하는 엔티티 이면서 업데이트 시 오버헤드가 많이 발생하는 경우에 사용하는 것이 좋다.



#### Example

1.  엔티티에 update할 정보들을 수정하는 함수를 만들어 놓고 다이나믹 업데이트와 더티체킹으로 변경이 일어난 부분에 대해 update하는 방식 ( 변경이 감지되지 않은 속성(column)들에 대해서는 update 처리 하지않음)



```java
// Member Entity
@Data
@Entity @DynamicUpdate
@Table(name = "member")
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_no")
	private Long memNo;
	
	@Column(name = "mem_id")
	private String memId;
	
	@Column(name = "mem_age")
	private Integer memAge;
	
	@Column(name = "mem_pw")
	private String memPw;
	
	@Builder
	public Member(String memId, Integer memAge, String memPw) {
		this.memId = memId;
		this.memAge = memAge;
		this.memPw = memPw;
	}
	
	public Member changeMemberInfo(Member member) {
		this.memId = member.getMemId();
		this.memPw = member.getMemPw();
		this.memAge = member.getMemAge();
		return this;
	}
}
```



```java
// Member Service

@Transactional
public Member update(Long memNo, Member updatedMember) {

    // 업데이트할 객체에 대해 영속성 컨텍스트에 올려놓고
    Member member = findMemberByNo(memNo);

    // 해당 Entity 의 property를 변경하는 함수를 호출해서
    // 변경감지를 이용해 update 하는 방식
    member.changeMemberInfo(updatedMember);

    return member;
}

private Member findMemberByNo(Long memNo) {
		
    return	memberRepository.findById(memNo).orElseThrow(() -> new IllegalArgumentException("user" + memNo + " 가 존재하지 않음."));
	}
```





