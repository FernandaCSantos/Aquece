/**
 * 
 */
$(document).ready(function(){
	AQUECE.init();
});
	
var AQUECE = {
		
		init: function(){
			AQUECE.consultarSituacaoMesas();
			
		},
		
		consultarSituacaoMesas: function(){
			var html = "";
			$.ajax({ 
				type:     "POST",
				url:      "consultarSituacaoMesa.action",
				data:    null,
				dataType: "json",
				success: function(data){
					$("#abrirVenda").empty();
					for(var i = 0; i < data.listaMesas.length;i++){
						html += "<button style='margin-bottom: 1%; width: 10%; height: 50px; color: white;";

						//						1 == ocupado 0 == livre
						
						if(data.listaMesas[i].situacao == 1){
							html += "background-color: red;'";	
					
						}else{
							html += "background-color: green;'";	
							
						}
					
						html += "type='button' onclick='javascript:abrirConsultarMesa();AQUECE.consultarSituacaoMesas();'> Mesa";
						html += data.listaMesas[i].numeroMesa+"<span class='glyphicon glyphicon-glass' aria-hidden='true' style='color: white;'></span></button>&nbsp"
					}
					$("#abrirVenda").append(html);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		},
		
		cadastrarProduto: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "inserirProduto.action",
				data:    {"produtoVO.cod":$("#codigoCadastrarProduto").val(),
						  "produtoVO.desc":$("#descricaoCadastrarProduto").val(),
						  "produtoVO.preco":$("#precoCadastrarProduto").val(),
						  "produtoVO.quantidade":$("#quantidadeCadastrarProduto").val()
				
				},
				
				success: function(data){
					
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		},
		
		consultarProduto: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "consultarProduto.action",
				data:    {"produtoVO.cod":$("#codigoAlterarProduto").val()},
				success: function(data){
					$("#codigoAlterarProduto").val(data.produtoVO.cod);
					$("#descricaoAlterarProduto").val(data.produtoVO.desc);
					$("#precoAlterarProduto").val(data.produtoVO.preco);
					$("#quantidadeAtual").text(data.produtoVO.quantidade);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		
		alterarProduto: function(){
			var total = parseInt($("#quantidadeAlterarProduto").val()) + parseInt($("#quantidadeAtual").text());

			$.ajax({ 
				type:     "POST",
				url:      "alterarProduto.action",
				data:  {"produtoVO.cod":$("#codigoAlterarProduto").val(),
					  "produtoVO.desc":$("#descricaoAlterarProduto").val(),
					  "produtoVO.preco":$("#precoAlterarProduto").val(),
					  "produtoVO.quantidade":total
			
			},
				success: function(data){
					$("#codigoAlterarProduto").val(data.produtoVO.cod);
					$("#descricaoAlterarProduto").val(data.produtoVO.desc);
					$("#precoAlterarProduto").val(data.produtoVO.preco);
					$("#quantidadeAlterarProduto").val(data.produtoVO.quantidade);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		
	cadastrarPerfil: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "inserirPerfil.action",
				data:    {"perfilVO.nomePerfil":$("#nomeCadastrarPerfil").val(),
						  "perfilVO.user":$("#usuarioCadastrarPerfil").val()
				},
				
				success: function(data){
					
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		},
		
		consultarPerfil: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "consultarPerfil.action",
				data:    {"produtoVO.cod":$("#codigoAlterarProduto").val()},
				success: function(data){
					$("#codigoAlterarProduto").val(data.produtoVO.cod);
					$("#descricaoAlterarProduto").val(data.produtoVO.desc);
					$("#precoAlterarProduto").val(data.produtoVO.preco);
					$("#quantidadeAtual").text(data.produtoVO.quantidade);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		
		alterarPerfil: function(){
			var total = parseInt($("#quantidadeAlterarProduto").val()) + parseInt($("#quantidadeAtual").text());

			$.ajax({ 
				type:     "POST",
				url:      "alterarPerfil.action",
				data:  {"perfilVO.cod":$("#codigoAlterarProduto").val(),
					  "perfilVO.desc":$("#descricaoAlterarProduto").val(),
					  "perfilVO.preco":$("#precoAlterarProduto").val(),
					  "perfilVO.quantidade":total
			
			},
				success: function(data){
					$("#codigoAlterarProduto").val(data.produtoVO.cod);
					$("#descricaoAlterarProduto").val(data.produtoVO.desc);
					$("#precoAlterarProduto").val(data.produtoVO.preco);
					$("#quantidadeAlterarProduto").val(data.produtoVO.quantidade);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		resetarFormulario: function(form){
			form.reset();
			$("#quantidadeAtual").text("");
		},
		
}