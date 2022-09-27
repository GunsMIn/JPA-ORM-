package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


//@Table(name="MBR") // 디비의 테이블과연결!
@Entity // 이거를 써주면 jpa과 관리하는 엔티티
public class Member {


    @Id //pk값
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "varchar(100) default 'EMPTY'") // 객체는 username 디비컬럼명는 name/   nullable = false-> not null
    private String username;                //columnDefinition 데이터베이스 컬럼 정보를 직접 줄 수 있다

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // user/manager

    @Embedded
    private Period workPeriod;

    private Address homeAddress;


    @Lob // varchar 보다 큰 문자열을 사용하고 싶을때
    private String description;

   /* @Enumerated(EnumType.STRING)//디비에는 enum이없어서
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate localDate;
    private LocalDateTime localDateTime;

    @Lob // varchar를 뛰어넘는 큰것을 넣고 싶을대 //매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
    private String description;*/

    //@Transient 필드 매핑X
    //• 데이터베이스에 저장X, 조회X
    //• 주로 메모리상에서만 임시로 어떤 값을 보관하고 싶을 때 사용
    //private Integer temp;

    public Member(){;}



}
