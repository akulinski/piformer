<html>
<head>
    <title>Main Dashboard</title>
</head>
<body>


<div class="container">

    <div class="row">

        <div class="col-xs-1">


            <div class="card-columns">

                <#list devices as device>

                    <div class="card">
                        <img class="card-img-top" src="holder.js/100x180/" alt="">
                        <div class="card-body">

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
