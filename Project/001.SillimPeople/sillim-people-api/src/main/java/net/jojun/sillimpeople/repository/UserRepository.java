package net.jojun.sillimpeople.repository;

import net.jojun.sillimpeople.domain.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {

    public List<UserVO> findByName(String name);

    public List<UserVO> findByAge(int age);

}

