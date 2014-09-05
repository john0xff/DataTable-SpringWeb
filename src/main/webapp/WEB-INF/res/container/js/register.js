/**
 * 
 */
function checkForm(form) {

	var re = /^\w+$/;

	if (!re.test(form.username.value)) {
		alert("Error: Username must contain only letters, numbers and underscores!");
		form.username.focus();
		return false;
	}
	
	if(form.password.value != form.passwordRepeat.value){
		alert("Error: Different passwords, write it again!");
		form.password.focus();
		return false;
	}
	
	if (form.password.value != "" && form.password.value == form.passwordRepeat.value) {
		if (form.password.value.length < 6) {
			alert("Error: Password must contain at least six characters!");
			form.password.focus();
			return false;
		}
		if (form.password.value == form.username.value) {
			alert("Error: Password must be different from Username!");
			form.password.focus();
			return false;
		}
	}
	return true;
}