
package com.iloire.watchmen.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Error {

    private String code;
    private String errno;
    private String syscall;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The errno
     */
    public String getErrno() {
        return errno;
    }

    /**
     * 
     * @param errno
     *     The errno
     */
    public void setErrno(String errno) {
        this.errno = errno;
    }

    /**
     * 
     * @return
     *     The syscall
     */
    public String getSyscall() {
        return syscall;
    }

    /**
     * 
     * @param syscall
     *     The syscall
     */
    public void setSyscall(String syscall) {
        this.syscall = syscall;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
