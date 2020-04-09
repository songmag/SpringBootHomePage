package Song.Sejong.model.modelConverter;

import Song.Sejong.model.dto.post.Post;
import Song.Sejong.model.entity.PostEntity;
import Song.Sejong.repository.SubjectRepository;
import Song.Sejong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostConverter implements ModelAndEntityConvertor<PostEntity, Post>{
    @Autowired
    UserConverter userConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Post entityToModel(PostEntity entity) {
        Post p = new Post();
        p.setContent(entity.getContent());
        p.setDate(entity.getTime());
        p.setName(entity.getName());
        p.setNumber(entity.getPostId());
        p.setOwner(userConverter.entityToModel(entity.getUser()));
        p.setSubject(entity.getSubject().getSubjectId());
        return p;
    }
    @Override
    public PostEntity modelToEntity(Post model) {
        PostEntity entity = new PostEntity();
        entity.setContent(model.getContent());
        entity.setName(model.getName());
        userRepository.findById(model.getOwner().getId()).ifPresent(e->entity.setUser(e));
        subjectRepository.findById(model.getSubject()).ifPresent(e->entity.setSubject(e));
        return entity;
    }
}
