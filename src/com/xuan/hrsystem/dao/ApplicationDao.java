package com.xuan.hrsystem.dao;

import com.xuan.hrsystem.model.Application;
import com.xuan.hrsystem.model.Employee;

import java.util.List;

/**
 * Created by xuan on 2017/3/4 0004.
 */
public interface ApplicationDao {
    /**
     * 根据id属性来加载Application实例
     * @param id 标识属性
     * @return 指定标识属性的Application实例
     */
    Application get(Integer id);

    /**
     * 保存指定的Application实例
     * @param application
     * @return 被持久化的application的id标识符
     */
    Integer save(Application application);

    /**
     * 修改指定的Application实例
     * @param application
     */
    void update(Application application);
    void delete(Application application);
    void delete(Integer id);
    List<Application> findAll();

    /**
     * 查询该员工未处理的异动申请
     * @param employee
     * @return
     */
    List<Application> findByEmp(Employee employee);
}
