

$("#compregister").click(function() {
 
 
		var Company = {
		    
			companyName : $("#comp").val(),
			password : $("#pass").val()
			
		};
	 
	
	
	var reginfo=JSON.stringify(Company);
	
		
	
	
		var url = "http://localhost:8080/MyJobsite2/rest/company/register";
		
		
		//$.post( url, dataToSend);
		
		
		$.ajax({
          
			data: reginfo,
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
				
				alert('Company exists! Please enter a different company.');
				
			}
			else{
				
				var link1 = 'http://localhost:8080/MyJobsite2/CompanyRegResult.html';
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
	 
	 
	var CompanyInfo = {
	    
		companyName : $("#comp").val(),
		password : $("#pass").val()
		
	};
 
	
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var compInfo=JSON.stringify(CompanyInfo);

	


	var loginurl = "http://localhost:8080/MyJobsite2/rest/company/login";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: compInfo,
		url: loginurl,
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
			
			var profile = 'http://localhost:8080/MyJobsite2/CompanyProfile.html';
			window.location.href = profile;
			
		}
		else{
			
			alert('Unauthorized Login! Please check login details.');
			
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


$("#compprofile").click(function() {
	 
	 
	var company_profile = {
	    
		name : $("#cname").val(),
		location: $("#loc").val(),
		phone : $("#ph").val(),
		website :$("#web").val()
	};
 
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var profiledata=JSON.stringify(company_profile);

	


	var url = "http://localhost:8080/MyJobsite2/rest/company/profile";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: profiledata,
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
			alert('Profile Saved!');
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




$("#create").click(function() {
	 
	 
	var job = {
	    
		title : $("#jlabel").val(),
		company: $("#comp").val(),
		location : $("#loc").val(),
		date :$("#dt").val()
	};
 
/*var something = {
		 "person":{
	 		"username" : $("#username").val(),
			"password" : $("#password").val()
 	}
 };*/

	var created_job = JSON.stringify(job);

	


	var url = "http://localhost:8080/MyJobsite2/rest/company/createjob";
	
	
	//$.post( url, dataToSend);
	
	
	$.ajax({
      
		data: created_job,
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
			alert('Job Created!');
			var jobsuccesspage = 'http://localhost:8080/MyJobsite2/JobPostSuccess.html';
			window.location.href = jobsuccesspage;
		}
		else{
			
			alert('Job already Exists! Please create a different job.');
			//var link2 = 'http://google.com';
			//window.location.href = link2;
			
		}
		
	 })
	 .fail( function (data, status) {
	    
		 alert(status);
		 //do whatever you want with the return data upon error
	 });
 

	 //return false; // avoid to execute the actual submit of the form.	
});








