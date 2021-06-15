package com.iscas.biz.samples.interractionProtocol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:29
 * @since jdk1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeModelTest {
    private Integer id;
    private Integer pid;
    private String name;
    private Integer count;
    private List<String> owners;
}
