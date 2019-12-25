package com.gdou.gdousystem.bean;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Meng
 * @date 2019/12/24
 */
public class GraduationRequirement {
    private Integer graduationRequirementId;
    @NotBlank(message = "内容不可以为空")
    private String content;
    @NotBlank(message = "版本号不可以为空")
    private String version;
    private List<Indicator> indicator;

    public Integer getGraduationRequirementId() {
        return graduationRequirementId;
    }

    public void setGraduationRequirementId(Integer graduationRequirementId) {
        this.graduationRequirementId = graduationRequirementId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Indicator> getIndicator() {
        return indicator;
    }

    public void setIndicator(List<Indicator> indicator) {
        this.indicator = indicator;
    }
}
