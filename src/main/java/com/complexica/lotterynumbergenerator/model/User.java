package com.complexica.lotterynumbergenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lottery-numbers")
    private List<String> lotteryNumbers;
}
