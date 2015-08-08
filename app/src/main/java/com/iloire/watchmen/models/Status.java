
package com.iloire.watchmen.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Status {

    private Object currentOutage;
    private Last24Hours last24Hours;
    private LastWeek lastWeek;
    private LastHour lastHour;
    private List<LatestOutage> latestOutages = new ArrayList<LatestOutage>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The currentOutage
     */
    public Object getCurrentOutage() {
        return currentOutage;
    }

    /**
     * 
     * @param currentOutage
     *     The currentOutage
     */
    public void setCurrentOutage(Object currentOutage) {
        this.currentOutage = currentOutage;
    }

    /**
     * 
     * @return
     *     The last24Hours
     */
    public Last24Hours getLast24Hours() {
        return last24Hours;
    }

    /**
     * 
     * @param last24Hours
     *     The last24Hours
     */
    public void setLast24Hours(Last24Hours last24Hours) {
        this.last24Hours = last24Hours;
    }

    /**
     * 
     * @return
     *     The lastWeek
     */
    public LastWeek getLastWeek() {
        return lastWeek;
    }

    /**
     * 
     * @param lastWeek
     *     The lastWeek
     */
    public void setLastWeek(LastWeek lastWeek) {
        this.lastWeek = lastWeek;
    }

    /**
     * 
     * @return
     *     The lastHour
     */
    public LastHour getLastHour() {
        return lastHour;
    }

    /**
     * 
     * @param lastHour
     *     The lastHour
     */
    public void setLastHour(LastHour lastHour) {
        this.lastHour = lastHour;
    }

    /**
     * 
     * @return
     *     The latestOutages
     */
    public List<LatestOutage> getLatestOutages() {
        return latestOutages;
    }

    /**
     * 
     * @param latestOutages
     *     The latestOutages
     */
    public void setLatestOutages(List<LatestOutage> latestOutages) {
        this.latestOutages = latestOutages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
