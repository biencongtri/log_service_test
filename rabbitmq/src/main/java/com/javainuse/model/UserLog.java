package com.javainuse.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@Builder
public class UserLog {

    String id;
    String tableName;
    ActionCurd actionCurd;
    String ipAddress;
    String objectId;
    String objectDataOld;
    String objectDataNew;
    LocalDateTime modified;
    String modifiedBy;
    String modifiedByInstanceId;

}
