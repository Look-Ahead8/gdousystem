package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.dto.IndicatorTargetDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/26
 */
public interface TeachingTargetMapper {
    List<IndicatorTargetDto> selectAllTargetIndicatorSelective(@Param("indicatorName") String toSqlParam);
}
