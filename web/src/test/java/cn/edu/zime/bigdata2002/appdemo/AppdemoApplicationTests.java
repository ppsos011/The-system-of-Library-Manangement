package cn.edu.zime.bigdata2002.appdemo;

import cn.edu.zime.bigdata2002.appdemo.dao.mapper.DoctorMapper;
import cn.edu.zime.bigdata2002.appdemo.dao.model.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppdemoApplicationTests {
	@Autowired
	DoctorMapper doctorMapper;
	@Test        //标注该方法为单元测试方法
	public void test(){
		int result=doctorMapper.insertDoctor(new Doctor("11","zhangsan","男","主任医生","111","111"));
	}


}
