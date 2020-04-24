package com.csii.webhook.dao;



import com.csii.webhook.model.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
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
    //查询taskquery
    TaskQuery selTaskQuery(int taskQueryId);
    //查询taskquery对应的requestdata 集合
    List<RequestData> selTaskQueryReqData(int taskQueryId);
    //查询taskquery对应的 List<SlotEntity> slotEntities = null;
    List<SessionEntry> selTaskQuerySessionList(int taskQueryId);
}
