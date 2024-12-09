package com.spp.demo.helloworld.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVO {
    private String uniqueId;
    private String name;
    private String rollNumber;
    private String dob;
}
