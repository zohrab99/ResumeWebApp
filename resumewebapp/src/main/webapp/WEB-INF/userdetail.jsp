<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.entity.Country" %>
<%@ page import="java.util.List" %><%--
    Document   : user
    Created on : Jan 15, 2021, 11:57:59 PM
    Author     : Zohrab
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/users.css" >
        <script src="https://kit.fontawesome.com/637dc94052.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
       <%

           User u= (User) request.getAttribute("user");
           List<Country> list= (List<Country>) request.getAttribute("allCountry") ;
           System.out.println("second ceheck= "+list);



       %>

           <div  style="margin-top: 50px" class="container">
               <form action="user.detail" method="POST">

                   <input type="hidden" name="id" value="<%=u.getId()%>"  />
                   <input type="hidden" name="action" value="update">
                   <h4 class="text-right">Profile Settings</h4> <br>

                 <div class="row mt-2">
                  <div class="mb-3 col-md-3">
                   <label for="name" class="form-label"> Name </label>
                   <input style="width: 80%" type="text" name="name" value="<%=u.getName()%> "  class="form-control" />

                  </div>

                   <div class="mb-3 col-md-3">
                       <label for="surname" class="form-label"> Surname </label>
                       <input style="width: 80%"  type="text" name="surname" value="<%=u.getSurname()%> " class="form-control"  />
                   </div>
                 </div>

                   <div class="mb-3">
                       <label for="email" class="form-label">Email</label>
                       <input style="width: 35%" type="text" name="email" value="<%=u.getEmail()%>" class="form-control ">
                   </div>

                   <div class="mb-3">
                       <label for="phone" class="form-label">Phone Number</label>
                       <input style="width: 35%" type="text" name="phone" value="<%=u.getPhone()%>"  class="form-control" >
                   </div>

                   <div class="mb-3">
                       <label for="address" class="form-label" >Address</label>
                       <input style="width: 35%" type="text" name="address" value="<%=u.getAdress()%>"  class="form-control">
                   </div>
                    <br>
                    <div class="row mt-2">
                        <div class="col-md-2">
                        <label for="countryList" class="form-label">Birthplace</label>
                        <input style="width:93%;" class="form-control" list="datalistOptions" name="countryList" value="<%=u.getBirthPlace().getName()%> "  placeholder="Type to search...">
                        <datalist id="datalistOptions">
                            <%
                                for(Country country:list){
                            %>
                            <option value="<%=country.getName()%>">

                           <%
                             }
                           %>
                        </datalist>
                        </div>

                        <div class="col-md-2">
                            <label for="nationList" class="form-label">Nationality</label>
                            <input style="width:93%;" class="form-control" list="dataNationOptions" name="nationList" value="<%=u.getNationality().getNationality()%> "  placeholder="Type to search...">
                            <datalist id="dataNationOptions">
                                <%
                                    for(Country country:list){
                                %>
                                <option value="<%=country.getNationality()%>">

                                        <%
                             }
                           %>
                            </datalist>
                        </div>
                    </div>


                   <div class="mt-5 text-center">
                       <button class="btn btn-primary profile-button" type="submit" name="action" >Save Profile</button>
                   </div>


               </form>
           </div>



    </body>
</html>
