<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vagante Scholars</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="styles/index.css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
		<div class="navbar-header">
		    <a class="navbar-brand" href="home">Vagante Scholars</a>
		</div>
		<ul class="nav navbar-nav">
		    <li class="active"><a href="home">Home</a></li>
		    <li><a href="login.jsp">Login</a></li>
		</ul>
		
		<form action="search" method="get" class="navbar-form navbar-right">
		    <div class="form-group">
			  <input name="searchTerm" type="text" class="form-control" placeholder="Search">
		    </div>
		    <button type="submit" class="btn btn-default">Submit</button>
		</form>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
        </div>
        <div class="col-sm-6 header">
			<h2>Vagante Scholars</h2>
        </div>
        <div class="col-sm-3">
        </div>
    </div>
	<hr/>
    <div class="row">
        <div class="col-sm-4 portrait">
            <h3>Areas</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
        <div class="col-sm-4 portrait">
            <h3>Classes</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
        <div class="col-sm-4 portrait">
            <h3>Monsters</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4 portrait">
            <h3>Secrets</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
        <div class="col-sm-4 portrait">
            <h3>Weapons</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
        <div class="col-sm-4 portrait">
            <h3>Affinities</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
    </div>
</div>

</body>
</html>
