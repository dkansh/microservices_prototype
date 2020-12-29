package com.ibm.bookingservice.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ErrorVO {
    String errorCode;
    String errorDescription;
}
