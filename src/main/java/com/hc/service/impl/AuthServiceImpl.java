package com.hc.service.impl;

import com.hc.domain.Admin;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.mapper.AuthMapper;
import com.hc.domain.Auth;
import com.hc.service.AuthService;
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthService{


}
