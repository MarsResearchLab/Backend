package kr.ac.konkuk.marsresearchlab.domain.favorites.repository;

import kr.ac.konkuk.marsresearchlab.domain.favorites.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
