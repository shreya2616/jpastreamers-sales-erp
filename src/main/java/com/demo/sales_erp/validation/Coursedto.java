package com.demo.sales_erp.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coursedto {

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Instructor is required")
    private String instructor;

    @NotBlank(message = "Amount is required")
    @Min(value = 100, message = "Amount should be greater than equal to 100")
    private int amount;

    @NotBlank(message = "Discounted Amount is required")
    @Min(value = 80, message = "Discounted Amount can be greater than equal to 80")
    private int discountedAmount;

    @NotBlank(message = "Duration is required")
    @Min(value = 1, message = "Duration should be minimum of 1 hour")
    private int duration;

    private int enrollmentCount;

    @NotBlank(message = "Level cannot be empty")
    @Pattern(regexp = "^(BEGINNER|INTERMEDIATE|ADVANCE)$", message = "Level can be beginner, intermediate, advance")
    private String level;

    @NotBlank(message = "Language cannot be null")
    private String language;

}
