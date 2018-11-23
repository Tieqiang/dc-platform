package com.dchealth.repository;

import com.dchealth.entity.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepo extends PagingAndSortingRepository<Resource, String> {
    /**
     * 根据sysFlag获取所有的Resource
     * @param sysFlag
     * @return
     */
    List<Resource> findAllBySysFlag(String sysFlag);

    /**
     * 根据sysFlag删除Resource
     * @param sysFlag
     */
    int deleteAllBySysFlag(String sysFlag);

    /**
     *
     * @param resourceName  资源名称
     * @param operationCode 操作代码
     * @param operationName 操作名称
     * @param sysFlag       系统标志
     * @return
     */
    List<Resource> findAllByResourceNameAndOperationCodeAndOperationNameAndSysFlag(String resourceName,String operationCode,String operationName,String sysFlag);

    /**
     * 是否存在相同的资源
     * @param resourceName  资源名称
     * @param operationCode 操作代码
     * @param operationName 操作名称
     * @param sysFlag       系统标志
     * @return
     */
    boolean existsResourceByResourceNameAndOperationCodeAndOperationNameAndSysFlag(String resourceName,String operationCode,String operationName,String sysFlag);

    /**
     * 根据OperaitonCode获取Resource
     * @param operationCode
     * @return
     */
    Resource findResourceByOperationCode(String operationCode);

}
