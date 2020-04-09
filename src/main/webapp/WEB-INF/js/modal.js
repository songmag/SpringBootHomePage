var setData = function(title, data){
    $("#contents-title").empty();
    $("#contents-data").empty();
    $("#contents-title").append(title);
    $("#contents-data").append(data);
};
function login() {
    setData("<p><h1>Login</h1></p>",
        "<input type='text' id='user_id' class='form-control' placeholder='User-id' style='width:100%;'/>" +"<br/>"
    + "<input type='password' id='user_password' class='form-control' placeholder='User-password' style='width:100%;'/>"
        +"<br/>");
    $("#loginButton").remove();
    $(".modal-footer").append("<button class='btn btn-default float-right' id='loginButton' onclick='loginAdmin()'>Login</button>");
    alert("아직 준비중입니다.");
    // $('#exampleModalLong').modal('toggle');
};
function loginAdmin()
{
    $("#user_id").text();
    $("#user_password").text();
    $('#exampleModalLong').modal('hide');
}
function changeAdmin()
{

};
function changeUser()
{

};