$(function() {
	/**
	 * �س���ť����
	 */
	$('#user_fm').keypress(function(e) {
		if (e.keyCode == 13) {
			login();
		}
	});

	/**
	 * �û���¼
	 * 
	 * @returns
	 */
	login = function() {
		var username = $('#username'), password = $('#password'), error = $('#error');

	    if (!$.trim(username.val())) return error.html('�û�������Ϊ��');

		if (!$.trim(password.val())) return error.html('���벻��Ϊ��');

		/**
		 * ����Ajax���б��첽�ύ
		 */

		$.ajax({
			url : 'User!login.do',
			method : 'post',
			data : $('#user_fm').serializeObject(),
			success : function(r) {
				if (r.success) {
					location.href = 'main.jsp';
				} else {
					error.html(r.msg);
				}
			},
			error : function(r) {

			}
		})
	}
});