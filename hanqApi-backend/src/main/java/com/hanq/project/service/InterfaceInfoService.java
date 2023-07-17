package com.hanq.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanq.hanqcommon.model.entity.InterfaceInfo;

/**
* @author Mr.Liu
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
