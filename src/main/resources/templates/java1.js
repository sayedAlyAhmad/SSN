function myfun(){

var http= new XMLHttpRequest();
http.open("GET","http://localhost:8086/v1/private/api/user",true);
http.responseType='json';
http.send();
http.onreadystatechange=function(){
    if(http.readyState==4&&http.status==200){
       console.log(http.response);

       var htp=http.response;
       //console.log(htp[0]);
      // document.getElementById("f").value=htp[0].name;

       var i=0;
       while(i<htp.length){
        if( document.getElementById("f").value==htp[i].name){
            document.getElementById("m").value=htp[i].email;
           // document.getElementById("p").value=htp[i].npass;
            //document.getElementById("o").value=htp[i].cpass; 
        }else{
            alert(Error);
        }
        i++;
       }
    }
  
}}

 
 function myfun_1(){
    event.preventDefault();
    var fname=document.getElementById("f").value;
    var lname=document.getElementById("l").value;
    var mail=document.getElementById("m").value;
    var date=document.getElementById("d").value;
    var password=document.getElementById("p").value;
    var confpass=document.getElementById("o").value;
    var gender=document.getElementById("g").value;
   
   const post={
        fname:fname,
        lname:lname,
        email:mail,
        dateofberth:date,
        password:password,
        confirmpassword:confpass,
        gender:gender,   
    }
    if(document.getElementById("p").value!=document.getElementById("o").value){
        alert(Error)
    }else{
        fetch("https://jsonplaceholder.typicode.com/posts",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(post),

        }).then(()=>{
            alert("post added");
        })
       
    }

}


