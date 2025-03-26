package com.complexica.lotterynumbergenerator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class LotteryNumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numbers;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public LotteryNumberEntity() {}
    public LotteryNumberEntity(String numbers, UserEntity user) {
        this.numbers = numbers;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LotteryNumberEntity{" +
                "id=" + id +
                ", numbers='" + numbers + '\'' +
                '}';
    }
}
