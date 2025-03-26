package com.complexica.lotterynumbergenerator.enricher;

import com.complexica.lotterynumbergenerator.entity.UserEntity;
import com.complexica.lotterynumbergenerator.model.User;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private MapperFacade orikaMapperFacade;

    public User transform(UserEntity userEntity) {
        User user = orikaMapperFacade.map(userEntity, User.class);
        return user;
    }

    public UserEntity transform(User user) {
        UserEntity userEntity = orikaMapperFacade.map(user, UserEntity.class);
        return userEntity;
    }
}
