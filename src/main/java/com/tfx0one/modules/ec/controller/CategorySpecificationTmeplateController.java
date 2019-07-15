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

import com.tfx0one.modules.ec.entity.CategorySpecificationTmeplateEntity;
import com.tfx0one.modules.ec.service.CategorySpecificationTmeplateService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品规格参数模板，json格式。
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@RestController
@RequestMapping("ec/categoryspecificationtmeplate")
public class CategorySpecificationTmeplateController {
    @Autowired
    private CategorySpecificationTmeplateService categorySpecificationTmeplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ec:categoryspecificationtmeplate:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = categorySpecificationTmeplateService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("ec:categoryspecificationtmeplate:info")
    public R info(@PathVariable("categoryId") Long categoryId){
		CategorySpecificationTmeplateEntity categorySpecificationTmeplate = categorySpecificationTmeplateService.getById(categoryId);

        return R.ok(categorySpecificationTmeplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ec:categoryspecificationtmeplate:save")
    public R save(@RequestBody CategorySpecificationTmeplateEntity categorySpecificationTmeplate){
		categorySpecificationTmeplateService.save(categorySpecificationTmeplate);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ec:categoryspecificationtmeplate:update")
    public R update(@RequestBody CategorySpecificationTmeplateEntity categorySpecificationTmeplate){
		categorySpecificationTmeplateService.updateById(categorySpecificationTmeplate);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ec:categoryspecificationtmeplate:delete")
    public R delete(@RequestBody Long[] categoryIds){
		categorySpecificationTmeplateService.removeByIds(Arrays.asList(categoryIds));

        return R.ok("删除成功！");
    }

}