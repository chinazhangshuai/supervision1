package com.iscas.common.tools.core.collection;

import cn.hutool.core.map.MapUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;

/**
 * Map扩展工具测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2019/5/23 9:42
 * @since jdk1.8
 */
@RunWith(JUnit4.class)
public class MapRaiseUtilsTests {

    @Test
    public void test1() {
        Map<Object, Object> map = MapUtil.builder().put("a_param", 1)
                .put("b_param", 2).build();
        map = MapRaiseUtils.convertToHump(map);
        System.out.println(map);
    }
}
