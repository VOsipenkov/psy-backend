package psy.back.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void add(User user) {
        var userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
        log.info("Added user id db, id {}, user {}", userEntity.getId(), user);
    }
}
