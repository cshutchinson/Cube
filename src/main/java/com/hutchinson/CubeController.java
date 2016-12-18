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

    @RequestMapping(value = "/rotate", method = RequestMethod.POST, consumes="application/json",produces="application/json")
    @ResponseBody
    public Cube rotate(@RequestBody CubeRequest cubeRequest) {
        Cube cube = cubeRequest.getCube();
        String face = cubeRequest.getFace();
        String direction = cubeRequest.getDirection();

        return cubeService.rotate(cube, face, direction);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public  String test(){
        return "hello";
    }

}
