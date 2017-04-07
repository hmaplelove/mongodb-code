package com.casicloud.aop.mongodb.test;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.casicloud.aop.mongodb.iot.IotDataService;
import com.casicloud.aop.mongodb.iot.model.IotData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mongo.xml")
public class MongoTest {
	@Autowired
	IotDataService iotDataService;
	
	@Test
	public void send() throws Exception{
		List<Map<String, Object>> datas=DataUtils.grenData2(1l);
		for (Map<String, Object> data : datas) {
			IotData iotData=new IotData();
			BeanUtils.populate(iotData, data);
			iotDataService.save(iotData);
		}
	}
}
