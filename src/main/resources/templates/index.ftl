<html>
<head>

    <title>Main Dashboard</title>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <link rel="stylesheet" href="../static/index.css">

</head>
<body>

<#include "./navbar.html" >

<div class="container">

    <div class="row">

        <div class="col-xs-1">


            <div class="card-columns">

                <#list devices as device>

                    <div class="card">

                        <div class="card-body">

                            <div class="card-header">
                            </div>

                            <h4 class="card-title">${device.name}</h4>


                            <#if device.temperatures?size != 0>
                                <div class="temperatures">

                                    <p class="card-text">temperatures</p>

                                    <#list device.temperatures as k,v>

                                        <ul class="list-inline">
                                            <li class="list-inline-item">${v}</li>
                                        </ul>
                                    </#list>
                                </div>

                            </#if>




                            <#if device.fanSpeeds?size != 0>
                                <div class="rpms">

                                    <p class="card-text">RPMS</p>

                                    <#list device.fanSpeeds as k,v>

                                        <ul class="list-inline">
                                            <li class="list-inline-item">${v}</li>
                                        </ul>
                                    </#list>

                                </div>
                            </#if>


                        </div>

                    </div>


                </#list>


            </div>


        </div>


    </div>

</div>


<ul>
</ul>

</body>
</html>
