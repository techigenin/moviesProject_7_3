function form() {
    
    let xhr= new XMLHttpRequest(); // calling get from the servlet
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status===200)//check the response is ready and finished
            {
            let form = JSON.parse(xhr.responseText);
            pending(form);
            }
        
        
        
    }
    xhr.open("GET","user",true);// open xhr
    xhr.send();
}

function pending(form){
        const tableBody = document.getElementById("newform");
        tableBody.innerHTML="";
    for(i=0 ; i< form.length; i++){
        tableBody.innerHTML+=`
        <tr>
        <td>${form[i].title}</td>
        <td>${form[i].date}</td>
        <td>${form[i].genres}</td>

        </tr>
        `;
    
    }
    
}


window.onload = function() {
getReimbForm();
}