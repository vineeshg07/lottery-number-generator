package com.complexica.lotterynumbergenerator.dao;

import com.complexica.lotterynumbergenerator.entity.LotteryNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotteryNumberRepository extends JpaRepository<LotteryNumberEntity, Long> {

    List<LotteryNumberEntity> findByUserIdOrderByIdDesc(Long userId);
}
