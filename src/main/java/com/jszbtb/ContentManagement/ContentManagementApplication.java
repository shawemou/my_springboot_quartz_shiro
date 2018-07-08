package com.jszbtb.ContentManagement;

import org.quartz.CronTrigger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import tk.mybatis.spring.annotation.MapperScan;

import com.jszbtb.ContentManagement.job.QuarzJob;


@SpringBootApplication
@MapperScan(basePackages = "com.jszbtb.ContentManagement.mapper")
public class ContentManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContentManagementApplication.class, args);
	}
	
	@Bean
	public QuarzJob getJob(){
		return new QuarzJob();
	}
	
	@Bean
	public MethodInvokingJobDetailFactoryBean getFactoryBean(){
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetObject(getJob());
		bean.setTargetMethod("myJob");
		return bean;
	}
	
	@Bean
	public CronTriggerFactoryBean getcf(){
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(getFactoryBean().getObject());
		bean.setCronExpression("0/10000 * * * * ?");
		return bean;
	}
	
	@Bean
	public SchedulerFactoryBean getb(){
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		CronTrigger[] list = {getcf().getObject()};
		bean.setTriggers(list);
		return bean;
	}
}
