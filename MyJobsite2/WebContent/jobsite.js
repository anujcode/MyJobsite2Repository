
/*$(document).ready(function() {
  
	var resulturl = "http://localhost:8080/MyJobsite2/rest/service/results";
	
	$.ajax({
		
		url:resulturl,
		type:'GET',
		//dataType:'json'
		
	})
	
	.done(function(data,status){
		
		
		//var user = JSON.parse(data);
		
		//alert(user.name);
		//alert(status);
		$("#name").html(data);
		//$("#phone").html(data);
		//$("#email").html(data);
		
	})
	
	.fail(function(data,status){
		
		alert(status);
		
		
	});
	
	
});


*/



$("#cprofile").click(function() {
 
 
		var CProfile = {
		    
				name : $("#cname").val(),
				phone : $("#ph").val(),
				email: $("#eid").val()
				
		};
	 
	/*var something = {
			 "person":{
		 		"username" : $("#username").val(),
				"password" : $("#password").val()
	 	}
	 };*/
	
	var cprof=JSON.stringify(CProfile);
	
		
	
	
		var url = "http://localhost:8080/MyJobsite2/rest/service/cprofile";
		
		
		//$.post( url, dataToSend);
		
		
		$.ajax({
          
			data: cprof,
			url: url,
			type: 'POST',
			contentType: 'application/json',
			//Accept: 'application/json',
			//dataType: 'JSONP',
			//async:false,
			
			  
		})
		
		.done( function (data, status) {
		    
			//var obj = JSON.parse(data);
			if(data=="true"){
				
				alert('Profile saved');
				
				//var link1 = 'http://www.google.com';
				//window.location.href = link1;
				
			}
			else{
				
				alert('Unable to save profile');
				
			}
			//alert(obj.username);
			//alert(obj.password);
			
			
			//alert(data);
			//do whatever you want with the return data upon successful return
		 })
		 .fail( function (data, status) {
		    
			 alert(status);
			 //do whatever you want with the return data upon error
		 });
	 
	
		 //return false; // avoid to execute the actual submit of the form.	
});







$("#register").click(function() {
 
 
		var User = {
		    
			username : $("#user").val(),
			password : $("#pass").val()
			
		};
	 
	/*var something = {
			 "person":{
		 		"username" : $("#username").val(),
				"password" : $("#password").val()
	 	}
	 };*/
	
	var dataToSend=JSON.stringify(User);
	
		
	
	
		var url = "http://localhost:8080/MyJobsite2/rest/service/register";
		
		
		//$.post( url, dataToSend);
		
		
		$.ajax({
          
			data: dataToSend,
			url: url,
			type: 'POST',
			contentType: 'application/json',
			//Accept: 'application/json',
			//dataType: 'JSONP',
			//async:false,
			
			  
		})
		
		.done( function (data, status) {
		    
			//var obj = JSON.parse(data);
			if(data=="true"){
				
				alert('username exists');
				
			}
			else{
				
				var link1 = 'http://localhost:8080/MyJobsite2/RegistrationResult.html';
				window.location.href = link1;
				
			}
			//alert(obj.username);
			//alert(obj.password);
			
			
			//alert(data);
			//do whatever you want with the return data upon successful return
		 })
		 .fail( function (data, status) {
		    
			 alert(status);
			 //do whatever you want with the return data upon error
		 });
	 
	
		 //return false; // avoid to execute the actual submit of the form.	
});





$("#lgn").click(function() {
	 
	 
	var Candidate = {
	    
		username : $("#user").val(),
		password : $("#pass").val()
		
	};
 
	
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var dataToSend=JSON.stringify(Candidate);

	


	var url = "http://localhost:8080/MyJobsite2/rest/service/login";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: dataToSend,
		url: url,
		type: 'POST',
		contentType: 'application/json',
		//Accept: 'application/json',
		//dataType: 'JSONP',
		//async:false,
		
		  
	})
	
	.done( function (data, status) {
	    
		//var obj = JSON.parse(data);
		if(data=="true"){
			
			//alert('user authenticated');
			
			var profilelink = 'http://localhost:8080/MyJobsite2/CandidateProfile.html';
			window.location.href = profilelink;
			
		}
		else{
			
			alert('Invalid user. Please check login details!');
			
		}
		//alert(obj.username);
		//alert(obj.password);
		
		
		//alert(data);
		//do whatever you want with the return data upon successful return
	 })
	 .fail( function (data, status) {
	    
		 alert(status);
		 //do whatever you want with the return data upon error
	 });
 

	 //return false; // avoid to execute the actual submit of the form.	
});













$("#companyreg").click(function() {
	 
	 
	var CompanyDetails = {
	    
		company : $("#cname").val(),
		location : $("#loc").val(),
		phone :$("#ph").val()
	};
 
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var dataToSend2=JSON.stringify(CompanyDetails);

	


	var url = "http://localhost:8080/MyJobsite2/rest/service/companyreg";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: dataToSend2,
		url: url,
		type: 'POST',
		contentType: 'application/json',
		//Accept: 'application/json',
		//dataType: 'JSONP',
		//async:false,
		
		  
	})
	
	.done( function (data, status) {
	    
		//var obj = JSON.parse(data);
		if(data=="true"){
			//var link1 = 'http://stackoverflow.com';
			//window.location.href = link1;
		}
		else{
			
			//var link2 = 'http://google.com';
			//window.location.href = link2;
			
		}
		//alert(obj.username);
		//alert(obj.password);
		
		
		//alert(data);
		//do whatever you want with the return data upon successful return
	 })
	 .fail( function (data, status) {
	    
		 alert(status);
		 //do whatever you want with the return data upon error
	 });
 

	 //return false; // avoid to execute the actual submit of the form.	
});


$("#auth").click(function() {
	 
	 
	var Profile = {
	    
		name : $("#cname").val(),
		phone : $("#ph").val(),
		email :$("#eid").val()
	};
 
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var dataToSend3=JSON.stringify(Profile);

	


	var url = "http://localhost:8080/MyJobsite2/rest/service/jobseekerprofile";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: dataToSend3,
		url: url,
		type: 'POST',
		contentType: 'application/json',
		//Accept: 'application/json',
		//dataType: 'JSONP',
		//async:false,
		
		  
	})
	
	.done( function (data, status) {
	    
		//var obj = JSON.parse(data);
		if(data=="true"){
			//var link1 = 'http://stackoverflow.com';
			//window.location.href = link1;
		}
		else{
			
			//var link2 = 'http://google.com';
			//window.location.href = link2;
			
		}
		//alert(obj.username);
		//alert(obj.password);
		
		
		//alert(data);
		//do whatever you want with the return data upon successful return
	 })
	 .fail( function (data, status) {
	    
		 alert(status);
		 //do whatever you want with the return data upon error
	 });
 

	 //return false; // avoid to execute the actual submit of the form.	
});




$("#search").click(function() {
	 
	 

	var url = "http://localhost:8080/MyJobsite2/rest/service/jobsearch";
	
	
	
	
	$.ajax({
      
		
		url: url,
		type: 'GET',
		contentType: 'application/json',
		//Accept: 'application/json',
		//dataType: 'JSONP',
		//async:false,
		
		  
	})
	
	.done( function (data, status) {
	    
		var link1 = 'http://stackoverflow.com';
		window.location.href = link1;
		
	 })
	 .fail( function (data, status) {
	    
		 alert(status);
		 //do whatever you want with the return data upon error
	 });
 

	 //return false; // avoid to execute the actual submit of the form.	
});






