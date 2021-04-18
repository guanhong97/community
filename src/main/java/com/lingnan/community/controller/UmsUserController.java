package com.lingnan.community.controller;

import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.dto.LoginDTO;
import com.lingnan.community.model.dto.RegisterDTO;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.service.IBmsTipService;
import com.lingnan.community.service.IUmsUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.lingnan.community.jwt.JwtUtil.USER_NAME;

/**
 * @program: community
 * @description: 公告栏控制层
 * @author: Mario
 * @create: 2021-04-13 21:19
 **/

@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController {

    @Resource
    private IUmsUserService umsUserService;

    @PostMapping("/register")
    public ApiResult<Map<String,Object>> register(@Valid @RequestBody RegisterDTO dto){
        UmsUser user = umsUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user))
            return ApiResult.failed("账号注册失败");
        Map<String,Object> map = new HashMap<>(16);
        map.put("user",user);
        return ApiResult.success(map);
    }

    @PostMapping("/login")
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto){
        String token = umsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<UmsUser> getUser(@RequestHeader(value = USER_NAME) String userName) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        return ApiResult.success(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> Logout() {
        return ApiResult.success(null,"注销成功");
    }
}
