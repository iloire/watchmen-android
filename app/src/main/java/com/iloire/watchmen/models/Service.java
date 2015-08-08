package com.iloire.watchmen.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Service {

    private String name;
    private String url;
    private Integer port;
    private Integer interval;
    private Integer failureInterval;
    private Integer timeout;
    private Integer warningThreshold;
    private String pingServiceName;
    private PingServiceOptions pingServiceOptions;
    private String id;
    private Long created;
    private Boolean isRestricted;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The port
     */
    public Integer getPort() {
        return port;
    }

    /**
     *
     * @param port
     * The port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     *
     * @return
     * The interval
     */
    public Integer getInterval() {
        return interval;
    }

    /**
     *
     * @param interval
     * The interval
     */
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     *
     * @return
     * The failureInterval
     */
    public Integer getFailureInterval() {
        return failureInterval;
    }

    /**
     *
     * @param failureInterval
     * The failureInterval
     */
    public void setFailureInterval(Integer failureInterval) {
        this.failureInterval = failureInterval;
    }

    /**
     *
     * @return
     * The timeout
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     *
     * @param timeout
     * The timeout
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     *
     * @return
     * The warningThreshold
     */
    public Integer getWarningThreshold() {
        return warningThreshold;
    }

    /**
     *
     * @param warningThreshold
     * The warningThreshold
     */
    public void setWarningThreshold(Integer warningThreshold) {
        this.warningThreshold = warningThreshold;
    }

    /**
     *
     * @return
     * The pingServiceName
     */
    public String getPingServiceName() {
        return pingServiceName;
    }

    /**
     *
     * @param pingServiceName
     * The pingServiceName
     */
    public void setPingServiceName(String pingServiceName) {
        this.pingServiceName = pingServiceName;
    }

    /**
     *
     * @return
     * The pingServiceOptions
     */
    public PingServiceOptions getPingServiceOptions() {
        return pingServiceOptions;
    }

    /**
     *
     * @param pingServiceOptions
     * The pingServiceOptions
     */
    public void setPingServiceOptions(PingServiceOptions pingServiceOptions) {
        this.pingServiceOptions = pingServiceOptions;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The created
     */
    public Long getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The isRestricted
     */
    public Boolean getIsRestricted() {
        return isRestricted;
    }

    /**
     *
     * @param isRestricted
     * The isRestricted
     */
    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}