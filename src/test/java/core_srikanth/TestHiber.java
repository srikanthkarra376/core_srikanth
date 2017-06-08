package core_srikanth;

import java.util.List;
import static org.junit.Assert.assertEquals;
import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import fr.epita.srikanth.Services;
import fr.epita.srikanth.Services.Dao;
import fr.epit.srikanth.model.Address;
import fr.epita.srikanth.model.Student;

public class TestHiber {
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations={"/applicationContext.xml"})
	//@RunWith(SpringJUnit4ClassRunner.class)
	//@ContextConfiguration(locations={"/applicationContext.xml"})
	public class TestHiber {
		//@Inject
		//Hiberdao dao;
		
		//@Inject
		//AddressDao daoA;
		@Inject
		Dao <Student>dao;
		@Inject
		Dao <Address>daoA;
		@Test
		public void testhiber(){
			Address address=new Address(101,"paris","villijuif");
			
			Student student=new Student("srikanth","gmail",123,address);
			
			
			//inserting in address table
			daoA.write(address);
			
			
			//Insert testing
			dao.write(student);
			List<Student>l=dao.listall(student);
			//List<Address>lad=daoA.listall();
			Address ad=l.get(0).getAddress();
			System.out.println(ad.getId());
			Assert.assertFalse(l.isEmpty());
			
			
			
			//update testing
		    student.setName("karra");
		    dao.update(student);
		    List<Student>la=dao.listall(student);
		    String name=la.get(0).getName();
		   
		    assertEquals(name,"karra");
			
			//delete testing
			dao.delete(student);
			
			List<Student>lao=dao.listall(student);
			Assert.assertTrue(lao.isEmpty());
			
			
		}
	}


}
