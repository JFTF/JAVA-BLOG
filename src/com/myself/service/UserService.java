package com.myself.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;

import com.myself.model.user.UserInfo;

public interface UserService {
   public String firm(UserInfo userInfo,HttpServletRequest request,String firmCode);
   public String register(UserInfo userInfo);
   public BufferedImage getRandomImage(HttpServletRequest request);
}
