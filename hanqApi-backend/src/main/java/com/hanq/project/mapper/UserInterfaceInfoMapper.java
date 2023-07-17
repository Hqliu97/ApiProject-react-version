package com.hanq.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanq.hanqcommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author Mr.Liu
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int i);
}




