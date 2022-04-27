package com.admin;

import com.admin.model.Washpacks;
import com.admin.service.AdminServiceImpl;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
class CarwashManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	@MockBean
	private AdminServiceImpl adminService;

	@Test
	public void addWashpacks(){

		Washpacks washpacks = new Washpacks(1,"Premium",23000,"For premium cars");
		when(adminService.addNewWashPack(washpacks)).thenReturn(washpacks);
		assertEquals(washpacks,adminService.addNewWashPack(washpacks));
	}

	@Test
	public void getPack(){

		Washpacks washpacks = new Washpacks(1,"Premium",23000,"For premium cars");
		when(adminService.findByName("Deluxe")).thenReturn(washpacks);

	}

	@Test
	void washerLeaderboard() {
		when(adminService.getWasherLeaderboard()).thenReturn(new ArrayList<>());
	}




}
