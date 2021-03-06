package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.Query;

import com.tfx0one.modules.ec.dao.BrandDao;
import com.tfx0one.modules.ec.entity.BrandEntity;
import com.tfx0one.modules.ec.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public Pagination<BrandEntity> queryPage(Map<String, Object> params, BrandEntity brand) {
        IPage<BrandEntity> page = this.page(
                Query.page(params),
                Wrappers.<BrandEntity>lambdaQuery()
        );

        return Pagination.create(page);
    }

}