package cn.itcast.domain.feedback;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Feedback implements Serializable {
    private String feedbackId;

    private String inputBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;

    private String title;

    private String content;

    private String classType;

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", inputBy='" + inputBy + '\'' +
                ", inputTime=" + inputTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", classType='" + classType + '\'' +
                ", tel='" + tel + '\'' +
                ", answerBy='" + answerBy + '\'' +
                ", answerTime=" + answerTime +
                ", solveMethod='" + solveMethod + '\'' +
                ", resolution='" + resolution + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", isShare='" + isShare + '\'' +
                ", state=" + state +
                ", createBy='" + createBy + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public Integer getState() {
        return state;
    }



    public void setState(Integer state) {
        this.state = state;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String tel;

    private String answerBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date answerTime;

    private String solveMethod;

    private String resolution;

    private String difficulty;

    private String isShare;

    private Integer state;

    private String createBy;

    private String createDept;

    private Date createTime;

    private String companyId;

    private String companyName;

    private static final long serialVersionUID = 1L;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy == null ? null : inputBy.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAnswerBy() {
        return answerBy;
    }

    public void setAnswerBy(String answerBy) {
        this.answerBy = answerBy == null ? null : answerBy.trim();
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getSolveMethod() {
        return solveMethod;
    }

    public void setSolveMethod(String solveMethod) {
        this.solveMethod = solveMethod == null ? null : solveMethod.trim();
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getIsShare() {
        return isShare;
    }

    public void setIsShare(String isShare) {
        this.isShare = isShare == null ? null : isShare.trim();
    }



    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept == null ? null : createDept.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}