package com.dchealth.service;

import com.dchealth.entity.WxUser;
import com.dchealth.repository.WxUserRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class WxUserService extends BaseService<WxUser,String,WxUserRepo> {

}
