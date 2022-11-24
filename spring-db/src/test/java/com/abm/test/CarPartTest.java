package com.abm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abm.component.CarPart;
import com.abm.component.CarPartInventory;

public class CarPartTest {

	@Test
	public void test_adding_CarPart() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		CarPartInventory cpInv = (CarPartInventory) ctx.getBean("carPartInv3");
		
		CarPart cp = new CarPart();
		
		cp.setPartName("Seat cover");
		cp.setCarModel("BMW");
		cp.setPrice(50);
		cp.setQuantity(25);
		
		cpInv.addNewPart(cp);
	}
	
	@Test
	public void test_fetching_CarPart() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		CarPartInventory cpInv =(CarPartInventory) ctx.getBean("carPartInv3");
		
		List<CarPart> list = cpInv.getAvailableParts();
		
		
		for (CarPart cp : list) {
			System.out.println("Part no. : " + cp.getPartNo());
			System.out.println("Part name. : " + cp.getPartName());
			System.out.println("Car model : " + cp.getCarModel());
			System.out.println("Price : " + cp.getPrice());
			System.out.println("Quantity : " + cp.getQuantity());
			System.out.println("---------------");
        }
	}

}
