
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
        <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
        <!-- Bootstrap Core CSS -->
        <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Menu CSS -->
        <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
        <!-- toast CSS -->
        <link href="plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
        <!-- morris CSS -->
        <link href="plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
        <!-- chartist CSS -->
        <link href="plugins/bower_components/chartist-js/dist/chartist.min.css" rel="stylesheet">
        <link href="plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
        <!-- animation CSS -->
        <link href="css/animate.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/style.css" rel="stylesheet">
        <!-- color CSS -->
        <link href="css/colors/default.css" id="theme" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


        <script>

            function funcSenha() {
                var senha = form1.senha.value;
                var rep_senha = form1.rep_senha.value;


                if (senha === "") {

                    alert('Preencha o campo senha');
                    form1.senha.focus();
                    return false;
                }

                if (senha !== rep_senha) {
                    alert('Senhas diferentes');
                    form1.senha.focus();
                    return false;
                }


            }


        </script>


    </head>

    <body class="fix-header">
        <!-- ============================================================== -->
        <!-- Preloader -->
        <!-- ============================================================== -->
        <div class="preloader">
            <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
            </svg>
        </div>
        <!-- ============================================================== -->
        <!-- Wrapper -->
        <!-- ============================================================== -->
        <div id="wrapper">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
          
            
            <!--inicio Header-->
            <%@ include file = "header.jsp" %>
            <!--fim Header-->
            
            <!-- End Top Navigation -->
            <!-- ============================================================== -->
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            
            
             <!--inicio Menu da esquerda-->
            <%@ include file = "MenuEsquerdo.jsp" %>
            <!--fim Menu da esquerda-->
            
            
            <!-- ============================================================== -->
            <!-- End Left Sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page Content -->
            <!-- ============================================================== -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Dashboard</h4> </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <ol class="breadcrumb">
                                <li><a href="#">Dashboard</a></li>
                            </ol>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    
                                     
                    
                    <!--inicio Conteúdo-->

                    
                    <div class="wrapper fadeInDown">
                        <div id="formContent">
                            <!-- Tabs Titles -->

                            <!-- Icon -->
                            <div class="fadeIn first">
                                <i class="fa fa-laptop fa-fw" aria-hidden="true"></i>
                            </div>
                            
                            <div>
                                <labe><h1>Criar uma conta</h1> <h6>ou fazer <a href="login.jsp"> login</a></h6></label>
                            </div>

                            <!-- Login Form -->
                            <form method="POST" id="form1" name="form1">
                                <input type="text" id="login" class="fadeIn second" name="login" placeholder="Username">
                                <input type="text" id="email" class="fadeIn second" name="email" placeholder="E-mail">
                                <input type="text" id="myInput" class="fadeIn third" minlength="8" maxlength="12" name="senha" placeholder="Senha">
                                <input type="text" id="myInput" class="fadeIn third"minlength="8" maxlength="12" name="rep_senha" placeholder="Confirmar Senha">

                                <input type="submit" class="fadeIn fourth" onclick="return funcSenha()" value="Cadastrar">
                            </form>

                        </div>
                    </div>


                </div>
                
                                 
                    
                    <!--fim Conteúdo-->

                    
                
                               <!-- /.container-fluid -->
                <footer class="footer text-center"> 2019 &copy; Sys-Vendas </footer>
            </div>
            <!-- ============================================================== -->
            <!-- End Page Content -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- Menu Plugin JavaScript -->
        <script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
        <!--slimscroll JavaScript -->
        <script src="js/jquery.slimscroll.js"></script>
        <!--Wave Effects -->
        <script src="js/waves.js"></script>
        <!--Counter js -->
        <script src="plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
        <script src="plugins/bower_components/counterup/jquery.counterup.min.js"></script>
        <!-- chartist chart -->
        <script src="plugins/bower_components/chartist-js/dist/chartist.min.js"></script>
        <script src="plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
        <!-- Sparkline chart JavaScript -->
        <script src="plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
        <!-- Custom Theme JavaScript -->
        <script src="js/custom.min.js"></script>
        <script src="js/dashboard1.js"></script>
        <script src="plugins/bower_components/toast-master/js/jquery.toast.js"></script>
    </body>

</html>

