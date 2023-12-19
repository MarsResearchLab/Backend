package kr.ac.konkuk.marsresearchlab.domain.user.repository;

import kr.ac.konkuk.marsresearchlab.domain.user.entity.User;
import kr.ac.konkuk.marsresearchlab.global.configs.base.RepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        // Common setup code for each test
        user = User.createUser(
                "test@marsresearchlab.com",
                "testNickName",
                "testProvider",
                "testProviderId",
                "testImageUrl"
        );
        userRepository.save(user);
    }

    @Test
    @DisplayName("유저를 이메일로 조회한다.")
    public void testFindByEmail_PositiveCase() {
        // When
        User foundUser = userRepository.findByEmail("test@marsresearchlab.com");
        // Then
        assertEquals("test@marsresearchlab.com", foundUser.getEmail());
    }

    @Test
    @DisplayName("유저를 이메일로 조회한다.")
    public void testFindByEmail_NegativeCase() {
        // When
        User foundUser = userRepository.findByEmail("wrong@marsresearchlab.com");
        // Then
        assertNull(foundUser);
    }
}