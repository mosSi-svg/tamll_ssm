package com.how2java.tmall.service.impl;

<<<<<<< HEAD
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

        Property pro = propertyService.get ( pv.getPtid ());

        pv.setProperty (pro);

    }

    return lists;


=======
import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.mapper.PropertyValueMapper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.PropertyValueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyValueImpl implements PropertyValueService {
@Autowired
    PropertyMapper propertyMapper;

@Autowired
    PropertyValueMapper  propertyValueMapper;

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample  propertyValueExample = new PropertyValueExample();
        propertyValueExample.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> lists = propertyValueMapper.selectByExample(propertyValueExample);
        for( PropertyValue propertyValue:lists ){
            propertyValue.setProperty(propertyMapper.selectByPrimaryKey(propertyValue.getPtid()));
        }
        return  lists;
>>>>>>> origin/master
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
<<<<<<< HEAD
        PropertyValueExample propertyExample = new PropertyValueExample ();
        propertyExample.createCriteria ().andPidEqualTo (pid).andPtidEqualTo (ptid);
        List<PropertyValue> pros = propertyValueMapper.selectByExample (propertyExample);
        if( pros.isEmpty ())
            return  null;
        else
            return pros.get (0);
    }

    @Override
    public void init(Product p) {
        List<Property> pts = propertyService.list(p.getCid());

        for (Property pt: pts) {
            PropertyValue pv = get(pt.getId(),p.getId());
            if(pv == null ){
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
=======
        PropertyValueExample  propertyValueExample = new PropertyValueExample();
        propertyValueExample.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> lists = propertyValueMapper.selectByExample(propertyValueExample);
        if( lists.isEmpty())
        return null;
        return lists.get(0);
    }

    @Override
    public void init(Product product) {
        PropertyExample  propertyExample = new PropertyExample();
        propertyExample.createCriteria().andCidEqualTo(product.getCid());

        List<Property> pros = propertyMapper.selectByExample(propertyExample);

        for( Property property:pros){

            PropertyValue propertyValue1 = get(property.getId(),product.getId());
            if( propertyValue1 == null ){
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setPid(product.getId());
                propertyValue.setPtid(property.getId());
                propertyValueMapper.insert(propertyValue);
            }
        }
>>>>>>> origin/master
    }
}
