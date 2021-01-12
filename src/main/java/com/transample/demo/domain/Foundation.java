package com.transample.demo.domain;

import java.io.Serializable;

/**
 * foundation
 * @author
 */
public class Foundation implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 基金会名称
     */
    private String name;

    /**
     * 英文名字
     */
    private String englishName;

    /**
     * 地址
     */
    private String address;

    /**
     * 注册资本
     */
    private Integer rigisterMoney;

    /**
     * 法人代表
     */
    private String legalPerson;

    /**
     * 性质
     */
    private String type;

    /**
     * 主管部门
     */
    private String administration;

    /**
     * 登陆密码
     */
    private String password;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRigisterMoney() {
        return rigisterMoney;
    }

    public void setRigisterMoney(Integer rigisterMoney) {
        this.rigisterMoney = rigisterMoney;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Foundation other = (Foundation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getRigisterMoney() == null ? other.getRigisterMoney() == null : this.getRigisterMoney().equals(other.getRigisterMoney()))
                && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getAdministration() == null ? other.getAdministration() == null : this.getAdministration().equals(other.getAdministration()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getRigisterMoney() == null) ? 0 : getRigisterMoney().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAdministration() == null) ? 0 : getAdministration().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", englishName=").append(englishName);
        sb.append(", address=").append(address);
        sb.append(", rigisterMoney=").append(rigisterMoney);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", type=").append(type);
        sb.append(", administration=").append(administration);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}