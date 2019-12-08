package cn.itcast.domain.cargo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private String id;

    private String number;

    private String photo;

    private String description;

    private String factoryid;

    private String factoryname;

    private Long price;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;

    private String color;

    private String packaging;

    private String packages;

    private String containertype;

    private Integer amount;

    private BigDecimal volume;

    private BigDecimal bigboxlength;

    private BigDecimal bigboxwidth;

    private BigDecimal bigboxheight;

    private String remark;

    private Date entry;

    private String creator;

    private String createdept;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(String factoryid) {
        this.factoryid = factoryid == null ? null : factoryid.trim();
    }

    public String getFactoryname() {
        return factoryname;
    }

    public void setFactoryname(String factoryname) {
        this.factoryname = factoryname == null ? null : factoryname.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages == null ? null : packages.trim();
    }

    public String getContainertype() {
        return containertype;
    }

    public void setContainertype(String containertype) {
        this.containertype = containertype == null ? null : containertype.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getBigboxlength() {
        return bigboxlength;
    }

    public void setBigboxlength(BigDecimal bigboxlength) {
        this.bigboxlength = bigboxlength;
    }

    public BigDecimal getBigboxwidth() {
        return bigboxwidth;
    }

    public void setBigboxwidth(BigDecimal bigboxwidth) {
        this.bigboxwidth = bigboxwidth;
    }

    public BigDecimal getBigboxheight() {
        return bigboxheight;
    }

    public void setBigboxheight(BigDecimal bigboxheight) {
        this.bigboxheight = bigboxheight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatedept() {
        return createdept;
    }

    public void setCreatedept(String createdept) {
        this.createdept = createdept == null ? null : createdept.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}