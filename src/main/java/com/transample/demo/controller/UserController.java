package com.transample.demo.controller;

import com.transample.demo.common.ResponseResult;
import com.transample.demo.domain.TaoMurakami;
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoMurakamiService;
import com.transample.demo.service.ITaoSellerService;
import com.transample.demo.service.ITaoVillagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关API")
public class UserController {

    @Autowired
    private ITaoVillagerService taoVillagerService;

    @Autowired
    private ITaoMurakamiService taoMurakamiService;

    @Autowired
    private ITaoSellerService taoSellerService;

    @PostMapping("/login/villager")
    @ApiOperation("村民登陆")
    public ResponseEntity<ResponseResult> villagerLogin(@RequestBody TaoVillager villager) {
       return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.login(villager)));
    }

    @PostMapping("/login/murakami")
    @ApiOperation("村小二登陆")
    public ResponseEntity<ResponseResult> murakamiLogin(@RequestBody TaoMurakami murakami) {
        return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.login(murakami)));
    }

    @PostMapping("/login/seller")
    @ApiOperation("商家登陆")
    public ResponseEntity<ResponseResult> sellerLogin(@RequestBody TaoSeller seller) {
        return ResponseEntity.ok(ResponseResult.ok(taoSellerService.login(seller)));
    }

}
