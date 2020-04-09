function onclickThumbnail(value){
    $.ajax({
        method:"GET",
        url:"/portfolio/"+value,
        dataType:"json",
        success : function(data,status){ setData(data.title,data.imageData); $('#exampleModalLong').modal('toggle'); }
        , error : function(){   alert("ErrorMessage"); }
    })
};