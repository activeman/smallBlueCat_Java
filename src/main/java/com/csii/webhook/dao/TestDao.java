package com.csii.webhook.dao;



import com.csii.webhook.model.pojo.SlotEntity;
import com.csii.webhook.model.pojo.TaskQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Mapper
public interface TestDao {
    // 存储 TaskQuery对象
    int saveTaskQuery(TaskQuery taskQuery);
    //存储taskQuery 的 Map<String, String> requestData
    int saveTaskQueryReqMapData(int taskQueryId,String key, String value);
    //存储taskQuery 的 List<SlotEntity> slotEntities
    int saveTaskQuerySlotEntity(List<SlotEntity> slotEntities);
}
