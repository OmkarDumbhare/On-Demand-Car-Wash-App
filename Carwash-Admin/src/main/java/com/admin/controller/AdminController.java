package com.admin.controller;
import com.admin.model.Customer;
import com.admin.model.WasherLeaderboard;
import com.admin.model.Washpacks;
import com.admin.service.AdminServiceImpl;
import com.admin.utilities.GlobalResources;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = GlobalResources.getLogger(AdminController.class);

    @PostMapping("/add-pack")
    public ResponseEntity<Washpacks> addNewPack(@RequestBody Washpacks washpacks) {

        String methodName = "(addNewPack)";

        try {
            logger.info(methodName + "Called");
            adminService.addNewWashPack(washpacks);
            return ResponseEntity.ok(washpacks);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Washpacks>> getAllPacks() {

        String methodName = "(getAllPacks)";
        try
        {
            logger.info(methodName + "Called");
            List<Washpacks> list = adminService.getAllPacks();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-pack/{name}")
    public ResponseEntity<Washpacks> getPack(@PathVariable String name) {
        String methodName = "(pack)";
        try{
            logger.info(methodName + "Called");
            Washpacks washpacks = adminService.findByName(name);
            return new ResponseEntity<Washpacks>(washpacks,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Washpacks> getPackById(@PathVariable("id") int id)
    {
        String methodName = "(getPackById)";

        try {
            logger.info(methodName + "Called");
            Washpacks washpacks = adminService.findById(id);
            return ResponseEntity.ok(washpacks);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update-pack")
    public ResponseEntity<Washpacks> updateWashPack(@RequestBody Washpacks washpacks)
    {
        String methodName = "(updateWashPack)";
        try {
            logger.info(methodName + "Called");
            return ResponseEntity.ok(this.adminService.updateWashPack(washpacks));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        this.adminService.deleteById(id);
    }

    @PostMapping("/leaderboard")
    public ResponseEntity<WasherLeaderboard> addToLeaderboard(@RequestBody WasherLeaderboard washerLeaderboard) {

        String methodName = "(addToLeaderboard)";

        try {
            logger.info(methodName + "Called");
            adminService.addNewWasherToLeaderboard(washerLeaderboard);
            return ResponseEntity.ok(washerLeaderboard);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-leaderboard")
    public ResponseEntity<List<WasherLeaderboard>> washerLeaderboard() {

        String methodName = "(washerLeaderboard)";

        try {
            logger.info(methodName + "Called");
            List<WasherLeaderboard> list = adminService.getWasherLeaderboard();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update-leaderboard")
    public WasherLeaderboard updateLeaderBoard(@RequestBody WasherLeaderboard washerLeaderboard)
    {
        adminService.updateLeaderboard(washerLeaderboard);
        return washerLeaderboard;
    }

    @GetMapping("getrank/{rank}")
    public ResponseEntity<WasherLeaderboard> getByRank(@PathVariable("rank") int rank)
    {
        String methodName = "(getByRank)";

        try {
            logger.info(methodName + "Called");
            WasherLeaderboard washerLeaderboard = adminService.getByRank(rank);
            return ResponseEntity.ok(washerLeaderboard);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        Customer[] customers = this.restTemplate.getForObject("http://localhost:9000/customer/get-all-customer",Customer[].class);
        return Arrays.asList(customers);
    }



}
