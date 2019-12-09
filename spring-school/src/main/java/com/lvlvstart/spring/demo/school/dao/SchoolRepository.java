package com.lvlvstart.spring.demo.school.dao;

import com.lvlvstart.spring.demo.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 15:52
 */
public interface SchoolRepository extends JpaRepository<School,String> {
}
