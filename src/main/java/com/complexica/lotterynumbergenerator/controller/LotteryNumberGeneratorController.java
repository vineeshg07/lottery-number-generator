package com.complexica.lotterynumbergenerator.controller;

import ch.qos.logback.core.util.StringUtil;
import com.complexica.lotterynumbergenerator.exception.BusinessException;
import com.complexica.lotterynumbergenerator.exception.TechnicalException;
import com.complexica.lotterynumbergenerator.log.LogTimeTaken;
import com.complexica.lotterynumbergenerator.model.User;
import com.complexica.lotterynumbergenerator.service.LotteryNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LotteryNumberGeneratorController {

    @Autowired
    private LotteryNumberGeneratorService lotteryNumberGeneratorService;

    /**
    ** To store user data if not available
     * Generate 6 random numbers and persist
     **/
    @GetMapping("/spin")
    @LogTimeTaken
    public User generateRandomNumbers(@RequestParam String name) {
        if(StringUtil.isNullOrEmpty(name)) {
            throw new BusinessException("User cannot be empty");
        }
        User response = null;
        try {
            String trimmedName = name.trim().toLowerCase();
            User user = lotteryNumberGeneratorService.getUser(trimmedName);
            if (user == null) {
                user = lotteryNumberGeneratorService.saveUser(trimmedName);
            }
            List<String> randomNumbers = lotteryNumberGeneratorService.generateLotteryNumbers();
            lotteryNumberGeneratorService.saveGeneratedLotteryNumbers(user, randomNumbers);
            response = new User();
            response.setLotteryNumbers(randomNumbers);
            response.setName(trimmedName);
            return response;

        }catch(Exception exception){
            throw new TechnicalException("Exception During Process");
        }
    }

    /**
     ** To fetch all random numbers generated for the user
     **/
    @GetMapping("/history")
    @LogTimeTaken
    public User getHistory(@RequestParam String name) {
        User response = null;
        User user = lotteryNumberGeneratorService.getUser(name.trim().toLowerCase());
        if(user == null) {
            throw new BusinessException("User Not Found");
        }
        response =  lotteryNumberGeneratorService.getLotteryNumberHistory(user);

        return response;
    }
}
