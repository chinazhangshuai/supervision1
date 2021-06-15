package com.iscas.biz.samples.interractionProtocol.service;

import com.iscas.biz.samples.interractionProtocol.model.ComboboxModelTest;
import com.iscas.templet.view.table.ComboboxData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:52
 * @since jdk1.8
 */
@Service
public class ComboboxServiceTest {
    private static List<ComboboxModelTest> comboboxModelTests = new ArrayList<>();
    static {
        //测试构建一个Tree,实际应该从数据库获取
        Collections.addAll(comboboxModelTests, new ComboboxModelTest(1, "zhangsan", "lallala"),
                new ComboboxModelTest(2, "lisi", "heihiehie"),
                new ComboboxModelTest(3, "wangwu", "gagaga"),
                new ComboboxModelTest(4, "zhaoliu", "hahahaha"),
                new ComboboxModelTest(5, "xiaowang", "guaguagua"),
                new ComboboxModelTest(6, "xiaoli", "xixixixix"));

    }

    public List<ComboboxData> getCombobox() {
        List<ComboboxData> comboboxDatas = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(comboboxModelTests)) {
            for (ComboboxModelTest comboboxModelTest : comboboxModelTests) {
                ComboboxData<ComboboxModelTest> comboboxData = new ComboboxData<>();
                comboboxData.setValue(comboboxModelTest.getId());
                comboboxData.setLabel(comboboxModelTest.getName());
                comboboxData.setData(comboboxModelTest);
                comboboxDatas.add(comboboxData);
            }
        }
        return comboboxDatas;
    }
}
