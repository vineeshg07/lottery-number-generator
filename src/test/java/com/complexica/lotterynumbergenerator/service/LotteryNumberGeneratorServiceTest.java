package com.complexica.lotterynumbergenerator.service;

import com.complexica.lotterynumbergenerator.dao.UserRepository;
import com.complexica.lotterynumbergenerator.enricher.Mapper;
import com.complexica.lotterynumbergenerator.entity.UserEntity;
import com.complexica.lotterynumbergenerator.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;

public class LotteryNumberGeneratorServiceTest {

    @InjectMocks
    private LotteryNumberGeneratorService lotteryNumberGeneratorService;
    @Mock
    private UserRepository userRepository;

    @Mock
    private Mapper mapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserTest() {
        String name = "vineesh";
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setName(name);
        when(userRepository.findByName(ArgumentMatchers.anyString())).thenReturn(entity);
        User  newUser = new User();
        newUser.setName("vineesh");
        when(mapper.transform(entity)).thenReturn(newUser);
        User user = lotteryNumberGeneratorService.getUser(name);
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getName()).isNotNull();
        Assertions.assertThat(user.getName()).isEqualTo(name);
    }

    @Test
    void generateLotteryNumbersTest() {
        List<String> randomNumbers = lotteryNumberGeneratorService.generateLotteryNumbers();
        Assertions.assertThat(randomNumbers).isNotNull();
        Assertions.assertThat(randomNumbers).hasSize(6);
        Assertions.assertThat(new HashSet<>(randomNumbers)).hasSameSizeAs(randomNumbers);
    }

}
