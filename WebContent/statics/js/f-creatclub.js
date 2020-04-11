function check() {
	var name = document.getElementById("name").value;
	var phone = document.getElementById("phone").value;
	var clubName = document.getElementById("clubName").value;
	var clubBrief = document.getElementById("clubBrief").value;
	if (/^[\s\n\t\r]*$/.test(name)){
		alert('用户名不能为空');
		return false;
	}else if (/^[\s\n\t\r]*$/.test(phone)){
		alert('用户名不能为空');
		return false;
	}else if (/^[\s\n\t\r]*$/.test(clubName)){
		alert('用户名不能为空');
		return false;
	}else if (/^[\s\n\t\r]*$/.test(clubBrief)){
		alert('用户名不能为空');
		return false;
	}
		
		
		
		/*}else if (!/^[0-11]*$/.test(phone) || /(^\s*)|(\s*$)/.test(phone)) {
		alert('请输入正确的号码');
		return false;
	}else if (/^[\s\n\t\r]*$/.test(clubName)) {
		alert('社团名不能为空')
		return false;
	}else if (/^[\s\n\t\r]*$/.test(password)) {
		alert('密码不能为空')
		return false;
	}*/
}