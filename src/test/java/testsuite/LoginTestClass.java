package testsuite;

import java.util.List;

import dataBase.GetExcel;
import util.TestUtil;

public class LoginTestClass {

	public void loginTest() throws Exception{
		  GetExcel excel=new GetExcel();
		  List<String> userPassword=excel.get_user_Pass();
		  for (int i = 0; i < userPassword.size(); i++) 
		  {
			  TestUtil util=new TestUtil();
			  util.doLogin(userPassword.get(i).split(":")[0],userPassword.get(i).split(":")[1]);
		  }
		  
	}

}
