package cn.edu.zime.bigdata2002.appdemo.dao.mapper;

import cn.edu.zime.bigdata2002.appdemo.dao.model.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapperXML {
    public int insertDoctor(Doctor u);
    public List<Doctor> selectAllDoctors();
    public List<Doctor> selectDoctors(@Param("id") String id, @Param("name") String name);
    public int updateDoctor(Doctor doctor);
    public int deleteDoctor(String id);










    /*

    public int insertDoctor(Doctor doctor);
    public List<Doctor> selectAllDoctors();
    public List<Doctor> selectDoctors(@Param("id") String id, @Param("name") String name);

     */
}
