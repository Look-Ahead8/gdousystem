package com.gdou.gdousystem.service;

import com.gdou.gdousystem.vo.GetExcelVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Meng
 * @date 2019/12/25
 */
public interface ScoreService {
    HSSFWorkbook createExcel(GetExcelVO getExcelVO);
}
