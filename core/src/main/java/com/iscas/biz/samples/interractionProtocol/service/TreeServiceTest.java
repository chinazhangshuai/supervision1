package com.iscas.biz.samples.interractionProtocol.service;

import com.iscas.biz.samples.interractionProtocol.model.TreeModelTest;
import com.iscas.templet.view.tree.TreeResponseData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:28
 * @since jdk1.8
 */
@Service
public class TreeServiceTest {
    private static List<TreeModelTest> treeModelTestList = new ArrayList<>();
    static {
        //测试构建一个Tree,实际应该从数据库获取
        Collections.addAll(treeModelTestList, new TreeModelTest(1, null, "中国", 2, Arrays.asList("1", "2", "3")),
                new TreeModelTest(2, 1, "广州", 4, Arrays.asList("1")),
                new TreeModelTest(3, null, "日本", 5, Arrays.asList("1")),
                new TreeModelTest(4, 2, "深圳", 6, Arrays.asList("2", "3")),
                new TreeModelTest(5, 2, "佛山", 7, Arrays.asList("2", "3", "lalala")),
                new TreeModelTest(6, 3, "北海道", 3, Arrays.asList("hahaha", "heiheihei", "hehehehe")));
    }

    /**
     * 构建tree
     * */
    public TreeResponseData<TreeModelTest> getTree() {
        TreeResponseData<TreeModelTest> treeResponseData = new TreeResponseData<>();
        treeResponseData.setId(null);
        treeResponseData.setLabel("测试树");
        Map<Integer, List<TreeModelTest>> treeModelTestMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(treeModelTestList)) {
            for (TreeModelTest treeModelTest : treeModelTestList) {
                Integer pid = treeModelTest.getPid();
                if (!treeModelTestMap.containsKey(pid)) {
                    List<TreeModelTest> treeModelTests = new ArrayList<>();
                    treeModelTestMap.put(pid, treeModelTests);
                }
                treeModelTestMap.get(pid).add(treeModelTest);
            }
        }
        createTree(treeResponseData, treeModelTestMap, null);
        return treeResponseData;
    }

    private void createTree(TreeResponseData<TreeModelTest> treeResponseData, Map<Integer, List<TreeModelTest>> treeModelTestMap,
                            Integer pid) {
        List<TreeModelTest> treeModelTests = treeModelTestMap.get(pid);
        if (CollectionUtils.isNotEmpty(treeModelTests)) {
            for (TreeModelTest treeModelTest : treeModelTests) {
                TreeResponseData<TreeModelTest> child = new TreeResponseData<>();
                child.setId(treeModelTest.getId());
                child.setLabel(treeModelTest.getName());
                child.setData(treeModelTest);
                if (treeResponseData.getChildren() == null) treeResponseData.setChildren(new ArrayList<>());
                treeResponseData.getChildren().add(child);
                //递归调用
                createTree(child, treeModelTestMap, treeModelTest.getId());
            }
        }
    }


}
