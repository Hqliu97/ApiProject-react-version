package com.hanq.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanq.hanqcommon.model.entity.UserInterfaceInfo;
import com.hanq.project.common.ErrorCode;
import com.hanq.project.exception.BusinessException;
import com.hanq.project.exception.ThrowUtils;
import com.hanq.project.mapper.UserInterfaceInfoMapper;
import com.hanq.project.service.UserInterfaceInfoService;
import com.hanq.project.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.Liu
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Resource
    private UserService userService;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        // 创建时，所有参数必须非空
        if (add) {
            if (userId < 0 || interfaceInfoId < 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
    }

    @Override
    public Long addUserInterfaceInfoLogic(UserInterfaceInfo userInterfaceInfo,Long userId) {
        validUserInterfaceInfo(userInterfaceInfo, true);
        userInterfaceInfo.setUserId(userId);
        boolean result = this.save(userInterfaceInfo);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return userInterfaceInfo.getId();
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if(interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId).eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum-1, totalNum = totalNum + 1");
        updateWrapper.gt("leftNum", 0);
        return this.update(updateWrapper);
    }
}




