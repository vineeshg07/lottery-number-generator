package com.complexica.lotterynumbergenerator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LotteryNumberEntity> lotteryNumbers;

    public UserEntity() {}

    public UserEntity(String name) {
        this.name = name.trim().toLowerCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LotteryNumberEntity> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void setLotteryNumbers(List<LotteryNumberEntity> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }
}
