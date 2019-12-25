package com.gdou.gdousystem.dto;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class ExaminationDetailDto {
    private Integer examinationDetailId;
    private String detailName;
    private Double detailWeight;
    private Double detailScore;
    private String isWeight;
    private String targetName;

    public Integer getExaminationDetailId() {
        return examinationDetailId;
    }

    public void setExaminationDetailId(Integer examinationDetailId) {
        this.examinationDetailId = examinationDetailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Double getDetailWeight() {
        return detailWeight;
    }

    public void setDetailWeight(Double detailWeight) {
        this.detailWeight = detailWeight;
    }

    public Double getDetailScore() {
        return detailScore;
    }

    public void setDetailScore(Double detailScore) {
        this.detailScore = detailScore;
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
