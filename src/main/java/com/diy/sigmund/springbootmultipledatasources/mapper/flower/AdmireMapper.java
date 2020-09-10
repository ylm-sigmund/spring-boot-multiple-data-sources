package com.diy.sigmund.springbootmultipledatasources.mapper.flower;

import com.diy.sigmund.springbootmultipledatasources.entity.AdmireDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdmireMapper {
    int deleteByPrimaryKey(Integer admireid);

    int insert(AdmireDO record);

    int insertSelective(AdmireDO record);

    AdmireDO selectByPrimaryKey(Integer admireid);

    int updateByPrimaryKeySelective(AdmireDO record);

    int updateByPrimaryKey(AdmireDO record);

}