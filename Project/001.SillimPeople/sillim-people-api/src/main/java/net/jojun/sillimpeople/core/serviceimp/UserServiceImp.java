package net.jojun.sillimpeople.core.serviceimp;

import net.jojun.sillimpeople.core.service.UserService;
import net.jojun.sillimpeople.domain.UserVO;
import net.jojun.sillimpeople.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository UserRepository;

    @Override
    public List<UserVO> findAll() {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findAll().forEach(e -> users.add(e));

        return users;
    }

    @Override
    public List<UserVO> findByName(String name) {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findByName(name).forEach(e -> users.add(e));
        return users;
    }

    @Override
    public List<UserVO> findByAge(int age) {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findByAge(age).forEach(e -> users.add(e));
        return users;
    }

    @Override
    public UserVO save(UserVO user) {
        UserRepository.save(user);
        return user;
    }
}
