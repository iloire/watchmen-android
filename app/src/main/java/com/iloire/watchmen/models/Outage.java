
package com.iloire.watchmen.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Outage {

    private long timestamp;
    private Error error;
    private int downtime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * @return
     *     The error
     */
    public Error getError() {
        return error;
    }

    /**
     * 
     * @param error
     *     The error
     */
    public void setError(Error error) {
        this.error = error;
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
