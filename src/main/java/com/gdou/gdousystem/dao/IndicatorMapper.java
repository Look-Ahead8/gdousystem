package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Indicator;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface IndicatorMapper {
    List<Indicator> selectAllIndicators();

    int insertIndicator(Indicator indicator);
}
