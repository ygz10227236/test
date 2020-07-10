package com.briup.bean;
/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月5日 上午11:22:24 
* 类说明 
*/
public class CustomerContribution {
	private String name;
	private Float y;
	private String drilldown;
	public CustomerContribution(String name, Float y, String drilldown) {
		super();
		this.name = name;
		this.y = y;
		this.drilldown = drilldown;
	}
	public CustomerContribution() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
	}
	public String getDrilldown() {
		return drilldown;
	}
	public void setDrilldown(String drilldown) {
		this.drilldown = drilldown;
	}
	@Override
	public String toString() {
		return "CustomerContribution [name=" + name + ", y=" + y + ", drilldown=" + drilldown + "]";
	}
}
