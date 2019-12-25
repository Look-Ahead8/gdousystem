package com.gdou.gdousystem.dto;

import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class CourseOverallAchievementDto {
    private String targetName;
    private String content;
    private List<Map<String,Double>> type;
    private Double actualSum;
    private Double targetSum;
    private Double result;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Map<String, Double>> getType() {
        return type;
    }

    public void setType(List<Map<String, Double>> type) {
        this.type = type;
    }

    public Double getActualSum() {
        return actualSum;
    }

    public void setActualSum(Double actualSum) {
        this.actualSum = actualSum;
    }

    public Double getTargetSum() {
        return targetSum;
    }

    public void setTargetSum(Double targetSum) {
        this.targetSum = targetSum;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
