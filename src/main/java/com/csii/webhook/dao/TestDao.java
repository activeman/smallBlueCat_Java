package com.csii.webhook.dao;



import com.csii.webhook.model.pojo.ConversationRecord;
import com.csii.webhook.model.pojo.SessionEntry;
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
    //存储taskQuery 的List<ConversationRecord>
    int saveTaskQueryConRcdEntity(List<ConversationRecord> conversationRecords);
    //存储taskQuery 的sessionEntry
    int saveTaskQuerySessionEntry(SessionEntry sessionvalue);
}
