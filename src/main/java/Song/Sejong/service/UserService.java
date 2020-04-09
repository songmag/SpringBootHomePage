package Song.Sejong.service;

import Song.Sejong.model.dto.user.UserModel;
import Song.Sejong.model.entity.UserEntity;
import Song.Sejong.model.modelConverter.UserConverter;
import Song.Sejong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    UserConverter converter;
    public UserModel userModel(String name){
        UserEntity entity = repository.findByName(name);
        UserModel model = new UserModel();
        converter.userEntityToModel(entity,model);
        model.setMode("guest");
        return model;
    }
    public UserModel userModelMaster(String name){
        UserEntity entity = repository.findByName(name);
        UserModel model = new UserModel();
        converter.userEntityToModel(entity,model);
        model.setMode("owner");
        return model;
    }
}
