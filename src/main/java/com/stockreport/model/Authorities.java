package com.stockreport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Matty on 08/10/2016.
 */

@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private int authoritiesId;

    private String username;
    private String authority;

    public int getAuthorityId() {
        return authoritiesId;
    }

    public void setAuthorityId(int authorityId) {
        this.authoritiesId = authorityId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
