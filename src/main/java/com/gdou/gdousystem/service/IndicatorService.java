package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Indicator;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface IndicatorService {
    List<Indicator> findAllIndicators();

    boolean saveIndicator(Indicator indicator);
}
