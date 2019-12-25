package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class ExeclHeaderDto {
    private String detailName;
    private Double detailScore;
    private Double detailWeight;
    private String isWeight;
    private String targetName;

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Double getDetailScore() {
        return detailScore;
    }

    public void setDetailScore(Double detailScore) {
        this.detailScore = detailScore;
    }

    public Double getDetailWeight() {
        return detailWeight;
    }

    public void setDetailWeight(Double detailWeight) {
        this.detailWeight = detailWeight;
    }

    public String getIsWeight() {
        return isWeight;
    }

    public void setIsWeight(String isWeight) {
        this.isWeight = isWeight;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
