package kr.ac.konkuk.marsresearchlab.domain.favorites.entity;

import jakarta.persistence.*;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import kr.ac.konkuk.marsresearchlab.domain.user.entity.User;
import lombok.Getter;

@Getter
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorites_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
}
