package cn.edu.zime.bigdata2002.appdemo.controller;

import cn.edu.zime.bigdata2002.appdemo.dao.model.Doctor;
import cn.edu.zime.bigdata2002.appdemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;


@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("/adddoctor")
    public int insertDoctor(@RequestParam(value = "key1") String id,
                            @RequestParam(value = "key2") String name,
                            @RequestParam(value = "key3") String genda,
                            @RequestParam(value = "key4") String level,
                            @RequestParam(value = "key5") String depart,
                            @RequestParam(value = "key6") String ability){
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",id,name,genda,level,depart,ability);
        return doctorService.insert(new Doctor(id,name,genda,level,depart,ability));
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> selectAllDoctors(){
        System.out.println("-----select--------");
        return doctorService.selectAllDoctors();
    }

    @GetMapping("/getDoctors")
    public List<Doctor> selectDoctors(@RequestParam(value = "key1") String input){
        System.out.println("input:"+input);
        return doctorService.selectDoctors(input);
    }

    @GetMapping("/updateDoctor")
    public int updateDoctor(@RequestParam(value = "key1") String id,
                            @RequestParam(value = "key2") String name,
                            @RequestParam(value = "key3") String genda,
                            @RequestParam(value = "key4") String level,
                            @RequestParam(value = "key5") String depart,
                            @RequestParam(value = "key6") String ability){
        System.out.println("-----update--------");
        return doctorService.updateDoctor(new Doctor(id,name,genda,level,depart,ability));
    }

    @GetMapping("/deletedoctor")
    public int doctorDelete(@RequestParam(value = "key1") String id){
       System.out.println("---------delete---------");
       return doctorService.deleteDoctor(id);
    }













    /*
    @GetMapping("/doctorlist")
    public List<Doctor> selectAllDoctors(){
        return doctorService.selectAllDoctors();
    }
    @GetMapping("/updateDoctor")
    public int updateDoctor(@RequestParam(value = "key1") String id,
                            @RequestParam(value = "key2") String name,
                            @RequestParam(value = "key3") String genda,
                            @RequestParam(value = "key4") String level,
                            @RequestParam(value = "key5") String depart,
                            @RequestParam(value = "key6") String ability){
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n",id,name,genda,level,depart,ability);
        return doctorService.updateDoctor(new Doctor(id,name,genda,level,depart,ability));
    }
    @GetMapping("/deletedoctor")
    public int deleteDoctor(@RequestParam(value = "key1") String id){
        System.out.println("id:"+id);
        return doctorService.deleteDoctor(id);
    }
    @GetMapping("/doctorsearch")
    public List<Doctor> doctorDoctor(@RequestParam(value = "searchinfo") String searchinfo){
        return doctorService.selectDoctor(searchinfo);
    }
    */

}
