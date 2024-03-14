package com.maduka.sprngbt1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "department")
@Table
public class Department  extends BaseEntity{

//    private Long departmentId;
    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

// VAlidation issues ....
//    @Length(min = 1, max = 5)
//    @Email
//    @Size(max = 10, min = 0)
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero

    // Dealing with date validation.
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
//    private String departmentCode;

}
