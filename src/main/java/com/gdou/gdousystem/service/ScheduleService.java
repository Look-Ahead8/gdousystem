package com.gdou.gdousystem.service;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.vo.DeleteScheduleVO;
import com.gdou.gdousystem.vo.ScheduleVO;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public interface ScheduleService {
    boolean saveSchedule(ScheduleVO schedule);

    List<Course> findAllSchedulesSelective(String department, String major, String studentClass);

    boolean deleteScheduleByDeleteScheduleVO(DeleteScheduleVO schedule);
}
