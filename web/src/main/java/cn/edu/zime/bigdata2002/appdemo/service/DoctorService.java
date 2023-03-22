package cn.edu.zime.bigdata2002.appdemo.service;

import cn.edu.zime.bigdata2002.appdemo.annotations.Audit;
import cn.edu.zime.bigdata2002.appdemo.dao.mapper.DoctorMapper;
import cn.edu.zime.bigdata2002.appdemo.dao.mapper.DoctorMapperXML;
import cn.edu.zime.bigdata2002.appdemo.dao.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    //DoctorMapper doctorMapper;
    DoctorMapperXML doctorMapper;

    public int insert(Doctor doctor){
        return doctorMapper.insertDoctor(doctor);
    }

    public List<Doctor> selectAllDoctors(){
        return doctorMapper.selectAllDoctors();
    }

    public List<Doctor> selectDoctors(String input){
        return doctorMapper.selectDoctors(input,input);
    }

    public int updateDoctor(Doctor doctor){
        return doctorMapper.updateDoctor(doctor);
    }

    public int deleteDoctor(String id){
        return doctorMapper.deleteDoctor(id);
    }
























    /*
    public List<Doctor> selectAllDoctors(){
        return doctorMapper.selectAllDoctors();
    }
    public int updateDoctor(Doctor doctor){
        return doctorMapper.updateDoctor(doctor);
    }
    public int deleteDoctor(String id){
        return doctorMapper.deleteDoctor(id);
    }
    public List<Doctor> selectDoctor(String searchinfo){
        return doctorMapper.selectDoctor(searchinfo,searchinfo);
    }

     */
}
