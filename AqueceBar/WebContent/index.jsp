<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aquece</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.form-style-4 {
	width: 450px;
	font-size: 16px;
	background: #495C70;
	padding: 30px 30px 15px 30px;
	border: 5px solid #53687E;
}

.form-style-4 input[type=submit], .form-style-4 input[type=button],
	.form-style-4 input[type=text], .form-style-4 input[type=email],
	.form-style-4 textarea, .form-style-4 label {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 16px;
	color: #fff;
}

.form-style-4 label {
	display: block;
	margin-bottom: 10px;
}

.form-style-4 label>span {
	display: inline-block;
	float: left;
	width: 150px;
}

.form-style-4 input[type=text], .form-style-4 input[type=email] {
	background: transparent;
	border: none;
	border-bottom: 1px dashed #83A4C5;
	width: 275px;
	outline: none;
	padding: 0px 0px 0px 0px;
	font-style: italic;
}

.form-style-4 textarea {
	font-style: italic;
	padding: 0px 0px 0px 0px;
	background: transparent;
	outline: none;
	border: none;
	border-bottom: 1px dashed #83A4C5;
	width: 275px;
	overflow: hidden;
	resize: none;
	height: 20px;
}

.form-style-4 textarea:focus, .form-style-4 input[type=text]:focus,
	.form-style-4 input[type=email]:focus, .form-style-4 input[type=email] :focus
	{
	border-bottom: 1px dashed #D9FFA9;
}

.form-style-4 input[type=submit], .form-style-4 input[type=button] {
	background: #576E86;
	border: none;
	padding: 8px 10px 8px 10px;
	border-radius: 5px;
	color: #A8BACE;
}

.form-style-4 input[type=submit]:hover, .form-style-4 input[type=button]:hover
	{
	background: #394D61;
}
</style>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
	<div id="body">
		<div id="main-header">
			<h1>Painel</h1>
			<span id="user-info"> Usuario <a href="javascript:void(0)"
				class="entypo-logout" alt="Logout" title="Logout"></a>
			</span>
		</div>

		<div id="main-navigation">
			<ul>
				<li class="header"></li>
				<li><a href="javascript:void(0)" data-nav-shortcut="50"
					class="entypo-map" onclick="javascript:carregarIniciar();">Vendas<span
						class="shortcut-info"></span></a></li>
				<li class="header">Administração</li>
				<li><a href="javascript:void(0)" data-nav-shortcut="111"
					class="entypo-cog" onclick="javascript:carregarConfiguracoes();">Configurações<span
						class="shortcut-info"></span></a></li>
				<li><a href="javascript:void(0)" data-nav-shortcut="49"
					class="entypo-layout" onclick="javascript:carregarProduto();">Produto<span
						class="shortcut-info"></span></a></li>
				<li><a href="javascript:void(0)" data-nav-shortcut="51"
					class="entypo-users" onclick="javascript:carregarFuncionario();">Funcionário<span
						class="shortcut-info"></span></a></li>
			</ul>
			<span class="shortcut-label entypo-keyboard">ctrl+shift for
				shortcuts</span>
		</div>

		<div id="main-content">
			<!--<a href="javascript:void(0)" class="entypo-mail mailcounter">
    <span>12</span>
  </a>-->
			<h2 id="partial-title">Vendas</h2>
			<ul id="partial-navigation">
			</ul>
			<div id="partial-content">

				<div id="produto" style="display: none">
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: grey;"
						type="button" data-toggle="modal" data-target="#cadastrarProduto">Cadastrar
					</button>
					&nbsp;
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: grey;"
						type="button" data-toggle="modal" data-target="#alterarProduto">Alterar
					</button>

				</div>


				<div id="consultarMesa" style="display: none">
					<form class="form-style-4" action="" method="post">
						<label for="field1"> <span
							style="width: 100px; line-height: 255%;">Mesa 1 </span> <input
							type="button" value="Voltar"
							onclick="javascript:voltarIniciarMesas();"> &nbsp;<input
							type="button" value="Imprimir"
							onclick="javascript:window.print()"> &nbsp;<input
							type="button" value="Fechar" data-toggle="modal"
							data-target="#fecharMesa">
						</label><br> <label for="field2"> <span>Pedidos</span><input
							type="text" name="field2" required="true"><i
							class="fa fa-plus" data-toggle="modal"
							data-target="#adicionarProduto"></i>
						</label> <label for="field3"> <span>Subtotal</span><input
							type="text" name="field3" required="true">
						</label> <label for="field4"> <span>10%</span>
						<textarea name="field4" onkeyup="adjust_textarea(this)"
								required="true"></textarea>
						</label><label for="field4"> <span>Total</span>
						<textarea name="field4" onkeyup="adjust_textarea(this)"
								required="true"></textarea>
						</label> <label> </label>
					</form>
				</div>

				<div id="abrirVenda">
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button" onclick="javascript:abrirConsultarMesa();">
						Mesa 1<span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: red;"
						type="button">
						Mesa 2<span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 3<span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: red;"
						type="button">
						Mesa 4 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 5 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 6 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 7 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 8 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 9 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 10 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 11 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 12 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 13 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 14 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 15 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 16 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 17 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: green;"
						type="button">
						Mesa 18 <span class="glyphicon glyphicon-glass" aria-hidden="true"
							style="color: white;"></span>
					</button>
					&nbsp
				</div>

			</div>
		</div>
		<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

		<script src="js/index.js"></script>
