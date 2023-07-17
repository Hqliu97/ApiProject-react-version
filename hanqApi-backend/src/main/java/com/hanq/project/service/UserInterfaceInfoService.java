package com.hanq.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanq.hanqcommon.model.entity.UserInterfaceInfo;


/**
* @author Mr.Liu
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);

    Long addUserInterfaceInfoLogic(UserInterfaceInfo userInterfaceInfo,Long userId);

    boolean invokeCount(long interfaceInfoId,long userId);
}
