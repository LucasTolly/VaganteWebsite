<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Monsters</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- Datatables -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.13/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.13/datatables.min.js"></script>
    </head>
    <script>
        /* THIS IS TEMPORARY, MOVE OUT TO ANOTHER FILE ASAP */
        $(document).ready(function() {
            $('#monsters').DataTable( {
                "info":     false,
                "columnDefs": [ {
                    "targets": 2,
                    "orderable": false
                }]
            } );
        } );
    </script>
    <style>
        /* ALSO TEMPORARY */
        /* Element Selectors */
        body {
            background-image: url("/VaganteScholars/images/forest_bg.png");
            background-attachment fixed:
            background-repeat: repeat-x;
            background-size: auto 100%;
            color: #BEBEC2;
        }
        td, th {
            padding: 10px;
        }

        thead tr #descriptionColumn {
            width: 80%;
        }

        /* The following is a hack designed to shift the sorting icons of datatables
           to the left of the header column, instead of the right.*/
        /*table.dataTable thead > tr > th {
            padding-left: 30px !important;
            padding-right: initial !important;
        }

        table.dataTable thead .sorting:after,
        table.dataTable thead .sorting_asc:after,
        table.dataTable thead .sorting_desc:after {
            left: 8px !important;
            right: auto !important;
        }*/
        /* Class Selectors */
        .container {
            background-color: #222222;
            opacity: 0.9;
            border-radius: 10px;
            padding: 20px;
        }

        .display {
            margin-left: 20px;
            margin-right: 20px;
        }
        /* ID Selectors */
        #monsters_filter, #monsters_paginate {
            padding-right: 20px;
        }

        #monsters_length {
            padding-left: 20px;
        }
    </style>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Vagante Scholars</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/index.jsp">Home</a></li>
                    <li><a href="/signup.jsp">Signup</a></li>
                </ul>
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </nav>

        <div class="container">
            <h1>Monsters</h1>
            <h4>These are the monster that prowl the dungeons of Vagante. Click on one to discover its nature!</h4>
            <div class="row">
                <table id="monsters" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>HP</th>
                            <th id="descriptionColumn">Description</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="monster" items="${monsters}">
                        <tr>
                            <td>
                                <a href="/monster&id=${monster.monsterId}" target="_blank">${monster.name}</a>
                            </td>
                            <td>${monster.hp}</td>
                            <td title="${monster.description}">${monster.shortDescription}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
