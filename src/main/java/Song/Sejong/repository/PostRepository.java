package Song.Sejong.repository;

import Song.Sejong.model.entity.PostEntity;
import Song.Sejong.model.entity.SubjectEntity;
import Song.Sejong.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
     Page<PostEntity> findBySubject(Pageable page, Optional<SubjectEntity> subject);
    Page<PostEntity> findBySubjectOrderByTimeDesc(Pageable of, Optional<SubjectEntity> byId);

    Page<PostEntity> findBySubjectAndUserOrderByTimeDesc(Pageable of, Optional<SubjectEntity> byId, UserEntity modelToEntity);
}
