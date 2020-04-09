function getPostModal(){
    $.ajax({
        method:"GET",
        url:"/post/sendPost",
        dataType:"json",
        success : function(data){
            setData(data.name,data.contents);
            $('#exampleModalLong').modal('toggle');
        }
        ,error : function(error){   alert(error); }
    })
}
function getPostContent(selected) {
    setData(
        $(selected.getElementsByClassName("post_name")).text()
        , $(selected.getElementsByClassName("post_content")).text()
    );
    $('#exampleModalLong').modal('toggle');
}
function getPage(page)
{
    $.ajax({
        method:"GET",
        url:"/post/page/"+page,
        dataType:"json",
        contentType:"application/json;charset=UTF-8",
        success:function(data)
        {
            replacePostList(data);
            pageNumbering(data.currentPage,data.pageSize);
        }
        ,error:function(errorCode){ alert(errorCode);}
    });
}
function sendPost(){
    var jsonObject = {
        "name": $("#post_name").val(),
        "content" : CKEDITOR.instances.editor.getData(),
        "subject" : $("#selected_post").text()
    };
    $.ajax({
            method:"POST",
            url:"/post/sendPost",
            data:JSON.stringify(jsonObject),
            dataType:"json",contentType:"application/json;charset=UTF-8",
            success:function(data){
                $('#exampleModalLong').modal('hide');
                getPage(1);
            }
        }
    );
}
function replacePostList(data){
    var tbody = $("#post_table");
    tbody.empty();
    $.each(data.posts,function(i,item){
        var tr = $("<tr onclick=\"getPostContent(this)\"></tr>");
        tbody.append(tr);
        tr.append("<td style=\"display:none;\" class='post_number'>"+item.number+"</td>");
        var td_content = $("<td class='post_content' style='display:none;'></td>").text(item.content);
        tr.append(td_content);
        tr.append("<td class='post_name' style='width:60%;'>"+item.name+"</td>");
        tr.append("<td>" + item.owner.name+"</td>");
        tr.append("<td>" + item.date+"</td>");
    })
}
function replacePostModal(){
    $.ajax({
        method:"GET",
        url:"/post/sendPost",
        dataType:"json",
        success : function(data){
            setData(data.postName,data.postForm);
            CKEDITOR.replace( 'editor');
            $('#exampleModalLong').modal('toggle');
        }
        ,error : function(error){   alert(error); }
    })
};
function getPostList(obj,value)
{
    var tbody = $("table>tbody");
    tbody.empty();
    $.ajax({
         method:"GET", url:"/post/list/"+value,dataType:"json",
        success:function(data){
            $("#dropItem").text($(obj).text());
            $("#dropItem").append("<span class='caret'></span>");
            var temp = [$("#selected_post").text(),$("#selected_post_name").text()];
            $("#selected_post_name").text($(obj).text());
            $("#selected_post").text(value);
            $(obj).text(temp[1]);
            $(obj).attr("onclick","getPostList(this,"+temp[0]+")");
            replacePostList(data);
            pageNumbering(data.currentPage,data.pageSize);
        }
    })
}
function pageNumbering(currentPage,pageSize) {
    $(".pagination").empty();
    if (currentPage + 4 < pageSize && currentSize - 4 > 1) {
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(/post/page/"+(currentPage-4)+"')' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span> <span class='sr-only'>Previous</span></button></li>")
        for (i = currentPage - 3; i < currentPage + 3; i++) {
            $(".pagination").append("<li class=\"page-item\"><button class=\"page-link\" onclick=\"getPage("+i+"))\">"+i+"</button></li>")
        }
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(/post/page/"+(currentPage+4)+"') aria-label='Next'> <span aria-hidden='true'>&raquo;</span> <span class='sr-only'>Next</span></button></li>")
    }
    else if(currentPage-4 > 1 && currentPage+4 < pageSize){
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(/post/page/"+(currentPage-4)+"')' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span> <span class='sr-only'>Previous</span></button></li>")
        for (i = currentPage - 3; i < pageSize; i++) {
            $(".pagination").append("<li class=\"page-item\"><button class=\"page-link\" onclick=\"getPage("+i+"))\">"+i+"</button></li>")
        }
    }
    else if (currentPage + 4 < pageSize && currentSize - 4 <= 1)
    {
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(1)' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span> <span class='sr-only'>Previous</span></button></li>")
        for (i = 1; i < currentPage + 3; i++) {
            $(".pagination").append("<li class=\"page-item\"><button class=\"page-link\" onclick=\"getPage("+i+")\">"+i+"</button></li>")
        }
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(/post/page/"+currentPage+4+")' aria-label='Next'> <span aria-hidden='true'>&raquo;</span> <span class='sr-only'>Next</span></button></li>")
    }
    else if(currentPage + 4 > pageSize && currentPage-4 <= 1)
    {
        if(pageSize == 0) return;
        $(".pagination").append("<li class='page-item'> <button class='page-link' onclick='getPage(1)' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span> <span class='sr-only'>Previous</span></button></li>")
        for (i = 1; i <= pageSize; i++) {
            $(".pagination").append("<li class=\"page-item\"><button class=\"page-link\" onclick=\"getPage("+i+")\">"+i+"</button></li>")
        }
    }
}