package com.washer.controller;

import com.washer.model.Washer;
import com.washer.service.WasherServiceImpl;
import com.washer.utilities.GlobalResources;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/washer")
@CrossOrigin("*")
public class WasherController {

    @Autowired
    private WasherServiceImpl washerService;

    private Logger logger = GlobalResources.getLogger(WasherController.class);

    @PostMapping("/addWasher")
    public ResponseEntity<Washer> addWashers(@RequestBody Washer washer)
    {
        String methodName = "(addWashers)";
        try
        {
            logger.info(methodName + "Called");
            washerService.addWashers(washer);
            return ResponseEntity.ok(washer);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @GetMapping("/get-washer/{name}")
    public ResponseEntity<Washer> getWasherById(@PathVariable("name") String name)
    {
        String methodName = "(getWasherById)";
        try
        {
            logger.info(methodName + "Called");
            Washer washer = washerService.findByName(name);
            return new ResponseEntity<Washer>(washer,HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @GetMapping("/getAllWasher")
    public ResponseEntity<List<Washer>> getAllWashers()
    {
        String methodName = "(getAllWashers)";
        try
        {
            logger.info(methodName + "Called");
            List<Washer> list = washerService.getAllWashers();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @PutMapping("/updateWasher")
    public ResponseEntity<Washer> updateWasher(@RequestBody Washer washer)
    {
        String methodName = "(updateWasher)";
        try
        {
            logger.info(methodName + "Called");
            return ResponseEntity.ok(this.washerService.updateWasher(washer));
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

}
