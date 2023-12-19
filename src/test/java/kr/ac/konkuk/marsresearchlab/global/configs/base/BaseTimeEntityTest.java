package kr.ac.konkuk.marsresearchlab.global.configs.base;

import kr.ac.konkuk.marsresearchlab.domain.user.entity.User;
import kr.ac.konkuk.marsresearchlab.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class BaseTimeEntityTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저를 저장하면 생성 시각이 자동으로 저장된다")
    public void testUserCreatedAtNow() {
        User user = User.createUser("testUser@marsresearchlab.com", "testUser", "testProvider", "testProviderId", "testImageUrl");
        userRepository.save(user);

        assertThat(user.getCreatedAt()).isNotNull();
    }
}