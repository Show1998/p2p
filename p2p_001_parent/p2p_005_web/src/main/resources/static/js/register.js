//错误提示
function showError(id,msg) {
	$("#"+id+"Ok").hide();
	$("#"+id+"Err").html("<i></i><p>"+msg+"</p>");
	$("#"+id+"Err").show();
	$("#"+id).addClass("input-red");
}
//错误隐藏
function hideError(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id).removeClass("input-red");
}
//显示成功
function showSuccess(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id+"Ok").show();
	$("#"+id).removeClass("input-red");
}


//打开注册协议弹层
function alertBox(maskid,bosid){
	$("#"+maskid).show();
	$("#"+bosid).show();
}
//关闭注册协议弹层
function closeBox(maskid,bosid){
	$("#"+maskid).hide();
	$("#"+bosid).hide();
}

//注册协议确认
$(function() {
	$("#agree").click(function(){
		var ischeck = document.getElementById("agree").checked;
		if (ischeck) {
			$("#btnRegist").attr("disabled", false);
			$("#btnRegist").removeClass("fail");
		} else {
			$("#btnRegist").attr("disabled","disabled");
			$("#btnRegist").addClass("fail");
		}
	});
	$("#phone").blur(function () {
		var phone = $.trim($("#phone").val());
		if(phone == ''){
			showError("phone","请输入手机号")
		}else if(!/^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\d{8}$/.test(phone)){
			showError("phone","请输入正确的手机号！");
		}else {
			//查询数据库，手机号是否可用
			$.ajax({
				url:"/p2p/loan/checkPhone",
				type:"get",
				data:{"phone":phone},
				success:function (data){
					if(data.result == 1){
						showSuccess("phone")
					}else showError("phone","此手机号已经注册！请直接登录！")
				},
				error:function () {
					showError("phone","系统繁忙，请稍后重试！")
				}
			})
			showSuccess("phone");
		}
	})
	$("#phone").focus(function () {
		hideError("phone")
	})
});
