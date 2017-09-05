package com.caijx.service;

import com.caijx.domain.Girl;
import com.caijx.enums.ResultEnum;
import com.caijx.exception.GirlException;
import com.caijx.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/8/26/026.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
//            返回你可能还在上小学吧 code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
//            返回你可能在上初中吧 code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
