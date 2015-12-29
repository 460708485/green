<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>省市县3级联动</title>
<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function(){
		$(".province").append("<option value='0'>请选择</option>");	
		$(".city").append("<option  value='0'>请选择</option>");
		$(".county").append("<option  value='0'>请选择</option>");	
		
		//此页面加载，查询出所有的省份
		$.post("getProvinces.do",null,function(data){
			//var pro=eval("("+data+")"); 
			//alert(pro)
			//循环加载所有的省 （方法一）
			//for(var i=0;i<pro.length;i++){
				// $(".province").append("<option value="+pro[i].shengid+">"+pro[i].shengname+"</option>");
				
			//}
			
			//循环加载所有的省（方法二）
			$.each(data,function(index,value){
			 $(".province").append("<option value="+value.provinceId+">" + value.provinceName+"</option>");
			});
		});
		
		//省的变化引起城市的变化
		$(".province").change(function(){
			var pid=this.value;//得到省的id
			if(pid!=0){//如果你没有选择省，就不执行下面的操作
				$.post("getCities.do",{provinceId:pid},function(data){
					//var city=eval("("+data+")");
					$(".city option[value!=0]").remove();//清空城市下拉框数据，如果不写，数据会叠加
					$.each(data, function(index, value){
						$(".city").append("<option value="+value.cityId+">"+value.cityName+"</option>");	
					});
				});
			}
		});
		
	
		//城市的变化引起  (市/区) 的变化
		$(".city").change(function(){
			var cid=this.value;//得到市的id
			if(cid!=0){//如果你没有选择市，就不执行下面的操作
				$.post("getCounties.do",{cityId:cid},function(data){
					//var county=eval("("+data+")");
					$(".county option[value!=0]").remove();//清空县下拉框数据，如果不写，数据会叠加
					$.each(data, function(index, value){
						$(".county").append("<option value="+value.countyId+">"+value.countyName+"</option>");
					});
				});
			}
		});
	
	});
	
</script>
</head>
<body>
省：<select class="province"></select>&nbsp;&nbsp;
市：<select class="city"></select>&nbsp;&nbsp;&nbsp;
区/县<select class="county"></select>&nbsp;

</body>
</html>
