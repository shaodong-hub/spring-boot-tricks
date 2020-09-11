package com.github.tricks.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-09-11 11:02
 * @since 1.0
 */


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DateTimeDTO {

    private Date date;

//    private LocalDateTime localDateTime;
}
