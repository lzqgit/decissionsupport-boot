/**
 * 功能：用于完善用户信息和同步单点登录信息
 */
$(document).ready(function() {
	//用户名
	var $userNameSpan = $('.indexNavigation').children('span').eq(1);
	//下拉图标
	var $menuSelect = $('.indexNavigation').children('span').children('img');
	//下拉图标div
	var $menuDiv = $('.indexMenuSelect');
		
	//设置导航大厅链接
	var $navigationA = $('.indexNavigation').children('a');
	$navigationA.attr("href", "https://nav.asoco.com.cn");
	
	//下拉框图标
	$menuSelect.click(function(){
		if($menuDiv.css('display') == 'none'){
			$menuDiv.show();
			$menuEdit.hide();
		}else{
			$menuDiv.hide();
		}
	});

});