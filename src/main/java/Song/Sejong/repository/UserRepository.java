package Song.Sejong.repository;

import Song.Sejong.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByName(String userEntity);
}
