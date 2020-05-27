package com.etoak.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Car {
	
	
	private Integer id;
	
	@NotNull(message="brand不能为空")
	@NotEmpty(message="brand不能为空")
	private String brand;
	
	//车系
	@NotNull(message="车系不能为空")
	@NotEmpty(message="车系不能为空")
	private String series;
	
	//价格
	@NotNull(message="价格不能为空")
	@Min(value = 1,message="价格最小为1")
	@Max(value = 100,message="价格最大为100")
	private Integer price;
	//上牌时间
	private String licensingTime;
	//级别
	private String level;
	//变速箱
	private String gearbox;
	//排量
	private String outputVolume;
	//里程
	private Integer mileage;
	//归属地
	private String location;
	//图片
	private String pic;
	//概述
	@Size(min = 6,max = 12,message="概述只能在6-12字符之间")
	private String summary;
	//创建时间
	private String createTime;
	
}
