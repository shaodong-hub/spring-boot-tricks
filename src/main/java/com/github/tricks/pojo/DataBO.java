package com.github.tricks.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
 * @author 石少东
 * @date 2020-11-11 13:04
 * @since 1.0
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataBO implements Serializable {

    private static final long serialVersionUID = 4562463076984025444L;

    private String data;
}
