package com.zoe.java.ai.langchain4j.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zoe.java.ai.langchain4j.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    //IService中有一些预定义的方法可以直接使用
    Appointment getOne(Appointment appointment);
}