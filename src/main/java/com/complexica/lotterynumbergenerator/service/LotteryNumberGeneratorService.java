package com.complexica.lotterynumbergenerator.service;

import com.complexica.lotterynumbergenerator.dao.LotteryNumberRepository;
import com.complexica.lotterynumbergenerator.dao.UserRepository;
import com.complexica.lotterynumbergenerator.enricher.Mapper;
import com.complexica.lotterynumbergenerator.entity.LotteryNumberEntity;
import com.complexica.lotterynumbergenerator.entity.UserEntity;
import com.complexica.lotterynumbergenerator.log.LogTimeTaken;
import com.complexica.lotterynumbergenerator.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LotteryNumberGeneratorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LotteryNumberRepository lotteryNumberRepository;

    @Autowired
    private Mapper mapper;

    public User getUser(String name) {
        UserEntity entity = userRepository.findByName(name);
        return mapper.transform(entity);
    }

    @Transactional
    public User saveUser(String name) {
        UserEntity entity = userRepository.save(new UserEntity(name));
        return mapper.transform(entity);
    }

    public List<String> generateLotteryNumbers() {
        Set<Integer> numbers = new HashSet<>();
        SecureRandom random = new SecureRandom();
        while(numbers.size() < 6) {
            numbers.add(random.nextInt(45));
        }
        return numbers.stream().sorted().map(String::valueOf).collect(Collectors.toList());
    }

    @Transactional
    public void saveGeneratedLotteryNumbers(User user, List<String> numbers) {
        LotteryNumberEntity lotteryNumberEntity = new LotteryNumberEntity(String.join(",", numbers), mapper.transform(user));
        lotteryNumberRepository.save(lotteryNumberEntity);
    }

    public User getLotteryNumberHistory(User user) {
        List<LotteryNumberEntity> numbers = lotteryNumberRepository.findByUserIdOrderByIdDesc(user.getId());
        List<String> lotteryNumbers = new ArrayList<>();
        for(LotteryNumberEntity number: numbers) {
            lotteryNumbers.add(number.getNumbers());
        }
        user.setLotteryNumbers(lotteryNumbers);
        return user;
    }
}
