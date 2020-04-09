package Song.Sejong.service;

import Song.Sejong.model.dto.post.Post;
import Song.Sejong.model.dto.post.PostList;
import Song.Sejong.model.dto.post.Subject;
import Song.Sejong.model.dto.post.SubjectList;
import Song.Sejong.model.dto.user.UserModel;
import Song.Sejong.model.entity.PostEntity;
import Song.Sejong.model.entity.UserEntity;
import Song.Sejong.model.modelConverter.PostConverter;
import Song.Sejong.model.modelConverter.SubjectConverter;
import Song.Sejong.model.modelConverter.UserConverter;
import Song.Sejong.repository.PostRepository;
import Song.Sejong.repository.SubjectRepository;
import Song.Sejong.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostConverter postConverter;
    @Autowired
    UserConverter userConvertor;
    @Autowired
    SubjectConverter subjectConverter;

    private Logger logger = LoggerFactory.getLogger(PostService.class);

    public SubjectList getSubjectListDto(UserModel user)
    {

        SubjectList list = new SubjectList();
        list.setSubjectList(getSubjectList(user));
        list.setSelectedSubject(list.getSubjectList().get(0));
        return list;
    }
    private List<Subject> getSubjectList(UserModel user) {
        List<Subject> subjects =new ArrayList<Subject>();
        Optional<UserEntity> entity = userRepository.findById(userConvertor.modelToEntity(user).getId());
        if(!entity.isPresent()) return new ArrayList<>();
        subjectRepository.findAllByUser(entity.get()).forEach(
                e->{
                    subjects.add(subjectConverter.entityToModel(e));
                }
        );
        return subjects;
    }
//    public Post getPost(Long postNumber)
//    {
//        Optional<PostEntity> post = postRepository.findById(postNumber);
//        if(post.isPresent())
//        {
//           return postConverter.entityToModel(post.get());
//        }
//        return null;
//    }
    public void setPosts(PostList list,Page<PostEntity> entities)
    {
        for(PostEntity e : entities)
        {
            list.getPosts().add(postConverter.entityToModel(e));
        }
        list.setPageSize(entities.getTotalPages());
        list.setCurrentPage(entities.getNumber()+1);
    }

    public PostList getPostList(Long subject, int page)
    {
        PostList list = new PostList();
        Page<PostEntity> entities = postRepository.findBySubjectOrderByTimeDesc(PageRequest.of(page-1,10),subjectRepository.findById(subject));
        setPosts(list,entities);
        return list;
    }

    public void submmitPost(Post object) {
        PostEntity entity = postConverter.modelToEntity(object);
        subjectRepository.findById(object.getSubject()).ifPresent(e->entity.setSubject(e));
        postRepository.save(entity);
    }

    public PostList getPostList(SubjectList subjectList, int page, UserModel user) {
        if(subjectList == null) return new PostList();
        Page<PostEntity> entities = postRepository.findBySubjectAndUserOrderByTimeDesc(PageRequest.of(page-1,10),subjectRepository.findById(subjectList.getSelectedSubject().getId()),userConvertor.modelToEntity(user));
        PostList list = new PostList();
        setPosts(list,entities);
        return list;
    }
}
