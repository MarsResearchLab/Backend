package kr.ac.konkuk.marsresearchlab.domain.user.entity;

import jakarta.persistence.*;
import kr.ac.konkuk.marsresearchlab.global.configs.base.BaseTimeEntity;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "`user`")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique=true)
    private String email;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String provider;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Builder
    public User(Long id, String email, String nickName, String provider, String providerId, String imageUrl, Status status, Role role) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.provider = provider;
        this.providerId = providerId;
        this.imageUrl = imageUrl;
        this.status = status;
        this.role = role;
    }

    public static User createUser(String email, String nickName, String provider, String providerId, String imageUrl) {
        return User.builder()
                .email(email)
                .nickName(nickName)
                .provider(provider)
                .providerId(providerId)
                .imageUrl(imageUrl)
                .status(Status.ACTIVE)
                .role(Role.USER)
                .build();
    }
}
