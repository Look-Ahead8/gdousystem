package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Indicator;
import com.gdou.gdousystem.dao.IndicatorMapper;
import com.gdou.gdousystem.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
@Service
@Transactional
public class IndicatorServiceImpl implements IndicatorService {
    @Autowired
    private IndicatorMapper indicatorMapper;


    @Override
    public List<Indicator> findAllIndicators() {
        return indicatorMapper.selectAllIndicators();
    }

    @Override
    public boolean saveIndicator(Indicator indicator) {
        return indicatorMapper.insertIndicator(indicator)>0;
    }
}
