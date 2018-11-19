package com.dchealth.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class BaseService<T,ID,R extends PagingAndSortingRepository<T,ID>> {

    @Autowired
    public R repository ;


    @Transactional
    public T addNewObject(T t){
        T save = repository.save(t);
        return save;
    }

    /**
     * 是否存在
     * @param id
     * @return
     */
    public boolean exist(ID id){
        return repository.existsById(id);
    }


    /**
     * 根据Id获取
     * @param id
     * @return
     */
    public T getObjectById(ID id ){
        Optional<T> byId = repository.findById(id);
        return byId.get();
    }

    /**
     * 获取所有
     * @return
     */
    public Iterable<T> findAll(){
        return repository.findAll();
    }

    /**
     * 获取分页额信息
     * @param pageable
     * @return
     */
    public Page<T> findAllByPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    /**
     * 删除对象
     * @param t
     */
    @Transactional
    public void remove(T t){
        repository.delete(t);
    }

    /**
     * 根据ID删除
     * @param id
     */
    @Transactional
    public void removeById(ID id){
        repository.deleteById(id);
    }


    /**
     * 修改信息
     * @param t
     * @return
     */
    @Transactional
    public T update(T t){
        return repository.save(t);
    }


    @Transactional
    public  Iterable<T> saveAll(Iterable<T> t){
        Iterable<T> ts = repository.saveAll(t);
        return ts;
    }

    /**
     * 删除制定的所有对象
     * @param ts
     */
    @Transactional
    public void deleteObjects(Iterable<T> ts){
        repository.deleteAll(ts);
    }

    /**
     * 清空表
     */
    @Transactional
    public  void emptyObjects(){
        repository.deleteAll();
    }


}
