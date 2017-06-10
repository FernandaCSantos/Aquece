<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aquece</title>

<script
	src="js/jquery.min.js"></script>
<script
	src="bootstrap.min.js"></script>
<script src="js/aquece.js"></script>
<link rel="stylesheet"
	href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="css/awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<input type="hidden" id="codigoPerfilHidden" />
	<input type="hidden" id="nomePerfilHidden" />
	<div id="body">
		<div id="main-header">
			<h1>Painel</h1>
			<span id="user-info"> Login </span>
		</div>
		<div id="main-navigation">
			<ul>
				<li class="header"></li>
				<li><a href="javascript:void(0)" data-nav-shortcut="50"
					class="entypo-map"
					onclick="javascript:carregarIniciar();AQUECE.consultarMesas();">Vendas<span
						class="shortcut-info"></span></a></li>
				<div id="perfil_adm">
					<li class="header">Administra&ccedil&atildeo</li>
					<li><a href="javascript:void(0)" data-nav-shortcut="111"
						class="entypo-cog" onclick="javascript:carregarConfiguracoes();">Configura&ccedil&otildees<span
							class="shortcut-info"></span></a></li>
					<li><a href="javascript:void(0)" data-nav-shortcut="49"
						class="entypo-layout" onclick="javascript:carregarProduto();">Produto<span
							class="shortcut-info"></span></a></li>
					<li><a href="javascript:void(0)" data-nav-shortcut="51"
						class="entypo-users" onclick="javascript:carregarFuncionario();">Funcion&aacuterio<span
							class="shortcut-info"></span></a></li>
					<li><a href="javascript:void(0)" data-nav-shortcut="51"
						class="entypo-users" onclick="javascript:carregarMesa();">Mesa<span
							class="shortcut-info"></span></a></li>
				</div>
			</ul>
			<!-- 			<span class="shortcut-label entypo-keyboard">ctrl+shift for -->
			<!-- 				shortcuts</span> -->
		</div>

		<div id="main-content">
			<!--<a href="javascript:void(0)" class="entypo-mail mailcounter">
    <span>12</span>
  </a>-->
			<h2 id="partial-title">Vendas</h2>
			<ul id="partial-navigation">
			</ul>
			<div id="partial-content">

				<div id="funcionario" style="display: none;">
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: grey;"
						type="button" data-toggle="modal" data-target="#cadastrarPerfil"
						onclick="javascript:AQUECE.resetarFormulario(formCadastrarPerfil);">Cadastrar
					</button>
					&nbsp;
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: slategrey;"
						type="button" data-toggle="modal" data-target="#alterarPerfil"
						onclick="javascript:AQUECE.resetarFormulario(formAlterarPerfil);">Alterar
					</button>
				</div>

				<div id="mesa" style="display: none;">
					<br> 
						<label for="field2"> <span>Número da Mesa:</span><input type="text" id="mesaCadastrar" required="true">
						</label>   
					<button
						style="margin-bottom: 1%; width: 10%; height: 100%; color: white; background-color: grey;"
						type="button" onclick="javascript:AQUECE.cadastrarMesa();">Cadastrar
					</button>
				</div>


				<div id="produto" style="display: none">
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: grey;"
						type="button" data-toggle="modal" data-target="#cadastrarProduto"
						onclick="javascript:AQUECE.resetarFormulario(formCadastrarProduto);">Cadastrar
					</button>
					&nbsp;
					<button
						style="margin-bottom: 1%; width: 10%; height: 50px; color: white; background-color: grey;"
						type="button" data-toggle="modal" data-target="#alterarProduto"
						onclick="javascript:AQUECE.resetarFormulario(formAlterarProduto);">Alterar
					</button>
				</div>
				<div id="consultarMesa" style="display: none">
					
					<form class="form-style-4" action="" method="post">
						<label for="field1"> <span
							style="width: 100px; line-height: 255%;" id="mesa_span"></span> <input
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
						</label> <label for="field4"> <span>10%</span> <textarea
								name="field4" onkeyup="adjust_textarea(this)" required="true"></textarea>
						</label><label for="field4"> <span>Total</span> <textarea
								name="field4" onkeyup="adjust_textarea(this)" required="true"></textarea>
						</label> <label> </label>
					</form>
				</div>

				<div id="abrirVenda"></div>

			</div>
		</div>

		<script src="js/index.js"></script>
</body>

<!-- Modal adicionar produto-->
<div id="adicionarProduto" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4">
			<div class="modal-header">
				<h4 class="modal-title">Adicionar Produto</h4>
			</div>
			<div class="modal-body">
				<center>
				<input type="hidden" id="mesa_venda"/> 
				<input type="hidden" id="status"/>
				<input type="hidden" id="valorProduto"/>
					<p>Atendente:</p>
					<input id="perfil" type="text" value="1" class="form-group">
					<p>C&oacutedigo:</p>
					<input id="codigoProdutoVenda" onblur="javascript:AQUECE.consultarProdutoVenda();" type="text" class="form-group">
					<p>Descri&ccedil&atildeo Produto:</p>
					<input type="text" id="descricaoProdutoVenda" class="form-group">
					<p>Pre&ccedilo Produto:</p>
					<input type="text" id="precoProdutoVenda" class="form-group">
					<p>Quantidade Produto:</p>
					<input type="text" id="quantidadeProdutoVenda" onkeyup="javascript: AQUECE.alterarQuantidade();" value="1" class="form-group">
					<p>Subtotal:</p>
					<input type="text" id="subtotalPrecoProdutoVenda" class="form-group">
					
				</center>
			</div>
			<div class="modal-footer">
				<center>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" onclick="javascript:AQUECE.cadastrarVendas();" data-dismiss="modal">Adicionar</button>
					<button type="button"
						style="background-color: #576E86; color: white;"
						class="btn btn-default" data-dismiss="modal">Fechar</button>
				</center>
			</div>

		</div>

	</div>
