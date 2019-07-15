package com.tfx0one.modules.ec.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfx0one.modules.ec.entity.SpuEntity;
import com.tfx0one.modules.ec.service.SpuService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * spu表，该表描述的是一个抽象性的商品，比如 iphone8
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@RestController
@RequestMapping("ec/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ec:spu:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = spuService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ec:spu:info")
    public R info(@PathVariable("id") Long id){
		SpuEntity spu = spuService.getById(id);

        return R.ok(spu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ec:spu:save")
    public R save(@RequestBody SpuEntity spu){
		spuService.save(spu);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ec:spu:update")
    public R update(@RequestBody SpuEntity spu){
		spuService.updateById(spu);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ec:spu:delete")
    public R delete(@RequestBody Long[] ids){
		spuService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}