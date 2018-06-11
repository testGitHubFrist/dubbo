package com.dubbo.common.entity;

import java.util.Date;

/**
 * @author zhangshanchaungTest
 * @desc 视频详情实体类
 * @date 2017-5-10
 * @since 1.0
 */
public class VideoVideoInfo implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6374394409574974542L;
    private Integer id;//id

    private String videoId;//视频id
    private String videoTitleMaster;//视频主标题
    private String videoTitleSlave;//视频副标题
    private Integer videoTime;//视频总时间,以秒为单位
    private String videoAuthorName;//视频作者名称
    private String videoAuthorId;//视频作者id
    private String videoURL;//视频URL
    private String videoType;//视频类型（精选视频...）
    private String videoFrameRate;//视频帧率
    private Integer videoResolutionWidth;//视频分辨率-宽度
    private Integer videoResolutionHeight;//视频分辨率-高度
    private Integer videoStatus;//视频状态,0:已删除,5:下架,10:已上传(待分析),20:已分析(待标注),30:已加标签(待发布),40:已发布'
    private Integer videoCategories;//是否为精选视频(1：精选)
    private String createBy;// 创建人
    private Date createDate;// 创建时间
    private String updateBy;// 更新人
    private Date updateDate;// 更新时间
    private String videoBigImgURL;
    private String videoLittleImgURL;
    private String videoOrganization;//视频所属组织
    private String videoLoadingImgURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitleMaster() {
        return videoTitleMaster;
    }

    public void setVideoTitleMaster(String videoTitleMaster) {
        this.videoTitleMaster = videoTitleMaster;
    }

    public String getVideoTitleSlave() {
        return videoTitleSlave;
    }

    public void setVideoTitleSlave(String videoTitleSlave) {
        this.videoTitleSlave = videoTitleSlave;
    }

    public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoAuthorName() {
        return videoAuthorName;
    }

    public void setVideoAuthorName(String videoAuthorName) {
        this.videoAuthorName = videoAuthorName;
    }

    public String getVideoAuthorId() {
        return videoAuthorId;
    }

    public void setVideoAuthorId(String videoAuthorId) {
        this.videoAuthorId = videoAuthorId;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoFrameRate() {
        return videoFrameRate;
    }

    public void setVideoFrameRate(String videoFrameRate) {
        this.videoFrameRate = videoFrameRate;
    }

    public Integer getVideoResolutionWidth() {
        return videoResolutionWidth;
    }

    public void setVideoResolutionWidth(Integer videoResolutionWidth) {
        this.videoResolutionWidth = videoResolutionWidth;
    }

    public Integer getVideoResolutionHeight() {
        return videoResolutionHeight;
    }

    public void setVideoResolutionHeight(Integer videoResolutionHeight) {
        this.videoResolutionHeight = videoResolutionHeight;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Integer getVideoCategories() {
        return videoCategories;
    }

    public void setVideoCategories(Integer videoCategories) {
        this.videoCategories = videoCategories;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVideoBigImgURL() {
        return videoBigImgURL;
    }

    public void setVideoBigImgURL(String videoBigImgURL) {
        this.videoBigImgURL = videoBigImgURL;
    }

    public String getVideoLittleImgURL() {
        return videoLittleImgURL;
    }

    public void setVideoLittleImgURL(String videoLittleImgURL) {
        this.videoLittleImgURL = videoLittleImgURL;
    }

    public String getVideoOrganization() {
        return videoOrganization;
    }

    public void setVideoOrganization(String videoOrganization) {
        this.videoOrganization = videoOrganization;
    }

    public String getVideoLoadingImgURL() {
        return videoLoadingImgURL;
    }

    public void setVideoLoadingImgURL(String videoLoadingImgURL) {
        this.videoLoadingImgURL = videoLoadingImgURL;
    }

}
