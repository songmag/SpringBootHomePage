package Song.Sejong.model.dto.user;

import Song.Sejong.model.entity.UserEntity;
import Song.Sejong.model.modelConverter.UserConverter;
import Song.Sejong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class DefaultUserModel extends UserModel {

    @Autowired
    UserRepository repository;
    @Autowired
    UserConverter converter;
    public DefaultUserModel() {
        super();
    }
    @PostConstruct
    public void setting(){
        UserEntity entity = new UserEntity();
        entity.setName("송제섭");
        entity.setAge(29);
        entity.setProfileImageUrl("myphoto.jpg");
        entity.setImageUrl("myhistory.png");
        entity.setId(1l);
        converter.userEntityToModel(entity,this);
    }
}