</div>
<!-- Modal adicionar produto-->
<div id="fecharMesa" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content form-style-4">
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
						class="btn btn-default" data-dismiss="modal">N&atildeo</button>
				</center>
			</div>

		</div>

	</div>
</div>

<!-- Modal adicionar perfil-->
<form id="formCadastrarPerfil">
	<div id="cadastrarPerfil" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Cadastrar Perfil</h4>
				</div>
				<div class="modal-body">
					<center>
						<p>Perfil:</p>
						<input type="text" id="nomeCadastrarPerfil" disabled
							class="form-group" value="GARCOM">
						<p>Usuario:</p>
						<input type="text" id="usuarioCadastrarPerfil" class="form-group">
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal"
							onclick="javascript:AQUECE.cadastrarPerfil();">Cadastrar</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">Fechar</button>
					</center>
				</div>
			</div>
		</div>
	</div>
</form>

<!-- modal alterar perfil -->
<form id="formAlterarPerfil">
	<div id="alterarPerfil" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Alterar Perfil</h4>
				</div>
				<div class="modal-body">
					<center>
						<p>Perfil:</p>
						<input type="text" id="nomeAlterarPerfil" disabled
							class="form-group" value="GARCOM">
						<p>Usuario:</p>
						<input type="text" id="usuarioAlterarPerfil" class="form-group">
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal"
							onclick="javascript:AQUECE.alterarPerfil();">Cadastrar</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">Fechar</button>
					</center>
				</div>
			</div>
		</div>
	</div>
</form>





<!-- Modal adicionar produto-->
<form id="formCadastrarProduto">
	<div id="cadastrarProduto" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Cadastrar Produto</h4>
				</div>
				<div class="modal-body">
					<center>
						<p>C&oacutedigo:</p>
						<input type="text" id="codigoCadastrarProduto" class="form-group">
						<!-- 					<p>Nome Produto:</p> -->
						<!-- 					<input type="text" id="nomeCadastrarProduto" class="form-group"> -->
						<p>Descri&ccedil&atildeo Produto:</p>
						<input type="text" id="descricaoCadastrarProduto"
							class="form-group">
						<p>Pre&ccedilo Produto:</p>
						<input type="text" id="precoCadastrarProduto" class="form-group">
						<p>Quantidade:</p>
						<input type="text" id="quantidadeCadastrarProduto"
							class="form-group">
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal"
							onclick="javascript:AQUECE.cadastrarProduto();">Cadastrar</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">Fechar</button>
					</center>
				</div>
			</div>
		</div>
	</div>
</form>



<!-- Modal adicionar produto-->
<form id="formAlterarProduto">
	<div id="alterarProduto" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Alterar Produto</h4>
				</div>
				<div class="modal-body">
					<center>
						<p>C&oacutedigo:</p>
						<input type="text" id="codigoAlterarProduto"
							onblur="javascript:AQUECE.consultarProduto();" class="form-group">
						<!-- 					<p>Nome Produto:</p> -->
						<!-- 					<input type="text" id="nomeAlterarProduto" class="form-group"> -->
						<p>Descri&ccedil&atildeo Produto:</p>
						<input type="text" id="descricaoAlterarProduto" class="form-group">
						<p>Pre&ccedilo Produto:</p>
						<input type="text" id="precoAlterarProduto" class="form-group">
						<p>Adicionar Quantidade:</p>
						<span id="quantidadeAtual"></span>&nbsp+<input type="text"
							id="quantidadeAlterarProduto" class="form-group">
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal"
							onclick="javascript:AQUECE.alterarProduto();">Alterar</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">Fechar</button>
					</center>
				</div>

			</div>

		</div>
	</div>
</form>




<!-- Modal adicionar produto-->
<form id="formLogin">
	<div id="modalLogin" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body">
					<center>
						<p>Usu&aacuterio:</p>
						<input type="text" id="usuario" class="form-group">
						<p>Senha:</p>
						<input type="password" id="senha" class="form-group">
					</center>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal"
							onclick="javascript:AQUECE.login();">Entrar</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">Fechar</button>
					</center>
				</div>

			</div>

		</div>
	</div>
</form>

<!-- Modal adicionar produto-->
<form id="formLogout">
	<div id="modalLogout" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content form-style-4">
				<div class="modal-header">
					<h4 class="modal-title">Logout</h4>
				</div>
				<div class="modal-body">
					<center>
						<label> Deseja Sair?</label>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" onclick="javascript:AQUECE.logout();" data-dismiss="modal">Sim</button>
						<button type="button"
							style="background-color: #576E86; color: white;"
							class="btn btn-default" data-dismiss="modal">N&atildeo</button>
					</center>
				</div>

			</div>

		</div>
	</div>
</form>

</html>
