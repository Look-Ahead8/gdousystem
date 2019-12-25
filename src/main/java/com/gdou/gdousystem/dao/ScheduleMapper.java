package com.gdou.gdousystem.dao;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.bean.Schedule;
import com.gdou.gdousystem.bean.Student;
import com.gdou.gdousystem.vo.DeleteScheduleVO;
import com.gdou.gdousystem.vo.GetExcelVO;
import com.gdou.gdousystem.vo.ScheduleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface ScheduleMapper {
    int insertSchedule(ScheduleVO schedule);

    List<Schedule> selectScheduleByVersionAndCourseIdAndTeacherIdAndTermAndStudentId(@Param("version") String version,@Param("courseId") String courseId,@Param("term") String term, @Param("studentId") String studentId,@Param("teacherId")String teacherId);

    List<Course> selectAllSchedulesSelective(@Param("department") String department,@Param("major") String major,@Param("studentClass") String studentClass);

    int deleteScheduleByDeleteScheduleVO(DeleteScheduleVO schedule);

    List<Student> selectScheduleByCourseAndTermAndTeacherId(GetExcelVO getExcelVO);
}
