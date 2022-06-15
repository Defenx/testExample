package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserOnline {
    private LocalDate startSession;
    private LocalDate endSession;

}
