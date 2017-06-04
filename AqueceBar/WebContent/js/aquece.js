/**
 * 
 */
$(document).ready(function(){
	AQUECE.init();
});
	
var AQUECE = {
		
		init: function(){
			AQUECE.inicializarTelaVendas();
			AQUECE.logout();
		},

		abrirVendaMesa: function(mesa){
			$("#mesa_span").text("Mesa "+mesa);
			
		},
		
		consultarVendaMesa: function(mesa){
			$("#mesa_span").text("Mesa "+mesa);
			
		},
		
		inicializarTelaVendas: function(){
			$.ajax({ 
				type:     "POST",
				url:      "inicializarTelaVendas.action",
				data:    null,
				dataType: "json",
				success: function(data){
					AQUECE.consultarSituacaoMesas(data);

				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
			
		},
		cadastrarVendas: function(){
			var params = "";
			
			if($("#codVenda_"+$("#mesa_venda").val()).val()  != "" && $("#codVenda_"+$("#mesa_venda").val()).val()  != undefined){
				params = {"vendas.cod":$("#codVenda_"+$("#mesa_venda").val()).val(),
						  "vendas.mesaVO.numeroMesa":$("#mesa_venda").val(),
						  "vendas.produtoVO.cod":$("#codigoProdutoVenda").val(),
						  "vendas.perfilVO.cod":$("#perfil").val(),
						  "vendas.produtoVO.descricao":$("#descricaoProdutoVenda").val(),
						  "vendas.perfilVO.preco":$("#precoProdutoVenda").val(),
						  "vendas.quantidade":$("#quantidadeProdutoVenda").val(),
						  "status":$("#status").val(),
					  
				};
			}else{
				params = {"vendas.mesaVO.numeroMesa":$("#mesa_venda").val(),
						  "vendas.produtoVO.cod":$("#codigoProdutoVenda").val(),
						  "vendas.perfilVO.cod":$("#perfil").val(),
						  "vendas.produtoVO.descricao":$("#descricaoProdutoVenda").val(),
						  "vendas.perfilVO.preco":$("#precoProdutoVenda").val(),
						  "vendas.quantidade":$("#quantidadeProdutoVenda").val(),
						  "status":$("#status").val(),
					  
				};
			}
				
			$.ajax({ 
				type:     "POST",
				url:      "inserirVendas.action",
				data:    params,
				
				success: function(data){
					$("#codVenda_"+$("#mesa_venda").val()).val(data.vendas.cod);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		},
		
		consultarSituacaoMesas: function(lst){
			var html = "";
			$.ajax({ 
				type:     "POST",
				url:      "consultarSituacaoMesa.action",
				data:    null,
				dataType: "json",
				success: function(data){
					$("#abrirVenda").empty();
					for(var i = 0; i < data.listaMesas.length;i++){
						$("#abrirVenda").append("<input type='hidden' id='codVenda_"+data.listaMesas[i].numeroMesa+"'/>");
						for(var j = 0;j < lst.lst.length;j++){
							if(data.listaMesas[i].numeroMesa == lst.lst[j].mesaVO.numeroMesa){
								$("#codVenda_"+data.listaMesas[i].numeroMesa).val(lst.lst[j].cod);
							}
						}
						html += "<input type='hidden' value='";
						html += data.listaMesas[i].numeroMesa +"' id='mesa_"+data.listaMesas[i].numeroMesa+"'>";
						html += "<button style='margin-bottom: 1%; width: 10%; height: 50px; color: white;";

						//						1 == ocupado 0 == livre
						
						if(data.listaMesas[i].situacao == 1){
							html += "background-color: red;' id='ocupada_"+data.listaMesas[i].numeroMesa+"'";	
					
						}else{
							html += "background-color: green;' id='livre_"+data.listaMesas[i].numeroMesa+"'";	
							
						}
					
						html += "type='button' onclick='javascript:abrirConsultarMesa(this);'> Mesa";
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

		cadastrarMesa: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "inserirMesa.action",
				data:    {"mesaVO.numeroMesa":$("#mesaCadastrar").val(),

				},
				
				success: function(data){
					alert("Mesa cadastrada com sucesso.")
					
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

		consultarProdutoVenda: function(){
			
			$.ajax({ 
				type:     "POST",
				url:      "consultarProduto.action",
				data:    {"produtoVO.cod":$("#codigoProdutoVenda").val()},
				success: function(data){
					$("#codigoProdutoVenda").val(data.produtoVO.cod);
					$("#descricaoProdutoVenda").val(data.produtoVO.desc);
					$("#precoProdutoVenda").val(data.produtoVO.preco);
					$("#valorProduto").val(data.produtoVO.preco);
//					$("#quantidadeAtual").text(data.produtoVO.quantidade);
					
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		alterarProduto: function(){
			var atual = $("#quantidadeAtual").text();
			var qt = $("#quantidadeAlterarProduto").val();
			if( atual == null || atual == "" || atual == undefined || atual < 1){
				atual = 0;
			}
			
			if( qt == null || qt == "" || qt == undefined || qt < 1){
				qt = 0;
			}
			
			var total = parseInt(atual)+parseInt(qt);

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
	
//		
//		alterarPerfil: function(){
//			var total = parseInt($("#quantidadeAlterarProduto").val()) + parseInt($("#quantidadeAtual").text());
//
//			$.ajax({ 
//				type:     "POST",
//				url:      "alterarPerfil.action",
//				data:  {"perfilVO.cod":$("#codigoAlterarPerfil").val(),
//					  "perfilVO.desc":$("#descricaoAlterarPerfil").val(),
//					  "perfilVO.preco":$("#precoAlterarPerfil").val(),
//					  "perfilVO.quantidade":total
//			
//			},
//				success: function(data){
////					$("#codigoAlterarPerfil").val(data.produtoVO.cod);
////					$("#descricaoAlterarPerfil").val(data.produtoVO.desc);
////					$("#precoAlterarPerfil").val(data.produtoVO.preco);
////					$("#quantidadeAlterarPerfil").val(data.produtoVO.quantidade);
//					
//				},error: function(data){
//					alert("Ocorreu um erro interno.");
//				}
//			});
//		
//		},
		
	
		
		login: function(){

			$.ajax({ 
				type:     "POST",
				url:      "login.action",
				data:  {"perfilVO.user":$("#usuario").val(),
					  "perfilVO.password":$("#senha").val()
			
			},
				success: function(data){
					if(data.perfilVO.cod != "" && data.perfilVO.cod != null && data.perfilVO.cod != undefined){
					$("#codigoPerfilHidden").val(data.perfilVO.cod);
					$("#nomePerfilHidden").val(data.perfilVO.nomePerfil);
					$("#perfil_adm").show();
					$("#user-info").text(data.perfilVO.nomePerfil);
					$("#user-info").append("<a class='entypo-logout' " +
							"alt='' data-toggle='modal' " +
							"id='login' data-target='#modalLogout' title=''></a>");
					}else{
						alert("Usu\u00e1rio ou senha inv\u00e1lidos.");
					}
				},error: function(data){
					alert("Ocorreu um erro interno.");
				}
			});
		
		},
		
		logout: function(){
					$("#codigoPerfilHidden").val("");
					$("#nomePerfilHidden").val("");
					$("#perfil_adm").hide();
					$("#user-info").text("Login");
					$("#user-info").append("<a class='entypo-logout' " +
							"alt='' data-toggle='modal' " +
							"id='login' data-target='#modalLogin' title=''></a>");
		},
		
		resetarFormulario: function(form){
			form.reset();
			$("#quantidadeAtual").text("");
		},
		
		alterarQuantidade: function(){
			
			var quantidade = $("#quantidadeProdutoVenda").val();

			if(quantidade < 1 || quantidade == undefined || quantidade == ""){
				quantidade = 0;
			}
			var produto = $("#valorProduto").val();
			var total = parseInt(produto) * parseInt(quantidade);
			$("#subtotalPrecoProdutoVenda").val(total);
			
		},
		
}