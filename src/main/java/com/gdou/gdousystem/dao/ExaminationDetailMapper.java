package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.dto.ExaminationDetailDto;
import com.gdou.gdousystem.dto.ExeclHeaderDto;
import com.gdou.gdousystem.vo.GetExcelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/25
 */
public interface ExaminationDetailMapper {
    List<ExaminationDetailDto> selectAllCourseExaminationSelective(@Param("version") String version,@Param("courseId") String courseId,@Param("type") String type);

    List<ExeclHeaderDto> selectAllDetailsByTeacherAndCourseAndTerm(GetExcelVO getExcelVO);
}
