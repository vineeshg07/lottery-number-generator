package com.complexica.lotterynumbergenerator.orika;

import com.complexica.lotterynumbergenerator.entity.UserEntity;
import com.complexica.lotterynumbergenerator.model.User;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Mapping implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(@NotNull MapperFactory orikaMapperFactory) {

        orikaMapperFactory
                .classMap(UserEntity.class, User.class)
                .mapNulls(false).byDefault()
                .register();
    }
}
