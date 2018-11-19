package com.dchealth.controller.base;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import com.dchealth.service.base.BaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@PriResource(resourceName = "",resourceCode = "")
public class BaseController<T,ID,S extends BaseService> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String objectName ;
    private String objectCode ;
    public BaseController(String objectName){
        this.objectName = objectName;
    }

    public String getObjectName(){
        return this.objectName;
    }

    public String getObjectCode(){
        return getClass().getName();
    }


    @Autowired
    private S service ;

    public S getService(){
        return service ;
    }


    /**
     * 根据ID 获取具体的
     * @param id
     * @return
     */
    @ApiOperation(value="根据ID获取唯一的对象信息",notes = "id为必转字段请务必填写")
    @ApiImplicitParam(name = "id",required = true)
    @GetMapping(path = "/{id}")
    @PriOperation(operationName = "获取单一",operationCode = "read:single")
    @PreAuthorize("hasPermission('','read:single')")
    public T getObject(@PathVariable("id") ID id){
        logger.info("创建"+this.objectName+"对象");
        return (T) service.getObjectById(id);
    }

    /**
     * 获取所有的
     * @return
     */
    @ApiOperation(value = "获取所有对象")
    @GetMapping("find-all")
    @PriOperation(operationName = "获取所有",operationCode = "read:all")
    @PreAuthorize("hasPermission('','read:all')")
    public Iterable<T>  findAllObjects(){
        logger.info("获取所有的"+objectName+"信息");
        Iterable all = service.findAll();
        return all;
    }

    /**
     * 分页获取
     * @param pageable
     * @return
     */
    @ApiOperation(value = "获取对象的分页信息",notes = "传入pageNumber,pageSize改写默认值")
    @GetMapping("find-all-by-page")
    @PriOperation(operationCode = "read:all",operationName = "获取所有")
    @PreAuthorize("hasPermission('','read:all')")
    public Page<T> findAllByPage(@PageableDefault Pageable pageable){
        return service.findAllByPage(pageable);
    }


    @ApiOperation(value = "创建信息的对象")
    @PostMapping
    @PriOperation(operationName = "创建",operationCode = "create:single")
    @PreAuthorize("hasPermission('','create:single')")
    public T createNewObj(@Valid @RequestBody T t, BindingResult bindingResult){
        return (T) service.addNewObject(t);
    }

    @ApiOperation(value="修改对象信息")
    @PutMapping
    @PriOperation(operationName = "更新",operationCode = "update:single")
    @PreAuthorize("hasPermission('','update:single')")
    public T updateObject(@Valid @RequestBody T t, BindingResult bindingResult){
        return (T) service.update(t);
    }


    @ApiOperation(value="保存所有")
    @PostMapping("/save-all")
    @ApiImplicitParam(name = "ts",value = "对象数组信息",required = true)
    @PriOperation(operationName = "保存所有",operationCode = "save:all")
    @PreAuthorize("hasPermission('','save:all')")
    public Iterable<T> createNewObjs(@Valid @RequestBody Iterable<T> ts, BindingResult bindingResult){
        return service.saveAll(ts);
    }


    @ApiOperation(value = "根据ID删除对象")
    @DeleteMapping(path = "/{id}")
    @ApiImplicitParam(name = "id",value = "需要删除对象的标识符")
    @PriOperation(operationName = "删除单一",operationCode = "delete:single")
    @PreAuthorize("hasPermission('','delete:single')")
    public void deleteObjectById(@PathVariable("id") ID id){
         service.removeById(id);
    }

    @ApiOperation(value = "根据ID删除对象")
    @DeleteMapping
    @ApiImplicitParam(name = "t",value = "需要删除的对象")
    @PriOperation(operationName = "删除单一",operationCode = "delete:single")
    @PreAuthorize("hasPermission('','delete:single')")
    public void deleteObjects(@Valid @RequestBody T t, BindingResult bindingResult){
        service.remove(t);
    }


    @ApiOperation(value = "删除制定的对象信息")
    @DeleteMapping(path = "/delete-all")
    @ApiImplicitParam(name = "ts",value = "需要删除的对象")
    @PriOperation(operationName = "删除所有",operationCode = "delete:all")
    @PreAuthorize("hasPermission('','delete:all')")
    public void deleteAll(@Valid @RequestBody Iterable<T> ts, BindingResult bindingResult){
        service.deleteObjects(ts);
    }

    @ApiOperation(value = "清空所有的对象信息")
    @DeleteMapping(path = "/empty-all")
    @ApiImplicitParam(name = "ts",value = "需要删除的对象")
    @PriOperation(operationName = "删除所有",operationCode = "delete:all")
    @PreAuthorize("hasPermission('','delete:all')")
    public void emptyAll(@Valid @RequestBody Iterable<T> ts, BindingResult bindingResult){
        service.emptyObjects();
    }

}
