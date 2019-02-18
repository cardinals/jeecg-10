 $(document).ready(function(){
	 loadYearMonth();
	 loadNorth();
	 datagridCheck();
	 $("#sffy").blur(function(){
		 countMouseleave();
	 });
	 $("#jfny,#sfdx").change(function(){
		 wuyeSfglYsfyjlListsearch();//查询事件
	 });
 });
 var clicks=true;
//收费年月
function loadYearMonth(){
	jQuery.ajax({  
        async : true,  
        cache: false,  
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeSfglFysqglController.do?yearMonth', //请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(result){ //请求成功后处理函数
        	if(result.length>0){
        		for(var i=0;i<result.length;i++){
        		 	$("#jfny").append("<option>"+result[i]+"</option>");
        		}
        	}
        }  
    }); 	 
}
//异步获取
function loadNorth(){
	jQuery.ajax({
		cache:false,
		type:'POST',
		dataType : "json", 
		url: 'wuyeSfglFysqglController.do?loadNorth',
		error: function () {//请求失败处理函数  
	        alert('请求失败');  
	     },  
	    success:function(result){ //请求成功后处理函数。
	    	if(result){
	    		$("#fjbh").append(result.fjbh);
		    	$("#jzmj").append(result.jzmj);
		    	$("#yzmc").append(result.yzmc);
		    	$("#yzsj").append(result.yzsj);
		    	$("#jfrq").val(result.jfrq);
	    	}	    	
	    }  
	});
}
//easyui事件
function datagridCheck(){
	 $("#wuyeSfglYsfyjlList").datagrid({
		 onCheck:function(index,row){			
			 var a = $("#ysfy").val();
			 a=parseFloat(a)+parseFloat(row.ysje);
			 $("#ysfy").val(a.toFixed(2));
			 $("#sffy").val(a.toFixed(2));
			 countMouseleave();
		 },
		 onUncheck:function(index,row){
			 var a = $("#ysfy").val();
			 a=parseFloat(a)-parseFloat(row.ysje);
			 $("#ysfy").val(a.toFixed(2));
			 $("#sffy").val(a.toFixed(2));
			 countMouseleave();
		 },
		 onCheckAll:function(rows){
			 var a=0;			
			 if (rows.length > 0) {
				 for ( var i = 0; i < rows.length; i++) {
					 a=parseFloat(a)+parseFloat(rows[i].ysje);
					}
			 }
			 $("#ysfy").val(a.toFixed(2));
			 $("#sffy").val(a.toFixed(2));
			 countMouseleave();
		 },
		 onUncheckAll:function(rows){
			 $("#ysfy").val(parseFloat(0.00).toFixed(2));
			 $("#sffy").val(parseFloat(0.00).toFixed(2));
			 countMouseleave();
		 }, 
	 });			
}
//找零
function countMouseleave(){
		  var receipts = $("#sffy").val();		 
		  var receivable = $("#ysfy").val();
		  if(receipts){
			  $("#zl").val( (parseFloat(receipts)-parseFloat(receivable)).toFixed(2));
		  }else{		
			 $("#zl").val(""); 
		  }		
}
//收费
function charge(){
	var receivable =$("#ysfy").val();
	if(receivable==0){		
		parent.parent.layer.msg('请选择费用！',{time:3000});
		return;
	}
	var receipts =$("#sffy").val();
	if(!receipts){		
		parent.parent.layer.msg('实收费用不能为空！',{time:3000});
		return;
	}
	if(receipts.length>7){
		parent.parent.layer.msg('请输入正确的费用！',{time:3000});
		return;
	}
	var zl = $("#zl").val();
	if(zl<0){
		parent.parent.layer.msg('实收费用必须大于应收费用！',{time:3000});
		return;
	}
	var yearMonth = $("#jfny").val();
	if("--请选择--"==yearMonth){
		parent.parent.layer.msg('请选择交费年月！',{time:3000});
		return;
	}
	var chargeObject = $("#sfdx").val();
	if(!chargeObject){
		parent.parent.layer.msg('请选择收费对象！',{time:3000});
		return;
	}
	var sjh = $("#sjh").val();
	if(!sjh){
		parent.parent.layer.msg('请输入收据号！',{time:3000});
		return;
	}
	if(sjh.length>12){
		parent.parent.layer.msg('请输入正确的收据号！',{time:3000});
		return;
	}
	$("#sf").css("pointer-events","none");
	wuyeSfglPR();	
}

//post请求
function wuyeSfglPR(){
	var ids = getwuyeSfglYsfyjlListSelections("id");
	//console.log($("#wyform").serialize());
	//$("#wyform").serialize();
	params={
			'ysfy':$("#ysfy").val(),
			'sffy':$("#sffy").val(),
			'zl':$("#zl").val(),
			'jfrq':$("#jfrq").val(),
			'jfny':$("#jfny").val(),
			'sfdx':$("#sfdx").val(),
			'jffs':$("#jffs").val(),
			'kpfs':$("#kpfs").val(),
			'sjh':$("#sjh").val(),
			'fylx':$("#fylx").val(),
			'ids':ids.join(",")
	};
	url='wuyeSfglFysqglController.do?charge';
	$.post(url,params,function(result){
		wuyeSfglYsfyjlListsearch();//查询事件
		 if(result.success){
			parent.parent.layer.msg(result.msg+"是否打印？",{
				skin: 'layui-layer-molv',
				anim: 1,
				icon: 6,
				time: 0,
				btn: ['确定', '取消'],
				yes: function(index){
				    parent.parent.layer.close(index);
				    openwindow("打印","wuyeSfglFysqglController.do?lodop&id="+result.obj,"打印",'870px','550px');
				    $("#sf").css("pointer-events","auto");
				},
				btn2:function(index){
					 parent.parent.layer.close(index);
					 $("#sf").css("pointer-events","auto");
				}
			});			
		}else{
			parent.parent.layer.msg(result.msg,{
				skin: 'layui-layer-molv',
				anim: 1,
				icon: 7
			});
			$("#sf").css("pointer-events","auto");
		}
	},'json');
}