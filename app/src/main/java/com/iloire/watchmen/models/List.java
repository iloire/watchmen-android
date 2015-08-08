
package com.iloire.watchmen.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class List {

    private int t;
    private int l;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The t
     */
    public int getT() {
        return t;
    }

    /**
     * 
     * @param t
     *     The t
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * 
     * @return
     *     The l
     */
    public int getL() {
        return l;
    }

    /**
     * 
     * @param l
     *     The l
     */
    public void setL(int l) {
        this.l = l;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
