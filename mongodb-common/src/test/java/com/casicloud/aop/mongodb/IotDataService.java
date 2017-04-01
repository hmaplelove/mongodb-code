package com.casicloud.aop.mongodb;

import org.springframework.stereotype.Service;

import com.casicloud.aop.mongodb.core.MongoBaseDAO;
import com.casicloud.aop.mongodb.model.IotData;
@Service
public class IotDataService extends MongoBaseDAO<IotData> {

}
