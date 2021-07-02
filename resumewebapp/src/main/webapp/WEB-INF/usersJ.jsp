<%-- 
    Document   : users
    Created on : Jan 15, 2021, 11:57:59 PM
    Author     : Zohrab
--%>


<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="assets/css/users.css" >
        <script src="https://kit.fontawesome.com/637dc94052.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script type="text/javascript" src="assets/js/users.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
<%--    <%@ include file="header.jsp" %>--%>
    <%--<jsp:include page="header.jsp" />--%>

       <%


           List<User> list =(List<User>) request.getAttribute("usersList");



       %>


       <div class="container mycontainer">
          <div class="row">
           <div class="form-group col-sm-4">
               <form action="users" method="GET">
                   <input type="hidden" name="id" value=""  />

          <label for="name"> name: </label>
           <input placeholder="Enter name"  type="text" name="name" value="" class="form-control" id="whatIamTyping"  onkeyup="myTop()" />
                   text here:
                   <span id="typing">  </span>
           <br>
           <label for="surname"> surname: </label>
           <input  placeholder="Enter surname" type="text" name="surname" value=""  class="form-control" />
               <br>

                   <label for="nId"> nationality_id: </label>
                   <input placeholder="Enter nationality_id" type="text" name="nId" value=""  class="form-control"/>
                   <br>
           <input type="submit" name="search" value="Search" class="btn btn-primary" id="btnsearch"  />


               </form>
           </div>


          </div>
     <hr>
         <div>
             <table class="table">
                 <thead>
                 <tr>
                     <th> name</th>
                     <th>surname</th>
                     <th>nationality</th>
                     <th> </th>

                 </tr>
                 </thead>
                 <tbody>
                 <%
                     for(User u:list){
                 %>
                 <tr>
                     <td> <%=u.getName() %> </td>
                     <td>  <%=u.getSurname() %></td>
                     <td> <%=u.getNationality().getNationality()==null?"N/A":u.getNationality().getNationality()  %> </td>

                    <td style="width:2px">

                            <input type="hidden" name="id" value="<%=u.getId()%>">
                        <button type="submit" name="action" value="delete" class="btn_table "
                                data-toggle="modal" data-target="#exampleModal" onclick="setIdForDelete(<%=u.getId()%>)">
                            <i class="fas fa-trash-alt"></i>
                            </button>

                    </td>
                     <td style="width: 2px">
                        <form action="user.detail" method="GET">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                         <button type="submit" name="action" value="update" class="btn_table" >
                             <i  class="fas fa-pen-square"></i>
                         </button>
                        </form>
                     </td>
                 </tr>
                 <% } %>
                 </tbody>
             </table>
         </div>

       </div>

       <!-- Button trigger modal -->


       <!-- Modal -->
       <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
           <div class="modal-dialog" role="document">
               <div class="modal-content">
                   <div class="modal-header">
                       <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                       <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                           <span aria-hidden="true">&times;</span>
                       </button>
                   </div>
                   <div class="modal-body">
                       Are you sure?
                   </div>
                   <div class="modal-footer">
                       <form action="user.detail" method="POST">
                           <input id="idForDelete" type="hidden" name="id" value="">
                           <input type="hidden" name="action" value="delete">

                       <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                       <button type="submit" class="btn btn-danger">Delete</button>
                       </form>
                   </div>
               </div>
           </div>
       </div>

    </body>
</html>
