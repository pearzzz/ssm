package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:04 2022/1/11
 */
public interface EmployeeMapper {

    /**
     * TODO 根据id返回员工信息
     * @param id 员工id
     * @return: com.pearz.mybatis.bean.Employee
    */
    public Employee getEmpById(int id);

    public boolean addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public boolean deleteEmpById(int id);

    public Employee getEmpByIdAndLastName(@Param("id") int id, @Param("lastName") String lastName);

    public Employee getEmpByMap(Map<String, Object> map);

    public List<Employee> getEmpByLastName(String lastName);

    public Map<String, Object> getEmpByIdReturnMap(int id);

    @MapKey("id")
    public Map<Integer, Object> getEmpByLastNameReturnMap(String lastName);
}
