<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page buffer="64kb" autoFlush="false" %>


      
	<%@page import="data.UsuarioDO" %>
        <%@page import="utils.*" %>
        <%@page import="transacoes.Usuario" %>
        <%@page import="java.util.*" %>
        <%@page import="java.sql.Time" %>
        <%@page import="java.text.*" %>
        
       

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>CaronUSP - O maior site de caronas do Brasil!</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
      
    <div class="navbar-default" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CaronUSP</a>
        </div>
        <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control" name="email" required autofocus>
            </div>
            <div class="form-group">
              <input type="password" placeholder="Senha" class="form-control" name="senha" required>
            </div>&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-success btn-sm">Login</button>&nbsp;&nbsp;&nbsp;
            <input type="hidden" name="campo_controle_recup">
            <div class="navbar-right"><a href="javascript:window.open('./recuperarSenha.jsp','Recuperar Senha', 'width=400,height=500,scrollbars=yes'); void(0)" style="color: white">Esqueci minha senha</a><br><a href="teste.html">Esqueci minha senha</a></div>
            <div class="navbar-right" style="width:150px"><font id="alerta" size="2" color="red">
            
        
         <%
            if (request.getParameter("campo_controle_recup") != null) {
                // processa login
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                int atpos = email.indexOf("@");
                int dotpos = email.lastIndexOf(".");
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length()) {
                    %> Endereço de e-mail não é válido. <%
                } else {
                    Usuario user = new Usuario();

                    if (user.verificarLogin(email, senha)) {
                        session.setAttribute("user_name", email);
                        pageContext.forward("main.jsp");
                    } else {
                            %>Usuário e/ou senha inválidos! <%

                    }
                }
            }
        
    %>
    </font></div>   
        </form>
            
            
            
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    
    
  
    
    

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        
          <form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="nome" class="col-sm-2 control-label">Nome completo:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="nome" name="nome">
    </div>
  </div>
  <div class="form-group">
    <label for="cpf" class="col-sm-2 control-label">CPF</label>
    <div class="col-sm-10">
        <input type="texr" class="form-control" id="cpf" name="cpf">
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="email">
    </div>
  </div>
              
  <div class="form-group">
    <label for="confemail" class="col-sm-2 control-label">Confirme Email</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="confemail" name="confemail">
    </div>
  </div>
              
  <div class="form-group">
    <label for="senha" class="col-sm-2 control-label">Senha</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="senha" name="senha">
    </div>
  </div>
              
 <div class="form-group">
    <label for="confsenha" class="col-sm-2 control-label">Confirme a senha</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="confsenha" name="confsenha">
    </div>
  </div>
     
  <div class="form-group">
    <label for="cep" class="col-sm-2 control-label">CEP</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="cep" name="cep">
    </div>
  </div>
              
  <div class="form-group">
    <label for="endereco" class="col-sm-2 control-label">Endereço</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="endereco" name="endereco">
    </div>
  </div>            
  
  <div class="form-group">
    <label for="numerocasa" class="col-sm-2 control-label">Nº</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="numeroasa" name="numerocasa">
    </div>
  </div>
              
  <div class="form-group">
    <label for="complemento" class="col-sm-2 control-label">Complemento</label>
    <div class="col-sm-10" style="width:300px">
        <input type="text" class="form-control" id="complemento" name="complemento">
    </div>
  </div> 
              
  <div class="form-group">
    <label for="telefone" class="col-sm-2 control-label">Telefone</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="telefone" name="telefone">
    </div>
  </div>   
              
  <div class="form-group">
    <label for="tipo" class="col-sm-2 control-label">Tipo</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="tipo" name="tipo">
    </div>
  </div>    
   
  <div class="form-group">
    <label for="sexo" class="col-sm-2 control-label">Sexo</label>
    <div class="col-sm-10">
        <select class="form-control" id="sexo" name="sexo">
        <option value="M">Masculino</option>
        <option value="F">Feminino</option>
    </select>
    </div>
  </div>   
              
   <div class="form-group">
    <label for="dataNascimento" class="col-sm-2 control-label">Data de Nascimento</label>
    <div class="col-sm-10">
        
        <select id="diaNascimento" class="form-control" name="diaNascimento">
<option value="na">Dia</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>

<select id="mesNascimento" class="form-control" name="mesNascimento">
<option value="na">Month</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>


