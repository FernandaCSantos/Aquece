function abrirConsultarMesa(mesa) {
	$("#consultarMesa").show();
	$("#abrirVenda").hide();
	$("#produto").hide();
	$("#funcionario").hide();
	$("#mesa").hide();
	if (mesa.id.split("_")[0] == "ocupada") {
		AQUECE.consultarVendaMesa(mesa.id.split("_")[1]);
	}
	else if (mesa.id.split("_")[0] == "livre") {
		AQUECE.abrirVendaMesa(mesa.id.split("_")[1]);
	}
	$("#mesa_venda").val(mesa.id.split("_")[1]);
	$("#status").val(mesa.id.split("_")[0]);
}
function carregarIniciar() {
	$("#abrirVenda").show();
	AQUECE.consultarSituacaoMesas();
	$("#consultarMesa").hide();
	$("#produto").hide();
	$("#funcionario").hide();
	$("#mesa").hide();
}
function carregarMesa() {
	$("#mesa").show();
	$("#abrirVenda").hide();
	$("#consultarMesa").hide();
	$("#produto").hide();
	$("#funcionario").hide();

}
function voltarIniciarMesas() {
	$("#abrirVenda").show();
	$("#consultarMesa").hide();
	$("#produto").hide();
	$("#funcionario").hide();
	$("#mesa").hide();
}
function carregarConfiguracoes() {
	$("#abrirVenda").hide();
	$("#consultarMesa").hide();
	$("#produto").hide();
	$("#funcionario").hide();
	$("#mesa").hide();
}
function carregarProduto() {
	$("#produto").show();
	$("#abrirVenda").hide();
	$("#consultarMesa").hide();
	$("#funcionario").hide();
	$("#mesa").hide();
}
function carregarFuncionario() {
	$("#funcionario").show();
	$("#abrirVenda").hide();
	$("#consultarMesa").hide();
	$("#produto").hide();
	$("#mesa").hide();
}

$(function() {
	lorem();

	$('#main-navigation a').click(function() {
		openTab($(this));
	});
	$('#partial-navigation a').click(function() {
		$('#partial-navigation a').removeClass('active-tab');
		$(this).addClass('active-tab');
	});

	function openTab(tabLink) {
		$('#main-navigation a').removeClass('active-tab');
		$(tabLink).addClass('active-tab');

		var text = $(tabLink).clone().children().remove().end().text();
		$('#partial-title').text(text);
		arrScKeys = [];
		$('#body').removeClass('showShortcuts');
	}

	/*Shortcuts*/
	var arrScLinks = {};

	$('a[data-nav-shortcut]').each(
			function(i, o) {
				var scKeyAttr = parseInt($(this).attr('data-nav-shortcut'));
				arrScLinks[scKeyAttr] = $(this);

				if (scKeyAttr == 111) {
					$(this).children('.shortcut-info').html('&divide;');
				} else if (scKeyAttr == 106) {
					$(this).children('.shortcut-info').html('*');
				} else if (scKeyAttr == 109) {
					$(this).children('.shortcut-info').html('-');
				} else {
					$(this).children('.shortcut-info').html(
							String.fromCharCode(scKeyAttr));
				}
			});

	var SHIFT_KEY = 16;
	var CTRL_KEY = 17;
	var arrScKeys = [];

	$(document).keydown(
			function(e) {
				if (arrScKeys.length < 2) {
					if (e.keyCode == SHIFT_KEY || e.keyCode == CTRL_KEY) {
						e.stopPropagation();
						arrScKeys.push(e.keyCode);
						if (arrScKeys.length == 2) {
							$('#body').addClass('showShortcuts');
						}
					} else {
						arrScKeys = [];
					}
				} else if (arrScKeys.length == 2
						&& !(e.keyCode == SHIFT_KEY || e.keyCode == CTRL_KEY)) {
					if (arrScLinks[e.keyCode])
						e.stopPropagation();
					if (arrScLinks[e.keyCode])
						openTab(arrScLinks[e.keyCode]);
				}
			});

	$(document).keyup(function(e) {
		arrScKeys = [];
		$('#body').removeClass('showShortcuts');
	});
});

function lorem() {
	var url = 'http://json-lipsum.appspot.com/?amount=20';

	$.ajax({
		type : 'GET',
		url : url,
		async : false,
		jsonpCallback : 'jsonCallback',
		contentType : "application/json",
		dataType : 'jsonp',
		success : function(json) {
			var htmlContent = json.lipsum.join(' ');
			$('#partial-content').html(htmlContent);
		}
	});
}
