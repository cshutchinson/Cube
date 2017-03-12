package com.hutchinson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CubeController {

    @Autowired
    private CubeService cubeService;

    @RequestMapping("/")
    public Cube index() {
        return new Cube();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/rotate", method = RequestMethod.POST, consumes="application/json",produces="application/json")
    @ResponseBody
    public Cube rotate(@RequestBody CubeRequest cubeRequest) {
        Cube cube = cubeRequest.getCube();
        String face = cubeRequest.getFace();
        String direction = cubeRequest.getDirection();

        return cubeService.rotate(cube, face, direction);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public  String test(){
        return "hello";
    }

}
