/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tfx0one.common.validator;

import com.tfx0one.common.exception.CommonException;
import org.apache.commons.lang3.StringUtils;


public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CommonException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new CommonException(message);
        }
    }
}