package com.example.school;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FullSchoolResponse {

    String name;
    String emaill;
    List<Student>students;
}
