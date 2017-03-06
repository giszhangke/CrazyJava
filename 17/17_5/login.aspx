

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
	昆山市规划综合信息平�?
</title><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><meta name="Description" content="昆山市规划综合信息平�?" /><meta name="Keywords" content="平台" /><meta name="Page-topic" content="昆山市规划综合信息平�?" /><meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    
    <!-- bootstrap & fontawesome -->
	    <link rel="stylesheet" href="ace/css/bootstrap.min.css" /><link rel="stylesheet" href="ace/css/font-awesome.min.css" />
    <!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="ace/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="ace/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="ace/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="ace/css/ace-skins.min.css" /><link rel="stylesheet" href="ace/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="ace/css/ace-ie.min.css" />
		<![endif]-->
        
        <!--dist style-->
        <link rel="stylesheet" href="ace/css/dist-2.0.sp.css" />
    <!--[if !IE]> -->
		<script type="text/javascript">
		    window.jQuery || document.write("<script type='text/javascript' src='ace/js/jquery.min.js'>" + "<" + "/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script type='text/javascript' src='ace/js/jquery1x.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
        <!-- dist scripts -->
        <script type="text/javascript" src="ace/js/dist-2.0.sp.js"></script>
        <script type="text/javascript" src="msg/msg.js"></script>
    <script type="text/javascript" language="javascript">
        function Convert()
        {
            try{
                var val = $('#autoActionField').attr("value");
                var evl = eval("(" + val + ")");
                if (evl.fromSys == "distIM") {
                    setTimeout(function () {
                        openTab(evl.model, evl.boxname, evl.type, evl.param, false);
                    }, 2000);
                }
            }catch(error){}
        }       
    </script>
<link href="CssHandler.ashx?t=GreenBlue&f=StyleSheet.css&v=" type="text/css" rel="stylesheet" /></head>
<body class="no-skin">
        <object id="DistMap" name="DistMap" style="left: 0px; width: 0px; top: 0px; height: 0px"
            classid="clsid:D9CEC0A9-0C7F-47D9-AF6A-FC4E64FC8A33">
        </object>
    <!-- #section:basics/navbar.layout -->
		
<div id="navbar" class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-container" id="navbar-container">
	    <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
		    <span class="sr-only">切换侧边�?</span>

		    <span class="icon-bar"></span>

		    <span class="icon-bar"></span>

		    <span class="icon-bar"></span>
	    </button>

	    <div class="navbar-header pull-left">
		    <img src="images/portal/logo.png" class="leftToplogo" title="首页" onclick="openHome()" />
	    </div>

	    <div class="navbar-buttons navbar-header pull-right" role="navigation">
		    <ul class="nav ace-nav dist-nav">
			    <li class="dropdown">
				    <a data-toggle="dropdown" class="dropdown-toggle dist-dropdown-toggle" href="#" onclick="showUserset()">
					    <img src="images/portal/user2.png" id="header_imgNavUser" class="imgNav" title="用户" />
                        <br/><span id="header_spanUser" class="spanUser"></span>
				    </a>
			    </li>

			    

			    <li class="dropdown">
				    <a data-toggle="dropdown" class="dropdown-toggle dist-dropdown-toggle" href="#">
					    <img id="imgNavProcess" class="imgNav" src="images/portal/process2.png" title="待办事项" onclick="switchIframe('#processFrame','','代办事项','')"/>
				        <br/><span class="spanUser">待办事项</span>
                    </a>
			    </li>

			    <li class="dropdown">
				    <a data-toggle="dropdown" class="dropdown-toggle dist-dropdown-toggle" href="#">
					    <img id="imgNavHelp" class="imgNav" src="images/portal/help2.png" title="帮助" onclick="javascript:window.open('Help/Help.html');" />
				        <br/><span class="spanUser">帮助</span>
                    </a>
			    </li>

			    <li class="dropdown">
				    <a data-toggle="dropdown" class="dropdown-toggle dist-dropdown-toggle" href="#">
					    <img id="imgSetting" class="imgNav" src="images/portal/setting2.png" title="设置" onclick="setting()" />
				        <br/><span class="spanUser">设置</span>
                    </a>
			    </li>

			    <li class="dropdown">
				    <a data-toggle="dropdown" class="dropdown-toggle dist-dropdown-toggle" href="#">
					    <img id="imgNavLogout" class="imgNav" src="images/portal/logout2.png" title="�?�?" onclick="logout()" />
				        <br/><span class="spanUser">�?�?</span>
                    </a>
			    </li>

		    </ul>
	    </div>
    </div>
</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container dist-main-container" id="main-container">

			<!-- #section:basics/sidebar -->
			
<div id="sidebar" class="sidebar responsive sidebar-fixed">
	<ul class="nav nav-list dist-nav-list">
        <script type="text/javascript">
            ajaxSnyc('.dist-nav-list', "Service/PortalService.asmx/loadNavigator", '', null, null, completeFun);

            function completeFun() {
                //�?求要求在内网访问时不显示�?张图菜单，此处根据客户端访问的地�?判断是否通过内网访问
                if (window.location.host.indexOf("61.155.216.5") < 0) {
                    $("#aMap").css("display", "none");
                }
                refreshEaccept("#预审�?");
                refreshProject("#在办�?", "0");
                refreshProject("#在办公示公告", "2");
                refreshProject("#合同在办�?", "3");
                refreshReview("#评审收件�?");
                window.setInterval(refreshAllProjectOntime, 300000);
            }
            function refreshAllProjectOntime() {
                refreshEaccept("#预审�?");
                refreshProject("#在办�?", "0");
                refreshProject("#在办公示公告", "2");
                refreshProject("#合同在办�?", "3");
                refreshReview("#评审收件�?");
            }
        </script>
	</ul><!-- /.nav-list -->

	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse dist-sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-control" class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="page-content">
					<!--setting 加设置页�?-->
                    
<div class="ace-settings-container dist-settings-container" style="padding-bottom:20px;" id="ace-settings-container">
    

    <div class="ace-settings-box clearfix" id="ace-settings-box" style="padding-bottom:20px;">
	    <div class="pull-left width-100">
		    

            <!-- #section:settings.sortable -->
		    <div class="ace-settings-item">
			    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sortable" />
			    <label class="lbl" for="ace-settings-sortable"> 调整栏目顺序 </label>
		    </div>
		    <!-- /section:settings.sortable -->

		    <!-- #section:settings.widget.index -->
            <div class="ace-settings-item">
			    <input type="button" class="btn btn-info" id="ace-settings-widget-index" value="保存栏目排序"/>
		    </div>
		    <!-- /section:settings.widget.index -->
	    </div><!-- /.pull-left -->
        <script type="text/javascript">
            $('#ace-settings-sortable').bind('click', function () {
                if ($('#ace-settings-sortable').is(':checked')) {
                    window.frames["homeFrame"].bindSortable();
                } else {
                    window.frames["homeFrame"].unbindSortable();
                }
            });
            $('#ace-settings-widget-index').bind('click', function () {
                window.frames["homeFrame"].saveSortWidget();
            });
        </script>
    </div><!-- /.ace-settings-box -->
</div>
					
<div class="page-content-area">
    <iframe id="homeFrame" name="homeFrame" class="dist-iframe" src="portalengine/mainpage.aspx"></iframe>
    <iframe id="searchFrame" name="searchFrame" class="dist-iframe" src="portalengine/360SearchPage.aspx"></iframe>
    <iframe id="processFrame" name="processFrame" class="dist-iframe" src="portalengine/processingview.html"></iframe>
    <iframe id="newFrame" name="newFrame" class="dist-iframe" src="PortalEngine/MoveNewPage.aspx"></iframe>
    <iframe id="flexFrame" name="flexFrame" class="dist-iframe" src="Engine/main.html"></iframe>
    <iframe id="contentFrame" name="contentFrame" class="dist-iframe"></iframe>
</div>
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
            <div id="user" style="display:none;" >0</div>
            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse dist-scroll-up">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>

		</div><!-- /.main-container -->
        
        
<div class="footer">
	<div class="footer-inner">
		<!-- #section:basics/footer -->
		<div class="footer-content">
			xxx规划管理系统 ®2013-2020 [�?术支持]上海数慧系统�?术有限公�? 
		</div>
		<!-- /section:basics/footer -->
	</div>
</div>
        <form name="defaultForm" method="post" action="default.aspx" id="defaultForm">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTc2NDcxMjUzNGRkIVmpAG/U/rqp3mpq4zcumGhMLR4=" />

<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="83B8AA4C" />
            <input type="hidden" name="autoActionField" id="autoActionField" />
        </form>
    <!-- basic scripts -->
        
		<script type="text/javascript">
		    if ('ontouchstart' in document.documentElement) document.write("<script type='text/javascript' src='ace/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
		</script>
		<script type="text/javascript" src="ace/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script type="text/javascript" src="ace/js/excanvas.min.js"></script>
          <script type="text/javascript" src="ace/js/html5shiv.min.js"></script>
		  <script type="text/javascript" src="ace/js/respond.min.js"></script>
		<![endif]-->
		<script type="text/javascript" src="ace/js/jquery-ui.custom.min.js"></script>
		<script type="text/javascript" src="ace/js/jquery.ui.touch-punch.min.js"></script>

		<!-- ace scripts -->
		<script type="text/javascript" src="ace/js/ace-elements.min.js"></script>
		<script type="text/javascript" src="ace/js/ace.min.js"></script>
		<script type="text/javascript" src="ace/js/ace-extra.min.js"></script>
        
        <script type="text/javascript">
            $(window).load(function () {
                //计算页面尺寸
                changeSize();
                //打开主页
                $('.page-content-area').children('iframe').not("#flexFrame").css('display', 'none');
                $('#homeFrame').css("display", "block");
                //加载flex，必须先设置为block，并且高度不�?0，页面才会实际预加载
                $('#flexFrame').css("display", "block").css("height",1);
                $('#flexFrame')[0].src = "Engine/main.html?" + "&UID=0&UName=&ULName=&SessionID=SPH4G145XLND0KECJOY44055&Theme=GreenBlue";
                //$('#flexFrame')[0].window.location.reload();
                Convert();
            }).resize(changeSize);

            $(function () {
                checkIsLogin(false);
                if (window.addEventListener) {
                    window.addEventListener("message", function (e) {
                        openTab("业务审批", "查看项目", "notification:Open_ProjectByProjectCaseNO:用户设置", e.data, true);
                    }, true);
                }
            });
            //�?测是否登�?
            function checkIsLogin(isShowMsg) {
                ajaxSnyc(null, 'Service/PortalService.asmx/checkIsLogin', '', function (r) {
                    var d = r.d;
                    if (typeof (d) == undefined) {
                        d = r.msg;
                    } else {
                        d = eval("(" + d + ")");
                        d = d.msg;
                    }

                    if (d.toLowerCase() == "false") {
                        document.location = "login.aspx";
                        if (isShowMsg) {
                            alert('登陆超时!');
                        }
                    } else {
                        setTimeout(function () {
                            checkIsLogin(true);
                        }, 10000);
                    }
                }, function (r, s, e) {
                    document.location = "login.aspx";
                    if (isShowMsg) {
                        alert('登陆超时!');
                    }
                });
            }
            function getUserId() {
                return document.getElementById('user').innerText;
            }
            var isOntime=false;
            //用于刷新箱子在办数据统计徽章
            function refreshAllProject() {
                refreshProject("#在办�?", "0");
                refreshProject("#在办公示公告", "2");
                refreshProject("#合同在办�?", "3");
            }
            
            function refreshProject(id, bizType) {
                //清除现有数据
                $(id).find(".badge").remove();
                $(id).parent().parent().prev().prev().find(".numtip").remove();
                //查询新数�?
                ajaxSnyc(id, "Service/StatisticWS.asmx/SumOfProjects", '{"userid":0,"username":"","bizType":"' + bizType + '"}', function (responseText) { addNumber(responseText, id); });
            }

            function refreshEaccept(id) {
                //清除现有数据
                $(id).find(".badge").remove();
                $(id).parent().parent().prev().prev().find(".numtip").remove();
                //查询新数�?
                ajaxSnyc(id, "Service/StatisticWS.asmx/SumOfEaccept", '{"userid":0,"username":""}', function (responseText) { addNumber(responseText, id); });
            }

            function refreshReview(id) {
                //清除现有数据
                $(id).find(".badge").remove();
                $(id).parent().parent().prev().prev().find(".numtip").remove();
                //查询新数�?
                ajaxSnyc(id, "Service/StatisticWS.asmx/SumOfReviews", '{"userid":0,"username":""}', function (responseText) { addNumber(responseText, id); });
            }

            function addNumber(responseText, id) {
                $(id).parent().parent().prev().prev().append("<div class=\"numtip\"><div>");
            }
        </script>
</body>

</html>
