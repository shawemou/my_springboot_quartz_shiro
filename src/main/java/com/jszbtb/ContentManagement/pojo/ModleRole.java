package com.jszbtb.ContentManagement.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "modle_role")
public class ModleRole implements Serializable {
    @Id
    private String id;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "modle_id")
    private String modleId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return modle_id
     */
    public String getModleId() {
        return modleId;
    }

    /**
     * @param modleId
     */
    public void setModleId(String modleId) {
        this.modleId = modleId;
    }
}