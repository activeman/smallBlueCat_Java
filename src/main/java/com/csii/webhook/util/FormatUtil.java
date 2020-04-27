package com.csii.webhook.util;

import com.alibaba.da.coin.ide.spi.meta.ConversationRecord;
import com.alibaba.da.coin.ide.spi.meta.SessionEntry;
import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//工具类 编写一些系统工具的工具方法
public class FormatUtil {

    /**
     * 将 com.alibaba.da.coin.ide.spi.standard.TaskQuery 转为com.csii.webhook.model.pojo.TaskQuery
     *
     * @return taskQuery1
     */
    public static com.csii.webhook.model.pojo.TaskQuery toPojoTaskQuery(TaskQuery taskQuery) {
        com.csii.webhook.model.pojo.TaskQuery taskQuery1 = new com.csii.webhook.model.pojo.TaskQuery();
        if (StringUtils.isNotBlank(taskQuery.getSessionId())) {
            taskQuery1.setSessionId(taskQuery.getSessionId());
        }
        if (StringUtils.isNotBlank(taskQuery.getUtterance())) {
            taskQuery1.setUtterance(taskQuery.getUtterance());
        }
        if (taskQuery.getSkillId() != 0) {
            taskQuery1.setSkillId(taskQuery.getSkillId());
        }
        if (StringUtils.isNotBlank(taskQuery.getSkillName())) {
            taskQuery1.setSkillName(taskQuery.getSkillName());
        }
        if (StringUtils.isNotBlank(taskQuery.getToken())) {
            taskQuery1.setToken(taskQuery.getToken());
        }
        if (taskQuery.getIntentId() != 0) {
            taskQuery1.setIntentId(taskQuery.getIntentId());
        }
        if (StringUtils.isNotBlank(taskQuery.getIntentName())) {
            taskQuery1.setIntentName(taskQuery.getIntentName());
        }
        //Map集合不为空
        if (taskQuery.getRequestData().size() > 0) {
            taskQuery1.setRequestData(taskQuery.getRequestData());
        }
        /*
               在 com.alibaba.da.coin.ide.spi.standard.TaskQuery类下面三个属性要分别转 pojo里面类型
         *     private List<ConversationRecord> conversationRecords = null;
         *     private Map<String, SessionEntry> sessionEntries;
         *     List<SlotEntity> slotEntities = null;
         */
        // 属性引用是 com.alibaba.da.coin.ide.spi.meta.SlotEntity;所以要转类型
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        if (slotEntities.size() > 0) {
            List<com.csii.webhook.model.pojo.SlotEntity> slotEntities1 = new ArrayList<>();
            com.csii.webhook.model.pojo.SlotEntity slotEntity2 = new com.csii.webhook.model.pojo.SlotEntity();
            for (SlotEntity slotEntity : slotEntities) {
                slotEntity2 = toPojoSlotEntiy(slotEntity);
                slotEntities1.add(slotEntity2);
            }
            taskQuery1.setSlotEntities(slotEntities1);
        }

        //转换 private List<ConversationRecord> conversationRecords = null;
        List<ConversationRecord> conversationRecords = taskQuery.getConversationRecords();
        if (conversationRecords.size() > 0) {
            List<com.csii.webhook.model.pojo.ConversationRecord> conversationRecordList = new ArrayList<>();
            com.csii.webhook.model.pojo.ConversationRecord conversationRecord = new com.csii.webhook.model.pojo.ConversationRecord();
            for (ConversationRecord record : conversationRecords) {
                conversationRecord = toPojoConversationRecord(record);
                conversationRecordList.add(conversationRecord);
            }
            taskQuery1.setConversationRecords(conversationRecordList);
        }

        //转换 private Map<String, SessionEntry> sessionEntries
        Map<String, SessionEntry> sessionEntryMap = taskQuery.getSessionEntries();
        if (sessionEntryMap.size() > 0) {
            Map<String, com.csii.webhook.model.pojo.SessionEntry> sessionEntryMap1 = new HashMap<>();
            com.csii.webhook.model.pojo.SessionEntry sessionEntry = new com.csii.webhook.model.pojo.SessionEntry();
            for (Map.Entry<String, SessionEntry> entry : sessionEntryMap.entrySet()) {
                sessionEntry = toPojoSessionEntry(entry.getValue());
                sessionEntryMap1.put(entry.getKey(), sessionEntry);
            }
            taskQuery1.setSessionEntries(sessionEntryMap1);
        }
        if (taskQuery.getBotId() != 0) {
            taskQuery1.setBotId(taskQuery.getBotId());
        }
        if (taskQuery.getDomainId() != 0) {
            taskQuery1.setDomainId(taskQuery.getDomainId());
        }
        return taskQuery1;
    }