</body>

<!-- Modal adicionar produto-->
<div id="adicionarProduto" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4"
			style="background-color: #495C70; color: white">
			<div class="modal-header">
				<h4 class="modal-title">Adicionar Produto</h4>
			</div>
			<div class="modal-body">
				<center>
					<p>Código:</p>
					<input type="text" class="form-group">
					<p>Nome Produto:</p>
					<input type="text" class="form-group">
					<p>Descrição Produto:</p>
					<input type="text" class="form-group">
					<p>Preço Produto:</p>
					<input type="text" class="form-group">
				</center>
			</div>
			<div class="modal-footer">
				<center>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Adicionar</button>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Fechar</button>
				</center>
			</div>

		</div>

	</div>
</div>
</div>
</div>

<!-- Modal adicionar produto-->
<div id="fecharMesa" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4"
			style="background-color: #495C70; color: white">
			<div class="modal-header">
				<h4 class="modal-title">Fechar Mesa</h4>
			</div>
			<div class="modal-body">
				<center>
					<label> Deseja Fechar a mesa?</label>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default">Sim</button>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Não</button>
				</center>
			</div>

		</div>

	</div>
</div>
<!-- Modal adicionar produto-->
<div id="cadastrarProduto" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4"
			style="background-color: #495C70; color: white">
			<div class="modal-header">
				<h4 class="modal-title">Cadastrar Produto</h4>
			</div>
			<div class="modal-body">
				<center>
					<p>Código:</p>
					<input type="text" class="form-group">
					<p>Nome Produto:</p>
					<input type="text" class="form-group">
					<p>Descrição Produto:</p>
					<input type="text" class="form-group">
					<p>Preço Produto:</p>
					<input type="text" class="form-group">
				</center>
			</div>
			<div class="modal-footer">
				<center>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Cadastrar</button>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Fechar</button>
				</center>
			</div>

		</div>

	</div>
</div>

<!-- Modal adicionar produto-->
<div id="alterarProduto" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4"
			style="background-color: #495C70; color: white">
			<div class="modal-header">
				<h4 class="modal-title">Alterar Produto</h4>
			</div>
			<div class="modal-body">
				<center>
					<p>Código:</p>
					<input type="text" class="form-group">
					<p>Nome Produto:</p>
					<input type="text" disabled class="form-group">
					<p>Descrição Produto:</p>
					<input type="text" disabled class="form-group">
					<p>Preço Produto:</p>
					<input type="text" disabled class="form-group">
				</center>
			</div>
			<div class="modal-footer">
				<center>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Alterar</button>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Fechar</button>
				</center>
			</div>

		</div>

	</div>
</div>


</div>
</div>

</html>