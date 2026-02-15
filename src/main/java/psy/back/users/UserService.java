package psy.back.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void register(User user) {
        var userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
        log.info("Added user id db, id {}, user {}", userEntity.getId(), user);
    }

    public Boolean login(User user) {
        var userEntity = userRepository
                .findFirstByLogin(user.getLogin()).orElseGet(UserEntity::new);
        var passCheck = Objects.equals(user.getPassword(), userEntity.getPassword());
        log.info("Login user {} is success {}", user.getLogin(), passCheck);
        return passCheck;
    }
}
