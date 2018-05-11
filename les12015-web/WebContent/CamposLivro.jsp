<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtTitulo" class="form-control" type="text" placeholder="Título">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<select id= "slc-autor" class="form-control">
								<option value="" disabled selected>Autores</option>
								
								<!-- Implementar JSP que inclui autores -->
								<option  value="1">J. K. Rolling </option> 
								<option  value="2">Stephen king</option> 
							</select>
							<BUTTON id="btn-adicionarA" style="display: inline-block; width:168px; margin-top:15px;  " 
							class="btn btn-primary btn-sm" onclick="adicionarAutor(event)" > Adicionar Autor</button>
							
							<BUTTON id="btn-removerA" style="display: inline-block; width:170px; margin-top:15px; " 
							class="btn btn-primary btn-sm" onclick="removerAutor(event)" > Remover Todos</button>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<div class>
								<textarea id = "txtAreaAutor" class="form-control" style=" width:345px; height: 88px;
								 margin-TOP:0px;" disabled></textarea>
							</div>
						</div>
					</div>

				</div>
				
					
				
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<textarea id = "txtSinopse" class="form-control"  rows="3" placeholder="Sinopse"></textarea>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<select id= "slc-categoria" class="form-control">
								<option value="" disabled selected>Categoria</option>
										<!-- Implementar JSP que inclui Categorias -->
										<option  value="1">Romance </option> 
							</select>
							<BUTTON id="btn-adicionarC" style="display: inline-block; width:168px; margin-top:15px; " 
							class="btn btn-primary btn-sm" onclick="adicionarCategoria(event)" > Adicionar Categoria</button>
							
							<BUTTON id="btn-removerC" style="display: inline-block; width:170px; margin-top:15px; " 
							class="btn btn-primary btn-sm" onclick="removerCategoria(event)" > Remover Todos </button>
						</div>
					</div>
	
					<div class="col-md-4">
						<div class="form-group">
							
								<textarea id= "txtAreaCategoria" class="form-control" style=" width:345px; height: 88px;
								 margin-TOP:0px;" disabled></textarea>
						
						</div>
					</div>
				</div>
				
		
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<select class="form-control">
								<option value="" disabled selected>Editora</option>
								<!-- Implementar JSP que inclui autores -->
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtEdicao" class="form-control" type="text" placeholder="Edição">
						</div>
					</div>
	
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtAno" class="form-control" type="text" placeholder="Ano de Publicação">
						</div>
					</div>
				</div>
				
				
				
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<input  id = "txtIsbn" class="form-control" type="text" placeholder="ISBN">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtNumPag" class="form-control" type="text" placeholder="Número de Páginas">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<select class="form-control">
								<option value="" disabled selected>Precificação</option>
								<!-- Implementar JSP que inclui autores -->
							</select>
						</div>
					</div>
				</div>
				
				
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtProfundidade" class="form-control" type="text" placeholder="Profundidade (cm)">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtPreco" class="form-control" type="text" placeholder="Preço R$">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtCodBarras" class="form-control" type="text" placeholder="Código de Barras">
						</div>
					</div>
				</div>
				
				
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtPesoo" class="form-control" type="text" placeholder="Peso (g)">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtAltura" class="form-control" type="text" placeholder="Altura (cm)">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtLargura" class="form-control" type="text" placeholder="Largura (cm)">
						</div>
					</div>
				</div>
				
				
				
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<input id = "txtCusto" class="form-control" type="text" placeholder="Custo R$">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input  id = "txtQtdeVenda" class="form-control" type="text" placeholder="Qtde Obg Venda">
						</div>
					</div>

					<div class="col-md-4">
						
					</div>
				</div>
				
	
</body>
</html>

<script>
			var arrayAut = [];
			var arrayCat= [];
			function adicionarAutor(event){
				event.preventDefault();
				var idAutorSelecionado = $("#slc-autor").val();
				if(idAutorSelecionado == 0){
				  alert("escolha um autor para adicionar");
				  return;
				}
				arrayAut.push($("#slc-autor").val());	
				var autores = $("#txtAreaAutor").val();		
				autores += $('#slc-autor option:selected').text() + "\n";
				$("#txtAreaAutor").text(autores);	
				
			}	
			function removerAutor(event){ 
				event.preventDefault();
				$("#txtAreaAutor").text(''); 	
				arrayAut = [];
			}
			//Fazer as msm funções para Categoria
			
			function adicionarCategoria(event){
				event.preventDefault();
				var idCatSelecionado = $("#slc-categoria").val();
				if(idCatSelecionado == 0){
				  alert("escolha uma categoria para adicionar");
				  return;
				}
				arrayCat.push($("#slc-categoria").val());	
				var categorias = $("#txtAreaCategoria").val();		
				categorias += $('#slc-categoria option:selected').text() + "\n";
				$("#txtAreaCategoria").text(categorias);	
				
			}	
			function removerCategoria(event){ 
				event.preventDefault();
				$("#txtAreaCategoria").text('');
				arrayCat = [];
			}
	</script>