<select id="anoNascimento" class="form-control" name="anoNascimento">
<option value="na">Year</option>
<option value="2009">2009</option>
<option value="2008">2008</option>
<option value="2007">2007</option>
<option value="2006">2006</option>
<option value="2005">2005</option>
<option value="2004">2004</option>
<option value="2003">2003</option>
<option value="2002">2002</option>
<option value="2001">2001</option>
<option value="2000">2000</option>
<option value="1999">1999</option>
<option value="1998">1998</option>
<option value="1997">1997</option>
<option value="1996">1996</option>
<option value="1995">1995</option>
<option value="1994">1994</option>
<option value="1993">1993</option>
<option value="1992">1992</option>
<option value="1991">1991</option>
<option value="1990">1990</option>
<option value="1989">1989</option>
<option value="1988">1988</option>
<option value="1987">1987</option>
<option value="1986">1986</option>
<option value="1985">1985</option>
<option value="1984">1984</option>
<option value="1983">1983</option>
<option value="1982">1982</option>
<option value="1981">1981</option>
<option value="1980">1980</option>
<option value="1979">1979</option>
<option value="1978">1978</option>
<option value="1977">1977</option>
<option value="1976">1976</option>
<option value="1975">1975</option>
<option value="1974">1974</option>
<option value="1973">1973</option>
<option value="1972">1972</option>
<option value="1971">1971</option>
<option value="1970">1970</option>
<option value="1969">1969</option>
<option value="1968">1968</option>
<option value="1967">1967</option>
<option value="1966">1966</option>
<option value="1965">1965</option>
<option value="1964">1964</option>
<option value="1963">1963</option>
<option value="1962">1962</option>
<option value="1961">1961</option>
<option value="1960">1960</option>
<option value="1959">1959</option>
<option value="1958">1958</option>
<option value="1957">1957</option>
<option value="1956">1956</option>
<option value="1955">1955</option>
<option value="1954">1954</option>
<option value="1953">1953</option>
<option value="1952">1952</option>
<option value="1951">1951</option>
<option value="1950">1950</option>
<option value="1949">1949</option>
<option value="1948">1948</option>
<option value="1947">1947</option>
<option value="1946">1946</option>
<option value="1945">1945</option>
<option value="1944">1944</option>
<option value="1943">1943</option>
<option value="1942">1942</option>
<option value="1941">1941</option>
<option value="1940">1940</option>
<option value="1939">1939</option>
<option value="1938">1938</option>
<option value="1937">1937</option>
<option value="1936">1936</option>
<option value="1935">1935</option>
<option value="1934">1934</option>
<option value="1933">1933</option>
<option value="1932">1932</option>
<option value="1931">1931</option>
<option value="1930">1930</option>
<option value="1929">1929</option>
<option value="1928">1928</option>
<option value="1927">1927</option>
<option value="1926">1926</option>
<option value="1925">1925</option>
<option value="1924">1924</option>
<option value="1923">1923</option>
<option value="1922">1922</option>
<option value="1921">1921</option>
<option value="1920">1920</option>
<option value="1919">1919</option>
<option value="1918">1918</option>
<option value="1917">1917</option>
<option value="1916">1916</option>
<option value="1915">1915</option>
<option value="1914">1914</option>
<option value="1913">1913</option>
<option value="1912">1912</option>
<option value="1911">1911</option>
<option value="1910">1910</option>
<option value="1909">1909</option>
</select>
             
        
        </div>
  </div>  
              
   <div class="form-group">
    <label for="profissao" class="col-sm-2 control-label">Profissão</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="profissao" name="profissao">
    </div>
  </div> 
   
   <div class="form-group">
    <label for="entidade" class="col-sm-2 control-label">Entidade</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="entidade" name="entidade">
    </div>
  </div>             
              
              
              
              
              
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
              
              <input type="hidden" name="campo_controle" />
              
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" name="confirmar" class="btn btn-default">Cadastrar</button>
    </div>
  </div>
