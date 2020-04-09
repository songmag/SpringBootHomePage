package Song.Sejong.model.modelConverter;

import Song.Sejong.model.dto.user.UserModel;
import Song.Sejong.model.entity.UserEntity;
import Song.Sejong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * this converter use user to entity or entity to user
 */
@Component
public class UserConverter implements ModelAndEntityConvertor<UserEntity,UserModel> {
    @Autowired
    UserRepository repository;

    public UserEntity userModelToEntity(UserModel model, UserEntity entity)
    {
        entity.setId(model.getId());
        Optional<UserEntity> et= repository.findById(entity.getId());
        entity = et.get();
        entity.setName(entity.getName());
        entity.setImageUrl(model.getImageUrl());
        entity.setProfileImageUrl(model.getProfileImageUrl());
        entity.setAge(model.getAge());
        return entity;
    }
    public void userEntityToModel(UserEntity entity, UserModel model)
    {
        model.setId(entity.getId());
        model.setProfileImageUrl(entity.getProfileImageUrl());
        model.setImageUrl(entity.getImageUrl());
        model.setAge(entity.getAge());
        model.setName(entity.getName());
    }

    @Override
    public UserModel entityToModel(UserEntity entity) {
        UserModel model = new UserModel();
        userEntityToModel(entity,model);
        return model;
    }

    @Override
    public UserEntity modelToEntity(UserModel model) {
        UserEntity entity =new UserEntity();
        entity =userModelToEntity(model,entity);
        return entity;
    }
}
