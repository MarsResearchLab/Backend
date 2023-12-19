package kr.ac.konkuk.marsresearchlab.domain.favorites.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorites_id", nullable = false)
    private Long id;

}
