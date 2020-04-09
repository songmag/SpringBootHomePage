package Song.Sejong;

import Song.Sejong.interceptor.HashComponent;
import Song.Sejong.model.entity.PostEntity;
import Song.Sejong.model.entity.SubjectEntity;
import Song.Sejong.model.entity.UserEntity;
import Song.Sejong.repository.PostRepository;
import Song.Sejong.repository.SubjectRepository;
import Song.Sejong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.ResourceBundle;

@Component
public class BeanTest implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    HashComponent component;


    @Autowired
    PostRepository postRepository;
    String[] value = {"HTML_CSS_JS","C","JAVA","SPRING"};
   @Autowired
   ResourceLoader loader;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserEntity entity = new UserEntity();
        entity.setName("송제섭");
        entity.setAge(29);
        entity.setProfileImageUrl("myphoto.jpg");
        entity.setImageUrl("myhistory.png");
        SubjectEntity[] subject = new SubjectEntity[4];
        for(int i = 0 ; i < 4; i++)
        {
            subject[i] = new SubjectEntity();
            subject[i].setSubject(value[i]);
            entity.addSubject(subject[i]);
        }
        userRepository.save(entity);
        for(int i=0 ; i < 30;i++) {
            PostEntity postEntity = new PostEntity();
            postEntity.setContent("TestContent");
            postEntity.setName("HTML Test Content"+i);
            postEntity.setUser(entity);
            postEntity.addSubject(subject[0]);
            postRepository.save(postEntity);
        }
    }
}
