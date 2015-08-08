
package com.iloire.watchmen.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class LastWeek {

    private List<Outage> outages = new ArrayList<Outage>();
    private int numberOutages;
    private double downtime;
    private float uptime;
    private Latency latency;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The outages
     */
    public List<Outage> getOutages() {
        return outages;
    }

    /**
     * 
     * @param outages
     *     The outages
     */
    public void setOutages(List<Outage> outages) {
        this.outages = outages;
    }

    /**
     * 
     * @return
     *     The numberOutages
     */
    public int getNumberOutages() {
        return numberOutages;
    }

    /**
     * 
     * @param numberOutages
     *     The numberOutages
     */
    public void setNumberOutages(int numberOutages) {
        this.numberOutages = numberOutages;
    }

    /**
     * 
     * @return
     *     The downtime
     */
    public double getDowntime() {
        return downtime;
    }

    /**
     * 
     * @param downtime
     *     The downtime
     */
    public void setDowntime(double downtime) {
        this.downtime = downtime;
    }

    /**
     * 
     * @return
     *     The uptime
     */
    public float getUptime() {
        return uptime;
    }

    /**
     * 
     * @param uptime
     *     The uptime
     */
    public void setUptime(float uptime) {
        this.uptime = uptime;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
