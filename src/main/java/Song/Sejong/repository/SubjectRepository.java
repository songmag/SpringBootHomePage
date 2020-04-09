package Song.Sejong.repository;

import Song.Sejong.model.entity.SubjectEntity;
import Song.Sejong.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
    SubjectEntity findBySubject(String subjectName);

    SubjectEntity findByUser(UserEntity entity);

    List<SubjectEntity> findAllByUser(UserEntity entity);
}
