package cn.edu.zime.bigdata2002.appdemo.dao.mapper;

import cn.edu.zime.bigdata2002.appdemo.dao.model.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {

    @Insert("insert into doctors values(#{id},#{name},#{genda},#{level},#{depart}, #{ability})")
    public int insertDoctor(Doctor u);

    @Select("select * from doctors")
    public List<Doctor> selectAllDoctors();

    @Select("select * from doctors where id=#{id} or name=#{name}")
    public List<Doctor> selectDoctors(String id, String name);

    @Update("update doctors set name=#{name}, genda=#{genda}, level=#{level}, depart=#{depart}, ability=#{ability} where id=#{id}")
    public int updateDoctor(Doctor doctor);

    @Delete("delete from doctors where id = #{id}")
    public int deleteDoctor(String id);






















/*
    @Select("select * from doctors")
    public List<Doctor> selectAllDoctors();

    @Update("update doctors set name=#{name}, genda=#{genda}, level=#{level}, depart=#{depart},ability=#{ability} where id=#{id}")
    public int updateDoctor(Doctor u);

    @Delete("delete from doctors where id=#{id}")
    public int deleteDoctor(String id);

    @Select("select * from doctors where id=#{id} or name=#{name}")
    public List<Doctor> selectDoctor(String id, String name);

 */
}
