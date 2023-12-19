package kr.ac.konkuk.marsresearchlab.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "사용자"),
    OWNER("ROLE_GUEST", "게스트"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
