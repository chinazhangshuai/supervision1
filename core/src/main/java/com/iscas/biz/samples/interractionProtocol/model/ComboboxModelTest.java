package com.iscas.biz.samples.interractionProtocol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:53
 * @since jdk1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComboboxModelTest {
    private Integer id;
    private String name;
    private String other;
}
