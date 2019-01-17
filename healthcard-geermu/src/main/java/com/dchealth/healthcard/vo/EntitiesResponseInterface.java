package com.dchealth.healthcard.vo;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType
public interface EntitiesResponseInterface {
    public void setEntities(List<Object> entities);
    public List<Object> getEntities();
}