    /**
     * SlotEntity 类型转换
     * com.csii.webhook.model.pojo.SlotEntity 转换为  com.alibaba.da.coin.ide.spi.meta.SlotEntity;
     *
     * @return slotEntity1
     */
    public static com.csii.webhook.model.pojo.SlotEntity toPojoSlotEntiy(SlotEntity slotEntity) {
        com.csii.webhook.model.pojo.SlotEntity slotEntity1 = new com.csii.webhook.model.pojo.SlotEntity();
        if (slotEntity.getIntentParameterId() != 0) {
            slotEntity1.setIntentParameterId(slotEntity.getIntentParameterId());
        }
        if (StringUtils.isNotBlank(slotEntity.getIntentParameterName())) {
            slotEntity1.setIntentParameterName(slotEntity.getIntentParameterName());
        }
        if (StringUtils.isNotBlank(slotEntity.getOriginalValue())) {
            slotEntity1.setOriginalValue(slotEntity.getOriginalValue());
        }
        if (StringUtils.isNotBlank(slotEntity.getStandardValue())) {
            slotEntity1.setStandardValue(slotEntity.getStandardValue());
        }
        if (slotEntity.getLiveTime() != 0) {
            slotEntity1.setLiveTime(slotEntity.getLiveTime());
        }
        if (slotEntity.getCreateTimeStamp() != 0) {
            slotEntity1.setCreateTimeStamp(slotEntity.getCreateTimeStamp());
        }
        if (StringUtils.isNotBlank(slotEntity.getSlotName())) {
            slotEntity1.setSlotName(slotEntity.getSlotName());
        }
        if (StringUtils.isNotBlank(slotEntity.getSlotValue())) {
            slotEntity1.setSlotValue(slotEntity.getSlotValue());
        }
        return slotEntity1;
    }

    /**
     * ConversationRecord 类型转换
     * com.csii.webhook.model.pojo.ConversationRecord 转换为 com.alibaba.da.coin.ide.spi.meta.ConversationRecord;
     *
     * @return conversationRecord1
     */
    public static com.csii.webhook.model.pojo.ConversationRecord toPojoConversationRecord(ConversationRecord conversationRecord) {
        com.csii.webhook.model.pojo.ConversationRecord conversationRecord1 = new com.csii.webhook.model.pojo.ConversationRecord();
        if (conversationRecord.getBotId() != 0) {
            conversationRecord1.setBotId(conversationRecord.getBotId());
        }
        if (StringUtils.isNotBlank(conversationRecord.getUserInputUtterance())) {
            conversationRecord1.setUserInputUtterance(conversationRecord.getUserInputUtterance());
        }
        if (StringUtils.isNotBlank(conversationRecord.getReplyUtterance())) {
            conversationRecord1.setReplyUtterance(conversationRecord.getReplyUtterance());
        }
        if (conversationRecord.getIntentId() != 0) {
            conversationRecord1.setIntentId(conversationRecord.getIntentId());
        }
        if (StringUtils.isNotBlank(conversationRecord.getIntentName())) {
            conversationRecord1.setIntentName(conversationRecord.getIntentName());
        }
        if (conversationRecord.getTimestamp() != 0) {
            conversationRecord1.setTimestamp(conversationRecord.getTimestamp());
        }
        if (conversationRecord.getResultType() != null) {
            conversationRecord1.setResultType(conversationRecord.getResultType());
        }
        List<SlotEntity> slotEntities = conversationRecord.getSlotEntities();
        if (conversationRecord.getSlotEntities().size() > 0) {
            List<com.csii.webhook.model.pojo.SlotEntity> slotEntities1 = new ArrayList<>();
            com.csii.webhook.model.pojo.SlotEntity slotEntity2 = new com.csii.webhook.model.pojo.SlotEntity();
            for (SlotEntity slotEntity : slotEntities) {
                slotEntity2 = toPojoSlotEntiy(slotEntity);
                slotEntities1.add(slotEntity2);
            }
            conversationRecord1.setSlotEntities(slotEntities1);
        }
        return conversationRecord1;
    }

    /*     SessionEntry 格式转换
     *  private Map<String, SessionEntry> sessionEntries;
     *
     */
    public static com.csii.webhook.model.pojo.SessionEntry toPojoSessionEntry(SessionEntry sessionEntry) {
        com.csii.webhook.model.pojo.SessionEntry sessionEntry1 = new com.csii.webhook.model.pojo.SessionEntry();
        //sessionEntry.getTimeToLive()为空 默认值为0
        if (sessionEntry.getTimeToLive() != 0) {
            sessionEntry1.setTimeToLive(sessionEntry.getTimeToLive());
        }
        if (sessionEntry.getLiveTime() != 0) {
            sessionEntry1.setLiveTime(sessionEntry.getLiveTime());
        }
        if (sessionEntry.getTimeStamp() != 0) {
            sessionEntry1.setTimeStamp(sessionEntry.getTimeStamp());
        }
        //判断字符串不为空
        if (StringUtils.isNoneBlank(sessionEntry.getValue())) {
            sessionEntry1.setValue(sessionEntry.getValue());
        }
        return sessionEntry1;
    }
}