</form>
          <p><font id="alerta" color="red">
          
          
          
          
           <% 
           
           
           ArrayList<String> irregularFields = new ArrayList<String>();
           
           if((request.getParameter("confirmar") != null)||(request.getParameter("campo_controle")!= null)){
               String nome = request.getParameter("nome");
               String cpf = request.getParameter("cpf");
               String email = request.getParameter("email");
               String confemail = request.getParameter("confemail");
               String senha = request.getParameter("confsenha");
               String confsenha = request.getParameter("confsenha");
               String cep = request.getParameter("cep");
               String endereco = request.getParameter("endereco");
               String numerocasa = request.getParameter("numerocasa");
               String complemento = request.getParameter("complemento");
               String telefone = request.getParameter("telefone");
               String tipo = request.getParameter("tipo");
               String sexo = request.getParameter("sexo");
               String diaNascimento = request.getParameter("diaNascimento");
               String mesNascimento = request.getParameter("mesNascimento");
               String anoNascimento = request.getParameter("anoNascimento");
               String profissao = request.getParameter("profissao");
               String entidade = request.getParameter("entidade");
            
            if(!email.equals(confemail)){
            %>
            Por favor, confirme o e-mail corretamente
            <%
            }
            if (!senha.equals(confsenha)) {
            %>
                Por favor, confirme a senha corretamente
            <%
            }
            if (nome == "") {
                
                irregularFields.add("'nome'");
                
                               }
             if (cpf == "") {
                
                irregularFields.add("'cpf'");
                
                               }
               
           if (email == "") {
                
                irregularFields.add("'email'");
                
                               }
               
           if (senha == "") {
                
                irregularFields.add("'senha'");
                
                               }
          if (cep == "") {
                
                irregularFields.add("'cep'");
                
                               }
           if (endereco == "") {
                
                irregularFields.add("'endereco'");
                
                               }
               
              if (numerocasa == "") {
                
                irregularFields.add("'numerocasa'");
                
                               }
               
              if (complemento == "") {
                
                irregularFields.add("'complemento'");
                
                               }
               
               if (telefone == "") {
                
                irregularFields.add("'telefone'");
                
                               }
               if (tipo == "") {
                
                irregularFields.add("'tipo'");
                
                               }
              if (sexo == "") {
                
                irregularFields.add("'sexo'");
                
                               }
              if (diaNascimento == "") {
                
                irregularFields.add("'diaNascimento'");
                
                               }
              if (mesNascimento == "") {
                
                irregularFields.add("'mesNascimento'");
                
                               }
              if (anoNascimento == "") {
                
                irregularFields.add("'anoNascimento'");
                
                               }
               if (profissao == "") {
                
                irregularFields.add("'profissao'");
                
                               }
               if (entidade == "") {
                
                irregularFields.add("'entidade'");
                
                               }  
            %>
                
                
                
                
                <%
                
           if (irregularFields.size() != 0) { 
               for (int i=0; i < irregularFields.size(); i++) {
                   String field = irregularFields.get(i);
%>
           O campo <%= field %> é obrigatório e não foi preenchido.<br>
           
           <%

                     }
                             }
           
                else{
                                   
                    
                   UsuarioDO usuario = new UsuarioDO();
                    
                    
                    usuario.setNome(nome);
                    usuario.setCPF(Integer.parseInt(cpf));
                    usuario.setEmail(email);
                    usuario.setRua(endereco);
                    usuario.setSenha(senha);
                    usuario.setCEP(cep);
                    usuario.setNcasa(Integer.parseInt(numerocasa));
                    usuario.setComplemento(complemento);
                    usuario.setTelefone(Integer.parseInt(telefone));
                    
                    usuario.setProfissao(profissao);
                    usuario.setEntidade(entidade);
                    
                    StringBuilder str = new StringBuilder();
                    str.append(diaNascimento);
                    str.append("/");
                    str.append(mesNascimento);
                    str.append("/");
                    str.append(anoNascimento);
                    
                    
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
                    Date nascimento = (Date)formatter.parse(str.toString());
                    
                    java.sql.Date sqlNascimento = new java.sql.Date(nascimento.getTime());
                    usuario.setDatanascimento(sqlNascimento);
                    
                    usuario.setTipo(tipo);
                    usuario.setSexo(sexo);
                    
                    
                    transacoes.Usuario tr = new transacoes.Usuario();
                    tr.incluir(usuario);
                    
                    session.setAttribute("user_name", email);
                    response.sendRedirect("./main.jsp");
                    
		} 
                
              
	   }	
	%>
          
        </font></p>
      
      
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->

      <hr>

      <footer>
        <p>&copy; Company 2013</p>
      </footer>
  </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    
  </body>
</html>
