package net.jojun.sillimpeople.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
//  @Entitiy : JPA가 관리하는 클래스를 의미, @Id PK 지정,
@Data
@Entity(name="user")
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rnum;

    private String name;
    private int age;
    // 기본생성자는 public 또는 protectec ,
    // private 으로 사용 시 추후에 Lazy Loading 사용 시 Proxy 관련 예외가 발생
    protected UserVO(){

    }

    /*@Builder
    public UserVO(String name, int age){
        this.name = name;
        this.age = age;
    }*/
}

