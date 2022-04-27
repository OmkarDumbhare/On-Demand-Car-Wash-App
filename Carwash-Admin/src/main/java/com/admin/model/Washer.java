package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washerDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Washer {

    private int washerId;
    private String name;
    private String address;



}
