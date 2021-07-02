/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zohrab
 */
@Entity
@Table(name = "emplyoment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmplyomentHistory.findAll", query = "SELECT e FROM EmplyomentHistory e"),
    @NamedQuery(name = "EmplyomentHistory.findById", query = "SELECT e FROM EmplyomentHistory e WHERE e.id = :id"),
    @NamedQuery(name = "EmplyomentHistory.findByHeader", query = "SELECT e FROM EmplyomentHistory e WHERE e.header = :header"),
    @NamedQuery(name = "EmplyomentHistory.findByBeginDate", query = "SELECT e FROM EmplyomentHistory e WHERE e.beginDate = :beginDate"),
    @NamedQuery(name = "EmplyomentHistory.findByEndDate", query = "SELECT e FROM EmplyomentHistory e WHERE e.endDate = :endDate")})
public class EmplyomentHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "header")
    private String header;
    @Basic(optional = false)
    @NotNull
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "job_description")
    private String jobDescription;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public EmplyomentHistory() {
    }

    public EmplyomentHistory(Integer id) {
        this.id = id;
    }

    public EmplyomentHistory(Integer id, String header, Date beginDate, String jobDescription) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.jobDescription = jobDescription;
    }
     public EmplyomentHistory(Integer id, String header, java.sql.Date beginDate, java.sql.Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user =user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmplyomentHistory)) {
            return false;
        }
        EmplyomentHistory other = (EmplyomentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.EmplyomentHistory[ id=" + id + "  Header= "+header+" ]";
    }
    
}
