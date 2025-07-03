package com.study.seckill.service;

import com.study.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.seckill.vo.LoginVo;
import com.study.seckill.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【t_user】的数据库操作Service
* @createDate 2025-02-08 15:01:41
*/
@Service
public interface UserService extends IService<User> {

//    RespBean doLogin(LoginVo loginVo);

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
//    根据cookie获取用户
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
//更新密码
    RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response);
}
