package com.gdou.gdousystem.service.impl;

import com.gdou.gdousystem.bean.Course;
import com.gdou.gdousystem.bean.Schedule;
import com.gdou.gdousystem.dao.ScheduleMapper;
import com.gdou.gdousystem.dao.StudentMapper;
import com.gdou.gdousystem.service.ScheduleService;
import com.gdou.gdousystem.vo.DeleteScheduleVO;
import com.gdou.gdousystem.vo.ScheduleVO;
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
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean saveSchedule(ScheduleVO schedule) {
        List<String> studentIds = studentMapper.selectAllStudentIdByDepartmentAndMajorAndStudentClass(schedule.getDepartment(), schedule.getMajor(), schedule.getStudentClass());
        List<Schedule> schedules=scheduleMapper.selectScheduleByVersionAndCourseIdAndTeacherIdAndTermAndStudentId(schedule.getVersion(),schedule.getCourseId(),schedule.getTerm(),studentIds.get(0),schedule.getTeacherId());
        if(!schedules.isEmpty()) return false;
        for (String studentId : studentIds) {
            schedule.setStudentId(studentId);
            scheduleMapper.insertSchedule(schedule);
        }
        return true;
    }

    @Override
    public List<Course> findAllSchedulesSelective(String department, String major, String studentClass) {
        return scheduleMapper.selectAllSchedulesSelective(toSqlParam(department),toSqlParam(major),toSqlParam(studentClass));
    }

    @Override
    public boolean deleteScheduleByDeleteScheduleVO(DeleteScheduleVO schedule) {
        return scheduleMapper.deleteScheduleByDeleteScheduleVO(schedule)>0;
    }

    private String toSqlParam(String str){
        return str=str.isEmpty()?"%":"%"+str+"%";
    }
}
