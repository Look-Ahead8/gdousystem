package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/26
 */
public class IndicatorTargetDto {
    private String targetName;
    private String content;
    private Double supportRate;
    private Double weight;
    private String year;
    private String indicatorName;

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
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

    public Double getSupportRate() {
        return supportRate;
    }

    public void setSupportRate(Double supportRate) {
        this.supportRate = supportRate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
