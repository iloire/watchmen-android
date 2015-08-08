
package com.iloire.watchmen.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class LastHour {

    private List<Object> outages = new ArrayList<Object>();
    private Latency latency;
    private double uptime;
    private int downtime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The outages
     */
    public List<Object> getOutages() {
        return outages;
    }

    /**
     * 
     * @param outages
     *     The outages
     */
    public void setOutages(List<Object> outages) {
        this.outages = outages;
    }

    /**
     * 
     * @return
     *     The latency
     */
    public Latency getLatency() {
        return latency;
    }

    /**
     * 
     * @param latency
     *     The latency
     */
    public void setLatency(Latency latency) {
        this.latency = latency;
    }

    /**
     * 
     * @return
     *     The uptime
     */
    public double getUptime() {
        return uptime;
    }

    /**
     * 
     * @param uptime
     *     The uptime
     */
    public void setUptime(double uptime) {
        this.uptime = uptime;
    }

    /**
     * 
     * @return
     *     The downtime
     */
    public int getDowntime() {
        return downtime;
    }

    /**
     * 
     * @param downtime
     *     The downtime
     */
    public void setDowntime(int downtime) {
        this.downtime = downtime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
