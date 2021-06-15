package com.iscas.biz.samples.datasongPlus.repository;

import com.iscas.base.biz.test.datasongplus.domain.Achievements;
import com.iscas.datasong.client.plus.repository.DetRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2020/3/2 10:53
 * @since jdk1.8
 */
@Repository
public interface AchievementsRepositoryTest extends DetRepository<Achievements, String> {
    List<Achievements> findByAuthorCNLike(String name);
}
