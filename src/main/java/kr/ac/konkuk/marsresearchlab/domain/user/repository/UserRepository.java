package kr.ac.konkuk.marsresearchlab.domain.user.repository;

import kr.ac.konkuk.marsresearchlab.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String mail);
}
