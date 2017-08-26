package com.caijx;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26/026.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄段来查询
    public List<Girl> findByAge(Integer age);
}
