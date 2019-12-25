package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class Sql1Dto {
    private Integer targetId;
    private String targetName;
    private String content;
    private Double actualSum;
    private Double targetSum;
    private Double result;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

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
