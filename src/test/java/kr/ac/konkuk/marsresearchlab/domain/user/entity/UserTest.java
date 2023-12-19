package kr.ac.konkuk.marsresearchlab.domain.user.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("모든 정보를 올바른 형식으로 입력하면 회원이 생성된다")
    void createUser() {
        assertDoesNotThrow(
                () -> User.createUser("testUser@marsresearchlab.com", "testUser", "testProvider", "testProviderId", "testImageUrl")
        );
    }

    @Test
    @DisplayName("회원의 프로필 이미지가 존재하면 해당 이미지 url을 올바르게 반환한다")
    void getImgUrlWhenHasImage() {
        String expected = "testImage.jpg";
        User user = User.createUser("testUser@marsresearchlab.com", "testUser", "testProvider", "testProviderId", expected);

        String actual = user.getImageUrl();

        assertThat(actual).isEqualTo(expected);
    }
}