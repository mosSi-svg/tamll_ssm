package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.PropertyValueMapper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyValueImpl  implements PropertyValueService {

    @Autowired
    PropertyValueMapper propertyValueMapper;


    @Autowired
    PropertyService propertyService;

    @Override
    public List<PropertyValue> lists( int pid ) {
    PropertyValueExample propertyValueExample = new PropertyValueExample ();

    propertyValueExample.createCriteria ().andPidEqualTo (pid);

    List<PropertyValue> lists = propertyValueMapper.selectByExample (propertyValueExample);

    for( PropertyValue pv : lists ){

        Property pro = propertyService.get ( pv.getPid ());

        pv.setProperty (pro);

    }

    return lists;


    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample propertyExample = new PropertyValueExample ();
        propertyExample.createCriteria ().andPidEqualTo (pid).andIdEqualTo (ptid);
        List<PropertyValue> pros = propertyValueMapper.selectByExample (propertyExample);
        if( pros == null)
            return  null;

            return pros.get (0);
    }

    @Override
    public void init(Product p) {
        List<Property> pts = propertyService.list(p.getCid());

        for (Property pt: pts) {
            PropertyValue pv = get(pt.getId(),p.getId());
            if(null==pv){
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }


    }


    @Override
    public void update(PropertyValue propertyValue) {

        propertyValueMapper.updateByPrimaryKey (propertyValue);
    }
}
